
import 'package:coop_hufs/Food_detail.dart';
import 'package:flutter/material.dart';
import 'dart:ui';
import 'package:flutter_swiper/flutter_swiper.dart';

//https://www.youtube.com/watch?v=sW9lla-D09A

class FoodStore extends StatefulWidget {
  FoodStore({Key key, this.title}) : super(key: key);
  final String title;

  @override
  _FoodStoreState createState() => _FoodStoreState();
}

class _FoodStoreState extends State<FoodStore> {
  @override
  Widget build(BuildContext context) {
    var mediaQuery = MediaQuery.of(context); //화면 방향, 화면 크기 정보 반환
    final widthsize = mediaQuery.size.width;
    final heightsize = mediaQuery.size.height;

    return Scaffold(
      appBar: AppBar(
        title: Text('교내 학식 & 생협 매장 정보'),
        backgroundColor: Colors.orange,
        centerTitle: true,
        //centertitle
        elevation: 0.0, //입체감
      ),
      body: SafeArea(
        child: Container(
          child: Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.start,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: <Widget>[
                SizedBox(height: 10.0,),
                Container(
                  decoration: BoxDecoration(
                    color: Colors.orange[300],
                ),
                  child: Column(
                    children: <Widget>[
                      SizedBox(height: 10.0),
                      Container(
                        child: Text(
                          '생협 매장 정보',
                          textAlign: TextAlign.left,
                          style: TextStyle(
                            fontWeight: FontWeight.bold,
                            fontSize: 20,
                            color: Colors.white,
                          ),
                        ),
                      ),
                      SizedBox(
                        height: 10.0,
                      ),
                      Container(
                        decoration: BoxDecoration(
                          color: Colors.black,
                          borderRadius: BorderRadius.all(Radius.circular(0)),
                        ),
                        width: widthsize,
                        height: heightsize * 2/7,
                        child: Padding(
                          padding: EdgeInsets.all(1),
                          child: Swiper(
                            autoplay: true,
                            duration: 1000,
                            autoplayDelay: 4000,
                            scale: 1.0,
                            viewportFraction: 1.0,
                            control: SwiperControl(),
                            pagination: SwiperPagination(),
                            itemCount: storeList.length,
                            itemBuilder: (BuildContext context, int index) {
                              return Image.network(
                                storeList[index],
                                height: heightsize * 2/7,
                                width: widthsize-10,
                              );
                            },
                          ),
                        ),
                      ),
                      SizedBox(height: 28.0),
                    ],
                  ),
                ),
                SizedBox(height: 10.0,),
                Container(
                  decoration: BoxDecoration(
                    color: Colors.orange[200],
                  ),
                  child: Column(
                    children: <Widget>[
                      SizedBox(height: 10.0),
                      Container(
                        child: Text(
                          '교내 학식 정보',
                          textAlign: TextAlign.left,
                          style: TextStyle(
                            fontWeight: FontWeight.bold,
                            fontSize: 20,
                            color: Colors.white,
                          ),
                        ),
                      ),
                      SizedBox(
                        height: 10.0,
                      ),
                      Container(
                        decoration: BoxDecoration(
                          color: Colors.black,
                          borderRadius: BorderRadius.all(Radius.circular(0)),
                        ),
                        width: widthsize,
                        height: heightsize * 2/7,
                        child: Padding(
                          padding: EdgeInsets.all(1),
                          child: Swiper(
                            autoplay: true,
                            duration: 1000,
                            autoplayDelay: 4000,
                            scale: 1.0,
                            viewportFraction: 1.0,
                            control: SwiperControl(),
                            pagination: SwiperPagination(),
                            itemCount: foodList.length,
                            itemBuilder: (BuildContext context, int index) {
                              return FlatButton(//임시로 food_detail로 연결
                                onPressed: (){
                                  Navigator.push(
                                      context,
                                      MaterialPageRoute(
                                        builder: (context) => FoodDetail(),
                                      )
                                  );
                                },
                                child: Image.asset(
                                  foodList[index],
                                  height: heightsize * 2/7,
                                  width: widthsize-10,
                                ),
                              );
                            },
                          ),
                        ),
                      ),
                      SizedBox(height: 28.0),
                    ],
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}

final List<String> storeList = [
  'http://coop.hufs.ac.kr/sub/img/m_img_01.jpg',
  'http://coop.hufs.ac.kr/sub/img/qc_img_02.jpg',
  'http://coop.hufs.ac.kr/sub/img/u_img_01.jpg',
  'http://coop.hufs.ac.kr/sub/img/thumb/t_img_01.jpg',
  'http://coop.hufs.ac.kr/sub/img/thumb/q_img_05.jpg',
];

final List<String> foodList = [
  'assets/hst.png',
  'assets/hpf.png',
  'assets/lst.png',
  'assets/dorm.png',
];
