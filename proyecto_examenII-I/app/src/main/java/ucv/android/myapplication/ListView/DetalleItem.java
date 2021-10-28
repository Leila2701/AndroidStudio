package ucv.android.myapplication.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ucv.android.myapplication.BD.Modelo.Curso;
import ucv.android.myapplication.BD.Controlador.CursoDao;
import ucv.android.myapplication.R;

public class DetalleItem extends AppCompatActivity {
    ArrayList<Curso> lista=null;
    Curso objCurso;
    CursoDao objCursoDAO;

    //Entidad Item;
    TextView txtCurso,txtnota,txtnombre;
  //  EditText txtnota;
    ImageView imgFoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_item);

        txtnota=(TextView) findViewById(R.id.DetalleItem_editNota);





        Bundle extras =getIntent().getExtras();
        //Item=(Entidad)getIntent().getSerializableExtra("objetoData");
        String nombre=extras.getString("objetoData");
        String usuario= extras.getString("objetoDatausu");
        txtnombre=(TextView)findViewById(R.id.txt_det_nombre);
        txtCurso=(TextView) findViewById(R.id.txtCurso);
        //imgFoto=(ImageView) findViewById(R.id.Imagen);
        txtnombre.setText(usuario);
        txtCurso.setText(nombre);
        //imgFoto.setImageResource(Item.getImgFoto());
        objCursoDAO=new CursoDao(this);
        objCursoDAO.open();

    }

    public void ModificarNota(View v){

        String nombrecurso=txtCurso.getText().toString();
        String nota=txtnota.getText().toString();
        long estado=objCursoDAO.modificarRegistro(nombrecurso,nota);
        if(estado==0){
            Toast.makeText(getApplicationContext(), "No se Registro correctamente",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "Se Modifico correctamente",Toast.LENGTH_LONG).show();
        }


    }
}