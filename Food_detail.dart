import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:webview_flutter/webview_flutter.dart';


class FoodDetail extends StatefulWidget {
  FoodDetail({Key key}) : super(key: key);

  @override
  _FoodDetailState createState() => _FoodDetailState();
}

class _FoodDetailState extends State<FoodDetail> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('교내 학식 정보'),
        backgroundColor: Colors.orange,
        centerTitle: true,
        elevation: 0.0,
      ),
      body: SafeArea(
        child: WebView(
          initialUrl: 'https://webs.hufs.ac.kr/jsp/HUFS/cafeteria/frame_view.jsp',
          javascriptMode: JavascriptMode.unrestricted,
          onPageFinished: (String url) {
            print('finished:' + url);
          },
        ),
      ),
    );
  }
}
