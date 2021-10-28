package ucv.android.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UsuarioDAO {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    public UsuarioDAO(Context contexto) {dbHelper=new MySQLiteHelper(contexto);}

    public void open()throws SQLException {
        database=dbHelper.getWritableDatabase();
    }
    public void close() throws SQLException{
        dbHelper.close();
    }

    public long insertar(String nom, String pass){
        long estado=0;
        try{
            ContentValues valores=new ContentValues();
            valores.put("nombre",nom);
            valores.put("clave",pass);

            estado=database.insert("usuario" ,null, valores);
        }catch(Exception e){
            estado=0;
        }
        return estado;
    }

    public ArrayList<Usuario> Buscar(String nombre,String clave){

        Cursor c;
        ArrayList<Usuario> listado=new ArrayList<Usuario>();
        c=database.rawQuery("select * from usuario where nombre='"+nombre+" ' && clave='"+clave+"'", null);
        while (c.moveToNext()){
            Usuario objUsuario=new Usuario();
            objUsuario.setCodigo(c.getInt(0));
            objUsuario.setNombre(c.getString(1));
            objUsuario.setClave(c.getString(2));

            listado.add(objUsuario);
        }
        c.close();
        return listado;

    }

    public ArrayList<Usuario> ListadoGeneral(){
        Cursor c;
        ArrayList<Usuario> listado=new ArrayList<Usuario>();
        c=database.rawQuery("select * from usuario", null);
        while (c.moveToNext()){
            Usuario objUsuario=new Usuario();
            objUsuario.setCodigo(c.getInt(0));
            objUsuario.setNombre(c.getString(1));
            objUsuario.setClave(c.getString(2));

            listado.add(objUsuario);
        }
        c.close();
        return listado;
    }
    public int login(String nombre,String clave){
        int a=0;
        Cursor c;
        c=database.rawQuery("select * from usuario",null);
        if (c!=null&&c.moveToFirst()){
            do{
                if(c.getString(1).equals(nombre) && c.getString(2).equals(clave)){
                    a++;
                }
            }while(c.moveToNext());
        }
        return a;
    }
}
