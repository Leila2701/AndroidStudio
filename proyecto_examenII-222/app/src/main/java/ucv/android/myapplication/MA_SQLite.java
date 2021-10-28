package ucv.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MA_SQLite extends AppCompatActivity {
    ArrayList<Curso> lista=null;
    Curso objCurso;
    CursoDao objCursoDAO;
    TextView txtresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_sqlite);
        txtresultado=findViewById(R.id.MA_SQLite_txtResultado);
        objCursoDAO=new CursoDao(this);
        objCursoDAO.open();
        ListarCursos();

    }
    public void ListarCursos(){
        String acum="";
        lista=objCursoDAO.ListadoGeneral();
        for(Curso obj:lista){
            acum=acum+"        "+obj.getNombrecurso()+"        "+obj.getNota()+" \n";
        }
        txtresultado.setText(acum);
    }
}