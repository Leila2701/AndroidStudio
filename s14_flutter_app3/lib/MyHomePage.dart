import 'package:flutter/material.dart';

class MyHomePage extends StatelessWidget
{
  @override
  Widget build(BuildContext context)
  {
    return MaterialApp(theme: ThemeData(primaryColor: Colors.yellow), home:Scaffold(appBar: AppBar(title: Text("My Tittle")),
      body: Center(child: Column(children: <Widget>[SizedBox(height: 80),RaisedButton(onPressed: (){},child: Text("Presionar"))]) ),

    ));
  }

}