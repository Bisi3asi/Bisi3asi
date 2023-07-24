import 'package:flutter/material.dart';
import 'dart:ui';

class Payment extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('생협 매장 원터치 결제'),
        centerTitle: true,
        //centertitle
        elevation: 0.0, //입체감
      ),
      endDrawer: Drawer(
        //endDrawer 속성은 오른쪽 drawer, 일반적 drawer는 왼쪽
        child: ListView(
          //ListView 내부: (1)UserAccountDrawerHeader, (2)ListTile
          padding: EdgeInsets.zero,
          children: <Widget>[
            UserAccountsDrawerHeader(
              currentAccountPicture: CircleAvatar(
                backgroundImage: AssetImage('assets/blue.png'),
                backgroundColor: Colors.white,
              ),
              accountName: Text('김외대'),
              accountEmail: Text('kimhufs@coop.com'),
              onDetailsPressed: () {
                print('arrow is clicked');
              },
              decoration: BoxDecoration(
                  color: Colors.green,
                  borderRadius: BorderRadius.only(
                    bottomLeft: Radius.circular(30.0),
                    bottomRight: Radius.circular(30.0),
                  )),
            ),
            ListTile(
              leading: Icon(Icons.perm_identity, //trailing은 오른쪽에 배치
                color: Colors.grey[850],
              ),
              title:Text('생협 조합원 신분증'),
              onTap: (){
                print('생협 조합원 신분증 버튼이 클릭되었습니다');
                Navigator.pushNamed(context, '/i');
              },
            ),
            ListTile(
              leading: Icon(Icons.notifications,
                color: Colors.grey[850],
              ),
              title:Text('생협 공지사항'),
              onTap: (){
                print('생협 공지사항 버튼이 클릭되었습니다');
                Navigator.pushNamed(context, '/n');
              },
            ),
            ListTile(
              leading: Icon(Icons.attach_money,
                color: Colors.grey[850],
              ),
              title:Text('출자금 정보'),
              onTap: (){
                print('출자금 정보 버튼이 클릭되었습니다');
                Navigator.pushNamed(context, '/c');
              },
            ),
            ListTile(
              leading: Icon(Icons.payment,
                color: Colors.grey[850],
              ),
              title:Text('생협 매장 원터치 결제'),
              onTap: (){
                print('생협 매장 원터치 결제 버튼이 클릭되었습니다');
                Navigator.pushNamed(context, '/p');
              },
            ),
            ListTile(
              leading: Icon(Icons.restaurant,
                color: Colors.grey[850],
              ),
              title:Text('교내 학식 & 생협 매장 정보'),
              onTap: (){
                print('학식/교내 생협 매장 정보 버튼이 클릭되었습니다');
                Navigator.pushNamed(context, '/f');
              },
            ),
            ListTile(
              leading: Icon(Icons.web,
                color: Colors.grey[850],
              ),
              title:Text('생협 홈페이지 접속'),
              onTap: (){
                print('생협 홈페이지 접속 버튼이 클릭되었습니다');
              },
            ),
            ListTile(
              leading: Icon(Icons.wb_sunny,
                color: Colors.grey[850],
              ),
              title:Text('오늘의 날씨'),
              onTap: (){
                print('오늘의 날씨 버튼이 클릭되었습니다');
                Navigator.pushNamed(context, '/n');
              },
            ),
          ],
        ),
      ),
    );
  }
}