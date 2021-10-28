package com.ucv.db2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class PersonaDAO {

    private  String nombre;

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;


    public PersonaDAO(Context contexto){
        dbHelper=new MySQLiteHelper(contexto);
    }

    public void open()throws SQLException{
        database=dbHelper.getWritableDatabase();
    }

    public void close() throws SQLException{
        dbHelper.close();
    }

    public long insertar(String nom, String apell, String dni){
        long estado=0;
            try{
                ContentValues valores=new ContentValues();
                valores.put("nombre",nom);
                valores.put("apellido",apell);
                valores.put("dni",dni);
                estado=database.insert("persona" ,null, valores);
            }catch (Exception e){
                estado=0;
            }
        return estado;
    }

    public long Eliminar(int dni){
        long estado=0;
            try{
                estado=database.delete("persona" ,"dni=?", new String[]{String.valueOf(dni)});
            }catch (Exception e){
                estado=0;
            }

        return estado;
    }

    public long modificarRegistro(String nombre, String apellido, String dni){
        long estado=0;
            try{
                ContentValues valores=new ContentValues();
                valores.put("nombre",nombre);
                valores.put("apellido",apellido);
                valores.put("dni",dni);
                estado=database.update("persona",valores, "dni="+dni,null);

            }catch (Exception e){
                estado=0;
            }
        return estado;
    }

    public ArrayList<Persona> ListadoGeneral(){
        Cursor c;
        ArrayList<Persona> listado=new ArrayList<Persona>();
        c=database.rawQuery("select * from persona", null);
        while (c.moveToNext()){
            Persona objPersona=new Persona();
            objPersona.setCodigo(c.getInt(0));
            objPersona.setNombre(c.getString(1));
            objPersona.setApellido(c.getString(2));
            objPersona.setDni(c.getString(3));
            listado.add(objPersona);
        }
        c.close();
        return listado;
    }


}
