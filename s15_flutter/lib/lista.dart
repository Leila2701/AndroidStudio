import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:s15_flutter/AgregarProducto/Producto_Page.dart';
import 'package:s15_flutter/EliminarProducto/EliminarProducto.dart';
import 'EditarProducto/Editar_Page.dart';

class ListarProductos extends StatefulWidget {
  ListarProductos({key}) : super(key: key);
  @override
  _ListarProductosState createState() => _ListarProductosState();
}

class _ListarProductosState extends State<ListarProductos> {
  late List list;
  final productosDelete = new ProductosDelete();
  Future getProductos() async {
    var url = 'http://192.168.0.7:80/flutter/controlador/productoControler.php?op=2';
    final response = await http.get(Uri.parse(url), headers: {
      "Accept": "aplication/json",
    });
    return json.decode(response.body);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Lista de Productos'),
        actions:[
          // ignore: deprecated_member_use
          RaisedButton(
            onPressed: () {
              Navigator.of(context).push(
                MaterialPageRoute(builder: (BuildContext ctx) => Producto()));
            },
            child: Text('Agregar'),
            color: Colors.pink,
            textColor: Colors.white,
          )
        ],
      ),
      body: Container(
        child: FutureBuilder(
            future:getProductos(),
            builder: (context, AsyncSnapshot snapshot) {
              if(snapshot.hasData){
                print(snapshot.hasError);
              }else{
              }
              return snapshot.hasData
                  ?Scrollbar(
                  child:ListView.builder(
                      itemCount: snapshot.data!.length,
                      itemBuilder: (BuildContext context,int index){
                        list=snapshot.data;
                        String id = list[index]['ID'];
                        print(list.length);
                        return Column(
                          children: <Widget>[
                            SizedBox(
                                width: 370,
                                child: ListTile(
                                  trailing: GestureDetector(
                                    child: IconButton(
                                      icon: Icon(Icons.delete),
                                        onPressed: (){
                                        setState(() {
                                          productosDelete
                                          .eliminarProducto(id);
                                        });
                                        }),
                                      ),
                                  onTap: () {
                                    Navigator.push(
                                        context,
                                        MaterialPageRoute(
                                            builder: (BuildContext context) =>
                                                EditarProducto(
                                                  list: list,
                                                  index: index,
                                                )));
                                  },
                                  title: Text(list[index]['NOMPRODD']),
                                  subtitle: Text(list[index]['PRECIOO']),
                                ),
                            )
                          ],
                        );
                      }))
                  :Center(
                child: CircularProgressIndicator(),
              );
            }),
      ),
    );
  }
}
