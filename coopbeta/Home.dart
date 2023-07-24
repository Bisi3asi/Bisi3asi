import 'package:flutter/material.dart';
import 'dart:ui';

class Home extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    var mediaQuery = MediaQuery.of(context); //화면 방향, 화면 크기 정보 반환
    final widthsize = mediaQuery.size.width;
    final heightsize = mediaQuery.size.height;
    final contheight = (heightsize * 1 / 5) * 4 / 7;

    Future<bool> _onBackPressed() {
      //뒤로가기 종료 메소드, android
      return showDialog(
            context: context,
            builder: (context) => AlertDialog(
              title: Text("생협 모바일 조합원증을\n종료하시겠어요?"),
              actions: <Widget>[
                FlatButton(
                  child: Text("취소"),
                  onPressed: () => Navigator.pop(context, false),
                ),
                FlatButton(
                  child: Text("종료"),
                  onPressed: () => Navigator.pop(context, true),
                ),
              ],
            ),
          ) ??
          false;
    }

    return WillPopScope(
      child: Scaffold(
        appBar: AppBar(
          title: Text('한국외대 생활협동조합 모바일'),
          centerTitle: true, //centertitle
          elevation: 0.0, //입체감
          leading: FlatButton(
            splashColor: Colors.transparent,
            highlightColor: Colors.transparent,
            child: Icon(
              Icons.arrow_back,
              color: Colors.white,
            ),
            onPressed: _onBackPressed,
          ),
        ),
        body: WillPopScope(
          onWillPop: _onBackPressed,
          child: SafeArea(
            //Container : alt+ enter 후 widget으로 감싸 SafeArea로 지정.
            child: Center(
              child: Column(
                mainAxisSize: MainAxisSize.min,
                mainAxisAlignment: MainAxisAlignment.center, //가로축 정렬
                children: <Widget>[
                  RaisedButton(
                    //raisedbutton wrap-> onPressed
                    elevation: 0.0,
                    color: Colors.transparent,
                    highlightColor: Colors.transparent,
                    highlightElevation: 0.0,
                    splashColor: Colors.transparent,

                    onPressed: () {
                      Navigator.pushNamed(context, '/i');
                    },
                    child: Container(
                      width: widthsize * 7 / 9,
                      height: heightsize * 1 / 5,
                      decoration: BoxDecoration(
                          color: Colors.green,
                          borderRadius: BorderRadius.all(
                            Radius.circular(20.0),
                          ),
                          border: Border.all(width: 1.0, color: Colors.white)),
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: <Widget>[
                          Container(
                            width: contheight,
                            height: contheight,
                            decoration: BoxDecoration(
                              border: Border.all(width: 1.0, color: Colors.white),
                              borderRadius:
                                  BorderRadius.all(Radius.circular(100)),
                            ),
                            child: Icon(
                              Icons.perm_identity,
                              color: Colors.white,
                              size: contheight * 5 / 6,
                            ),
                          ),
                          Text(
                            '\n생협 모바일 조합원증',
                            textAlign: TextAlign.center,
                            style: TextStyle(
                              fontSize: 18,
                              color: Colors.white,
                            ),
                          ),
                        ],
                      ),
                    ),
                  ),
                  SizedBox(height: 10.0),
                  RaisedButton(
                    elevation: 0.0,
                    color: Colors.transparent,
                    highlightColor: Colors.transparent,
                    highlightElevation: 0.0,
                    splashColor: Colors.transparent,
                    onPressed: () {
                      Navigator.pushNamed(context, '/p');
                    },
                    child: Container(
                      width: widthsize * 7 / 9,
                      height: heightsize * 1 / 5,
                      decoration: BoxDecoration(
                        color: Colors.lightBlueAccent,
                        borderRadius: BorderRadius.all(
                          Radius.circular(20.0),
                        ),
                        border: Border.all(width: 1.0, color: Colors.white),
                      ),
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: <Widget>[
                          Container(
                            width: contheight,
                            height: contheight,
                            decoration: BoxDecoration(
                              border: Border.all(width: 1.0, color: Colors.white),
                              borderRadius:
                                  BorderRadius.all(Radius.circular(100)),
                            ),
                            child: Icon(
                              Icons.touch_app,
                              color: Colors.white,
                              size: contheight * 5 / 7,
                            ),
                          ),
                          Text(
                            '\n생협 매장 원터치 결제',
                            textAlign: TextAlign.center,
                            style: TextStyle(
                              fontSize: 18,
                              color: Colors.white,
                            ),
                          ),
                        ],
                      ),
                    ),
                  ),
                  SizedBox(height: 10.0),
                  RaisedButton(
                    elevation: 0.0,
                    color: Colors.transparent,
                    highlightColor: Colors.transparent,
                    highlightElevation: 0.0,
                    splashColor: Colors.transparent,
                    onPressed: () {
                      Navigator.pushNamed(context, '/n');
                    },
                    child: Container(
                      width: widthsize * 7 / 9,
                      height: heightsize * 1 / 5,
                      decoration: BoxDecoration(
                        color: Colors.brown[600],
                        borderRadius: BorderRadius.all(
                          Radius.circular(20.0),
                        ),
                        border: Border.all(width: 1.0, color: Colors.white),
                      ),
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: <Widget>[
                          Container(
                            width: contheight,
                            height: contheight,
                            decoration: BoxDecoration(
                              border: Border.all(width: 1.0, color: Colors.white),
                              borderRadius:
                                  BorderRadius.all(Radius.circular(100)),
                            ),
                            child: Icon(
                              Icons.notifications,
                              color: Colors.white,
                              size: contheight * 5 / 6,
                            ),
                          ),
                          Text(
                            '\n생협 공지사항',
                            textAlign: TextAlign.center,
                            style: TextStyle(
                              fontSize: 18,
                              color: Colors.white,
                            ),
                          ),
                        ],
                      ),
                    ),
                  ),
                  SizedBox(height: 10.0),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: <Widget>[
                      ButtonTheme(
                        minWidth: widthsize * 7 / 18 - 5,
                        height: heightsize * 1 / 5,
                        buttonColor: Colors.amber,
                        child: RaisedButton(
                          elevation: 0.0,
                          color: Colors.amber[700],
                          highlightColor: Colors.transparent,
                          highlightElevation: 0.0,
                          splashColor: Colors.transparent,
                          shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(20.0),
                              side: BorderSide(color: Colors.white)),
                          onPressed: () {
                            Navigator.pushNamed(context, '/c');
                          },
                          child: Text(
                            '출자금 정보',
                            textAlign: TextAlign.center,
                            style: TextStyle(
                              fontSize: 18,
                              color: Colors.white,
                            ),
                          ),
                        ),
                      ),
                      SizedBox(width: 10.0),
                      ButtonTheme(
                        minWidth: widthsize * 7 / 18 - 5,
                        height: heightsize * 1 / 5,
                        buttonColor: Colors.amber,
                        child: RaisedButton(
                          elevation: 0.0,
                          color: Colors.amber[700],
                          highlightColor: Colors.transparent,
                          highlightElevation: 0.0,
                          splashColor: Colors.transparent,
                          shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(20.0),
                              side: BorderSide(color: Colors.white)),
                          onPressed: () {
                            Navigator.pushNamed(context, '/f');
                          },
                          child: Text(
                            '교내 학식 &\n생협 매장 정보',
                            textAlign: TextAlign.center,
                            style: TextStyle(
                              fontSize: 18,
                              color: Colors.white,
                            ),
                          ),
                        ),
                      ),
                    ],
                  )
                ],
              ),
            ),
          ),
        ),
        endDrawer: WillPopScope(
          onWillPop: (){},
          child: Drawer(
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
                  accountName: Text('김외대님'),
                  accountEmail: Text('한국외국어대학교 생활협동조합 조합원'),
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
                  leading: Icon(
                    Icons.perm_identity, //trailing은 오른쪽에 배치
                    color: Colors.grey[850],
                  ),
                  title: Text('생협 모바일 조합원증'),
                  onTap: () {
                    print('생협 조합원 신분증 버튼이 클릭되었습니다');
                    Navigator.pushNamed(context, '/i');
                  },
                ),
                ListTile(
                  leading: Icon(
                    Icons.notifications,
                    color: Colors.grey[850],
                  ),
                  title: Text('생협 공지사항'),
                  onTap: () {
                    print('생협 공지사항 버튼이 클릭되었습니다');
                    Navigator.pushNamed(context, '/n');
                  },
                ),
                ListTile(
                  leading: Icon(
                    Icons.attach_money,
                    color: Colors.grey[850],
                  ),
                  title: Text('출자금 정보'),
                  onTap: () {
                    print('출자금 정보 버튼이 클릭되었습니다');
                    Navigator.pushNamed(context, '/c');
                  },
                ),
                ListTile(
                  leading: Icon(
                    Icons.touch_app,
                    color: Colors.grey[850],
                  ),
                  title: Text('생협 매장 원터치 결제'),
                  onTap: () {
                    print('생협 매장 원터치 결제 버튼이 클릭되었습니다');
                    Navigator.pushNamed(context, '/p');
                  },
                ),
                ListTile(
                  leading: Icon(
                    Icons.restaurant,
                    color: Colors.grey[850],
                  ),
                  title: Text('교내 학식 & 생협 매장 정보'),
                  onTap: () {
                    print('학식/교내 생협 매장 정보 버튼이 클릭되었습니다');
                    Navigator.pushNamed(context, '/f');
                  },
                ),
                ListTile(
                  leading: Icon(
                    Icons.web,
                    color: Colors.grey[850],
                  ),
                  title: Text('생협 홈페이지 접속'),
                  onTap: () {
                    print('생협 홈페이지 접속 버튼이 클릭되었습니다');
                    Navigator.pushNamed(context, '/h');
                  },
                ),
                ListTile(
                  leading: Icon(
                    Icons.wb_sunny,
                    color: Colors.grey[850],
                  ),
                  title: Text('오늘의 날씨'),
                  onTap: () {
                    print('오늘의 날씨 버튼이 클릭되었습니다');
                    Navigator.pushNamed(context, '/j');
                  },
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
