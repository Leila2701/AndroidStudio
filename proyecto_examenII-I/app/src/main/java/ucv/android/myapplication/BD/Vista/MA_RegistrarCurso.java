package ucv.android.myapplication.BD.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ucv.android.myapplication.BD.Controlador.CursoDao;
import ucv.android.myapplication.BD.Modelo.Curso;
import ucv.android.myapplication.R;

public class MA_RegistrarCurso extends AppCompatActivity {
    ArrayList<Curso> lista =null;
    Curso objCurso;
    CursoDao objCursoDAO;
    EditText txtnombrecurso;
    TextView txtlistar;
    Button btnregisrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_registrar_curso);

        txtnombrecurso=(EditText)findViewById(R.id.MA_RC_editCurso);
        btnregisrar=(Button)findViewById(R.id.MA_RC_btnRegistrar);
        txtlistar=(TextView)findViewById(R.id.MA_RC_txtListar);
        objCursoDAO=new CursoDao(this);
        objCursoDAO.open();

    }
    public void GrabarCurso(View v){
        String nombrecurso=txtnombrecurso.getText().toString();
        String nota="0";
        long estado=objCursoDAO.insertar(nombrecurso,nota);
        if(estado==0){
            Toast.makeText(getApplicationContext(), "no se inserto",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "se inserto",Toast.LENGTH_LONG).show();
        }
        LimpiarCampos();

    }
    public void LimpiarCampos(){
        txtnombrecurso.setText("");

        txtnombrecurso.requestFocus();
    }

    public void ListarCursos(View v){
        String acum="";
        lista=objCursoDAO.ListadoGeneral();
        for(Curso obj:lista){
            acum=acum+""+obj.getCodigo()+"  "+obj.getNombrecurso()+"  "+obj.getNota()+" \n";
        }
        txtlistar.setText(acum);
    }
}