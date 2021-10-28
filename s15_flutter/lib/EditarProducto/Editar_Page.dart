import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:s15_flutter/AgregarProducto/AgregarProducto.dart';
import 'package:s15_flutter/lista.dart';
import 'package:http/http.dart' as http;

class EditarProducto extends StatefulWidget{
  final List list;
  final int index;
  EditarProducto({required this.list, required this.index});
  @override
  _ProductoState createState() => _ProductoState();
}

class _ProductoState extends State<EditarProducto>{
  final productosProvider = new ProductosProvider();
  final GlobalKey<FormState> _formKey = GlobalKey<FormState>();
  bool _autoValidate = false;
  late String nameProd;
  late String costo;
  late TextEditingController nomProd;
  late TextEditingController precio;
  late TextEditingController id;

  Future _editar() async{
    var url=
        'http://192.168.0.7:80/flutter/controlador/productoControler.php?op=4';
    final response = await http.post(Uri.parse(url), body:{
      "ID": widget.list[widget.index]['ID'],
      "NOMPRODD":nomProd.text,
      "PRECIOO": precio.text
    });
    return json.decode(response.body);
  }

  @override
  void initState(){
    nomProd=
        new TextEditingController(text: widget.list[widget.index]['NOMPRODD']);
    precio=
        new TextEditingController(text: widget.list[widget.index]['PRECIOO']);
    super.initState();
  }
  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar:AppBar(
        title:Text('Editar Productos'),
      ),
      body:Container(
        child: Padding(
            padding: const EdgeInsets.all(40.0),
            child:Form(
              key: _formKey,
              autovalidate : _autoValidate,
              child: Column(
                children: [_nomProducto(),_precio(),_btnEditar()],
              ),
            )
        ),
      ),
    );
  }

  Widget _nomProducto(){
    return TextFormField(
      controller: nomProd,
      decoration: InputDecoration(
        border: OutlineInputBorder(),
        hintText: 'Ingrese nombre del producto',
      ),
      validator: (String? valor){
        if (valor!.length < 1)
          return 'Por favor ingrese el nombre del producto';
        else
          return null;
      },
      onSaved: (String? val){
        nameProd = val!;
      },
    );
  }
  Widget _precio(){
    return TextFormField(
      controller: precio,
      decoration: InputDecoration(
        border: OutlineInputBorder(),
        hintText: 'Ingrese el precio',
      ),
      validator: (String? valor){
        if (valor!.length < 1)
          return 'Por favor ingrese el precio del producto';
        else
          return null;
      },
      onSaved: (String? val){
        costo = val!;
      },
    );
  }
  Widget _btnEditar(){
    return RaisedButton(
      onPressed: (){
        _validar();
      },
      child:Text('Editar'),
    );
  }
  void _validar(){
    if(_formKey.currentState!.validate()){
      _formKey.currentState!.save();
      _editar();
      Navigator.pushReplacement(
          context,
          MaterialPageRoute(
              builder: (BuildContext context) => ListarProductos()));
    }else{
      setState(() {
        _autoValidate=true;
      });
    }
  }
}
