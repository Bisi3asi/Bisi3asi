import 'package:coop_hufs/Notice_detail.dart';
import 'package:coop_hufs/main.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:html/dom.dart' as dom;
import 'package:html/parser.dart';
import 'dart:async';
import 'package:web_scraper/web_scraper.dart';
import 'package:url_launcher/url_launcher.dart';
import 'main.dart';

//https://gist.github.com/StrykerKKD/44c897dbe1877b767cbf/revisions : dom 참고

class Notice extends StatefulWidget {
  Notice({Key key}) : super(key: key);

  @override
  _NoticeState createState() => _NoticeState();
}

class _NoticeState extends State<Notice> {
  var title = new List(); //제목을 긁어옵니다.
  String temp;

  var link = new List(); //a href link를 긁어옵니다.
  List<Map<String, dynamic>> temp2;

  int pageCnt = 1; //pagecount

  Future<String> getData() async {
    final response = await http.get(
        'http://coop.hufs.ac.kr/bbs/board.php?bo_table=notice&page=' +
            pageCnt.toString());

    if (response.statusCode == 200) {
      // 만약 서버로의 요청이 성공하면, JSON을 파싱합니다.
      dom.Document document = parse(response.body);
      //title parse : use dom
      document
          .getElementsByClassName("media-list-subject")
          .forEach((dom.Element element) {
        temp = element.text;

        this.setState(() {
          title.add(temp);
        });
      });

      //a href parse : use web_scraper
      final webScraper = WebScraper('http://coop.hufs.ac.kr');
      if (await (webScraper.loadWebPage(
          '/bbs/board.php?bo_table=notice&page=' + pageCnt.toString()))) {
        temp2 = webScraper.getElement("td.mw_basic_list_subject > a", ["href"]);
        for (int index = 0; index < temp2.length; index += 2) {//홀수번째가 링크 주소들
          this.setState(() {
            link.add(temp2[index]['attributes']['href']);
          });
        }
      }
      return "success";
    } else {
      // 만약 요청이 실패하면, 에러를 던집니다.
      throw Exception('Failed to load post');
    }
  }

  @override
  void initState() {
    super.initState();
    this.getData();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('생협 공지사항'),
        centerTitle: true,
        backgroundColor: Colors.brown,
        elevation: 0.0,
      ),
      body: ListView.separated(
          itemCount: title == null ? 0 : title.length + 1,
          separatorBuilder: (BuildContext context, int index) => Divider(),
          itemBuilder: (BuildContext context, int index) {
            if (index == title.length) {
              return Container(
                color: Colors.brown,
                child: ListTile(
                  title: Text(
                    pageCnt.toString(),
                    textAlign: TextAlign.center,
                    style: TextStyle(color: Colors.white),
                  ),
                  trailing: FlatButton(
                    onPressed: () {
                      pageCnt++; //다음 페이지로 이동
                      this.setState(() {
                        title.clear(); //초기화 후
                        link.clear();
                        getData(); //다시 가져옴
                      });
                    },
                    child: Icon(
                      Icons.navigate_next,
                      color: Colors.white,
                    ),
                  ),
                  leading: FlatButton(
                    onPressed: () {
                      if (pageCnt == 1) {
                        return;
                      } else {
                        pageCnt--; //이전 페이지로 이동
                        this.setState(() {
                          title.clear(); //초기화 후
                          link.clear();
                          getData(); //다시 가져옴
                        });
                      }
                    },
                    child: Icon(
                      Icons.navigate_before,
                      color: Colors.white,
                    ),
                  ),
                ),
              );
            }
            return ListTile(
              title: Text(title[index]),
              onTap: (){
                Navigator.push(
                  context,
                  MaterialPageRoute( //인자값 NoticeDetail로 전달.
                    builder: (context) => NoticeDetail(url: link[index]),
                  )
                );
              },
            );
          }),
    );
  }
}
