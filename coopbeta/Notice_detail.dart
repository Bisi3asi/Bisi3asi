import 'package:flutter/material.dart';
import 'dart:ui';
import 'package:webview_flutter/webview_flutter.dart';
import 'package:flutter/cupertino.dart';
import 'package:coop_hufs/Notice.dart';
import 'main.dart';

//http://murmurblog.com/flutter-responsive-ui/


class NoticeDetail extends StatefulWidget {
  final String url; //url 수신해 저장

  NoticeDetail({Key key, @required this.url}) : super(key: key);
  @override
  _NoticeDetailState createState() => _NoticeDetailState();

}

class _NoticeDetailState extends State<NoticeDetail>{
  String url;

  @override //인자값을 widget에서 밑의 state으로 넘긴다.
  void initState(){
    super.initState();
    url= widget.url;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('생협 공지사항'),
        backgroundColor: Colors.brown,
        centerTitle: true,
        //centertitle
        elevation: 0.0, //입체감
      ),
      body: SafeArea(
        child: WebView(
          initialUrl: url,
          javascriptMode: JavascriptMode.unrestricted,
          onPageFinished: (String url) {
            print('finished:' + url);
          },
        ),
      ),
    );
  }
}
