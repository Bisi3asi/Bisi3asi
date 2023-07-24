
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart'; //가로모드 방지
import 'dart:ui';
import 'Contribution.dart';
import 'Identification.dart';
import 'Home.dart';
import 'Food.dart';
import 'Notice.dart';
import 'Notice_detail.dart';
import 'Weather.dart';
import 'Payment.dart';
import 'MyHomePage.dart';
import 'Notice_detail.dart';


void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    SystemChrome.setPreferredOrientations([DeviceOrientation.portraitUp]); //세로모드로 고정

    return MaterialApp(
      title: 'coop_hufs',
      theme: ThemeData(primarySwatch: Colors.green),
      initialRoute: '/', //flutter 기본 설정, 멀티페이지 이동
      routes: {'/': (context) => Home(), //기본으로 MainPage을 불러옴
    '/c': (context) => Contribution(), //출자금
    '/i': (context) => Identification(), //조합원증
    '/f': (context) => FoodStore(), //식당, 매장 정보
    '/n': (context) => Notice(), //공지사항
    '/p': (context) => Payment(), //결제
    '/w': (context) => Weather(), //날씨
    '/h': (context) => MyHomePage(), //생협 홈페이지 접속
    '/nd': (context) => NoticeDetail(), //세부 공지사항
    }

    );
  }
}
