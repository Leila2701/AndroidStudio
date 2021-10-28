package ucv.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetalleItem extends AppCompatActivity {
    ArrayList<Curso> lista=null;
    Curso objCurso;
    CursoDao objCursoDAO;

    Entidad Item;
    TextView txtCurso,txtnota;
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
        txtCurso=(TextView) findViewById(R.id.txtCurso);
        //imgFoto=(ImageView) findViewById(R.id.Imagen);
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