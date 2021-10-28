package ucv.android.myapplication.BD.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import ucv.android.myapplication.BD.Controlador.CursoDao;
import ucv.android.myapplication.BD.Modelo.Curso;
import ucv.android.myapplication.R;

public class MA_SQLite extends AppCompatActivity {
    ArrayList<Curso> lista=null;
    Curso objCurso;
    CursoDao objCursoDAO;
    TextView txtresultado,txtnota,txtnombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_sqlite);
        txtresultado=findViewById(R.id.MA_SQLite_txtResultadoCurso);
        txtnota=findViewById(R.id.MA_SQLite_txtResultadoNota);
        objCursoDAO=new CursoDao(this);
        objCursoDAO.open();
        ListarCursos();

        Bundle extras =getIntent().getExtras();
        String nombre=extras.getString("objetoDataSpinner");
        txtnombre=findViewById(R.id.txt_sql_nombre);

        txtnombre.setText(nombre);

    }
    public void ListarCursos(){
        String acum="";
        String acumnota="";
        lista=objCursoDAO.ListadoGeneral();
        for(Curso obj:lista){
            acum=acum+obj.getNombrecurso()+" \n";
            acumnota=acumnota+obj.getNota()+" \n";
        }
        txtresultado.setText(acum);
        txtnota.setText(acumnota);
    }
}