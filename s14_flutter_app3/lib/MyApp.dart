import 'package:flutter/material.dart';
import 'package:s14_flutter_app3/MyHomePage.dart';

class MyApp extends StatelessWidget
{
  @override
  Widget build(BuildContext context)
  {
    //se esta creando un objeto, ya no es necesario que vaya el operador new
    return MaterialApp( home: MyHomePage() );
  }

}