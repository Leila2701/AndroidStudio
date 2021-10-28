import 'dart:convert';
import 'package:http/http.dart' as http;

class ProductosProvider{
  final String _url=
      'http://192.168.0.7:80/flutter_examen/controlador/productoControler.php';

  Future<bool> agregarProducto(String nompla, String precio) async{
    try{
      final url ='$_url/?op=1&NOMPLA=$nompla&PRECIOO=$precio';

      final resp=await http.post(Uri.parse(url));

      final decodedData=json.decode(resp.body);
      print(decodedData);
      print(url);
      if(resp.statusCode == 200){
        print(resp.statusCode);
      }
    }catch(e){
      print(e);
    }
    return true;
  }
}