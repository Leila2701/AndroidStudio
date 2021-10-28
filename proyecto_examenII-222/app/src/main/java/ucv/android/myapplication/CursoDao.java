package ucv.android.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class CursoDao {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    public CursoDao(Context contexto){
        dbHelper=new MySQLiteHelper(contexto);
    }

    public void open()throws SQLException {
        database=dbHelper.getWritableDatabase();
    }

    public void close() throws SQLException{
        dbHelper.close();
    }
    public long insertar(String nombrecurso, String nota){
        long estado=0;
        try{
            ContentValues valores=new ContentValues();
            valores.put("nombrecurso",nombrecurso);
            valores.put("nota",nota);

            estado=database.insert("curso" ,null, valores);
        }catch(Exception e){
            estado=0;
        }
        return estado;
    }
    public long modificarRegistro(String nombrecurso, String nota){
        long estado=0;
        try{
            ContentValues valores=new ContentValues();
            valores.put("nombrecurso",nombrecurso);
            valores.put("nota",nota);
            estado=database.update("curso",valores, "nombrecurso='"+nombrecurso+"'",null);

        }catch (Exception e){
            estado=0;
        }
        return estado;
    }
    public ArrayList<Curso> ListadoGeneral(){
        Cursor c;
        ArrayList<Curso> listado=new ArrayList<Curso>();
        c=database.rawQuery("select * from curso", null);
        while (c.moveToNext()){
            Curso objCurso=new Curso();
            objCurso.setCodigo(c.getInt(0));
            objCurso.setNombrecurso(c.getString(1));
            objCurso.setNota(c.getString(2));

            listado.add(objCurso);
        }
        c.close();
        return listado;
    }

    public ArrayList ListarNombreCurso(){
        Cursor c;
        ArrayList<String> listado=new ArrayList<>();
        c=database.rawQuery("select * from curso", null);
        if (c.moveToFirst()){
            do {
                listado.add(c.getString(1));
            }while(c.moveToNext());

        }
        return listado;
    }
}

