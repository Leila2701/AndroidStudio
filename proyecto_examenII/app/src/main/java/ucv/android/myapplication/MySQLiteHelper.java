package ucv.android.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String NOMBRETABLA="usuario";
    private static final String NOMBREBD="mibase";
    private static final int VERSION=1;
    private static final String SQLBD=" create table "+ NOMBRETABLA +" (codigo integer primary key autoincrement,nombre text not null, clave text not null)" ;


    public MySQLiteHelper(Context context) {
        super(context, NOMBREBD, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { db.execSQL(SQLBD); }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(), "Actualizando la version de la base de datos numero " + oldVersion + " a" +newVersion);
        db.execSQL("DROP TABLE IF EXISTS " + NOMBRETABLA);
        onCreate(db);
    }


}
