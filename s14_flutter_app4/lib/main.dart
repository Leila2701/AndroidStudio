import 'package:flutter/material.dart';
import 'package:s14_flutter_app4/Operacion.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    final titulo="Formulario Principal";
    return MaterialApp(home: Scaffold(appBar: AppBar(title: Text(titulo)),body:MyHomePage()));
  }

}



class MyHomePage extends StatelessWidget{
  final formkey=GlobalKey<FormState>();
  final txtNumero1=TextEditingController();
  final txtNumero2=TextEditingController();
  final txtResultado=TextEditingController();



  @override
  Widget build(BuildContext context)
  {
    return Form(
        key:formkey,
        child:Column(
            children:<Widget> [
              TextFormField(
                  controller:txtNumero1,
                  decoration: InputDecoration(
                      border: OutlineInputBorder(),
                      labelText: "Numero 1: "
                  ),
                  validator:(value)
                  {
                    if(value!.isEmpty){
                      return'Ingrese Primer Numero';
                    }
                  }
              ),
              TextFormField(
                  controller:txtNumero2,
                  decoration: InputDecoration(
                      border: OutlineInputBorder(),
                      labelText: "Numero 2: "
                  ),
                  validator:(value)
                  {
                    if(value!.isEmpty){
                      return'Ingrese segundo Numero';
                    }
                  }
              ),
              Padding(
                  padding:const EdgeInsets.symmetric(vertical: 19,horizontal: 150),
                  child: RaisedButton(
                      onPressed: (){
                        if(formkey.currentState!.validate()){
                          Scaffold.of(context).showSnackBar(SnackBar(content: Text("Procesando Datos")));

                          Operacion objeto=new Operacion();
                          int n1=int.parse(txtNumero1.text);

                          int n2=int.parse(txtNumero2.text);

                          String mensaje= objeto.calcularProducto(n1, n2);

                          txtResultado.text=mensaje;

                        }

                      },
                      child: Text("Calcular")
                  )
              ),
              TextFormField(maxLines: 9,
                  controller:txtResultado,
                  decoration: InputDecoration(
                      border: OutlineInputBorder(),
                      labelText: "Resultado: "
                  )
              ),
            ]
        )
    );
  }

}

