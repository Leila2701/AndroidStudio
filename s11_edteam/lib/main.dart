import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primaryColor: Colors.white,
      ),
      home: EDteamHome(),
    );
  }
}

class EDteamHome extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        //despegable(menu hamburguesa), no aparece cuando se ponen los iconos
        endDrawer: Drawer(),
        //barra arriba
        appBar: AppBar(
          title: Image.asset(
            "assets/images/logo.png",
            height: 40.0,
          ),
          actions: <Widget>[
            InkWell(
              child: Image.asset(
                "assets/images/schedule.png",
                height: 30.0,
                width: 30.0,
              ),
              onTap: () {
                print("Hello word!");
              },
            ),
            Image.asset(
              "assets/images/talk.png",
              height: 30.0,
              width: 30.0,
            ),
            Icon(Icons.search),
            InkWell(
              onTap: () {},
              child: Padding(
                padding: EdgeInsets.symmetric(horizontal: 16.0),
                child: Icon(Icons.dehaze),
              ),
            ),
          ],
        ),
        body: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            Padding(
              padding: const EdgeInsets.all(12.0),
              child: Text(
                "Continúa Estudiando",
                style: TextStyle(
                    color: Colors.grey,
                    fontWeight: FontWeight.w600,
                    fontSize: 20.0),
              ),
            ),
            Container(
              height: 150.0,
              child: ListView.builder(
                scrollDirection: Axis.horizontal,
                itemCount: 10,
                itemBuilder: (context, position) {
                  return Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Container(
                      width: 200.0,
                      height: 150.0,
                      color: Colors.blue,
                      child: Text("Posicion $position"),
                    ),
                  );
                },
              ),
            ),
            DefaultTabController(
              length: 3,
              child: Expanded(
                child: Column(
                  children: <Widget>[
                    TabBar(
                      unselectedLabelColor: Colors.grey,
                      indicatorColor: Colors.blue,
                      tabs: [
                        Tab(
                          text: "Cursos",
                        ),
                        Tab(text: "Workshops"),
                        Tab(
                          text: "Especialidades",
                        ),
                      ],
                    ),
                    Expanded(
                      child: TabBarView(
                        children: [
                          GridView.builder(
                            gridDelegate:
                                SliverGridDelegateWithFixedCrossAxisCount(
                              crossAxisCount: 2,
                            ),
                            itemBuilder: (context, position) {
                              return Padding(
                                padding: const EdgeInsets.all(8.0),
                                child: Container(
                                  width: 200.0,
                                  height: 50.0,
                                  child: Image.asset("assets/images/logo.png",),
                                ),
                              );
                            },
                          ),
                          Container(color: Colors.yellow),
                          Container(color: Colors.blue),
                        ],
                      ),
                    ),
                  ],
                ),
              ),
            ),
          ],
        ));
  }
}
