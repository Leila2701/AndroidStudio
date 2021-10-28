package empresa.andorid.principal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class registrar extends AppCompatActivity implements View.OnClickListener {
    Button btnregresar,btnregistrar;

    ArrayList<Persona>lista=null;

    EditText txtnombre, txtapellido;
    //Referenciamos a la clase Persona.
    Persona objPersona= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        btnregresar=(Button)findViewById(R.id.btnregresar);
        btnregresar.setOnClickListener(this);
        //mapeamos el botón de la siguiente forma:
        btnregistrar=(Button)findViewById(R.id.btnregistrar);
        btnregistrar.setOnClickListener(this);

        txtnombre=(EditText)findViewById(R.id.txtnombre);
        txtapellido=(EditText)findViewById(R.id.txtapellido);

        Intent objIntent= getIntent();
        Bundle objbundle= objIntent.getExtras();
        ArrayList<Persona> lista=(ArrayList<Persona>) objbundle.getSerializable("datos");
        this.lista=lista;

    }

    public void regresar(){
        Intent objIntent= new Intent(registrar.this, MainActivity.class);

        Bundle objbundle= new Bundle();
        objbundle.putSerializable("datos",lista);
        objIntent.putExtras(objbundle);

        startActivity(objIntent);
        finish();
    }
    @Override
    public void onClick(View v){
        if(v==btnregresar){
            regresar();
        }
        if(v==btnregistrar){
            registrar();
        }
    }
    public void registrar(){
        String nombre1,apellido1;
        nombre1=txtnombre.getText().toString();
        apellido1=txtapellido.getText().toString();
        //Seteamos los métodos
        objPersona=new Persona();
        objPersona.setNombre(nombre1);
        objPersona.setApellido(apellido1);
        //Añadimos los datos al arrayList
        lista.add(objPersona);
        //Limpiamos datos
        txtnombre.setText("");
        txtapellido.setText("");
        txtnombre.requestFocus();
    }
}