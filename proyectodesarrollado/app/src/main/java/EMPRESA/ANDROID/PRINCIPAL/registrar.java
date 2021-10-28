package EMPRESA.ANDROID.PRINCIPAL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class registrar extends AppCompatActivity implements View.OnClickListener {

    Button btnregresar, btnregistrar;
    ArrayList<Persona> lista=null;
    EditText txtnombre, txtapellido;
    Persona objPersona= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        btnregresar=(Button)findViewById(R.id.btnregresar);
        btnregresar.setOnClickListener(this);
        btnregistrar=(Button)findViewById(R.id.btnregistrar);
        btnregistrar.setOnClickListener(this);

        txtnombre=(EditText) findViewById(R.id.txtnombre);
        txtapellido=(EditText) findViewById(R.id.txtapellido);

        Intent objIntent= getIntent();
        Bundle objBundle= objIntent.getExtras();
        ArrayList<Persona> lista =(ArrayList<Persona>) objBundle.getSerializable("datos");
        this.lista= lista;
    }

    public void regresar () {
        Intent objIntent=new Intent(registrar.this, MainActivity.class);

        Bundle objbundle= new Bundle();
        objbundle.putSerializable("datos",lista);
        objIntent.putExtras(objbundle);

        startActivity(objIntent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v==btnregresar){
            regresar();
        }
        if (v==btnregistrar){
            registrar();
        }
    }

    public void registrar(){
        String nombre1, apellido1;
        nombre1= txtnombre.getText().toString();
        apellido1= txtapellido.getText().toString();

        objPersona= new Persona();
        objPersona.setNombre(nombre1);
        objPersona.setApellido(apellido1);

        lista.add(objPersona);

        txtnombre.setText("");
        txtapellido.setText("");
        txtnombre.requestFocus();

    }
}




