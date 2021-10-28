import 'package:flutter/material.dart';

void main()
{
  Hijo obj=new Hijo("Yo soy Leila Cordova Ortiz");
  print(obj.toString());
}

class Hijo extends Padre
{

  Hijo(String mensaje): super('$mensaje');

}

class Padre
{
  late String mensaje;

  Padre(String mensaje)
  {
    this.mensaje=mensaje;
  }

  @override
  String toString() {
    return 'Padre{mensaje: $mensaje}';
  }
}
