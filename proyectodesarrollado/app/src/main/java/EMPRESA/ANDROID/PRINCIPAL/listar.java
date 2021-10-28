package EMPRESA.ANDROID.PRINCIPAL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class listar extends AppCompatActivity implements View.OnClickListener{

    Button btnregresar2;
    ArrayList<Persona> lista=null;
    ListView lstlistado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        btnregresar2=(Button)findViewById(R.id.btnregresar2);
        btnregresar2.setOnClickListener(this);
        lstlistado=(ListView)findViewById(R.id.lstlistado);

        Intent objIntent= getIntent();
        Bundle objBundle= objIntent.getExtras();
        lista =(ArrayList<Persona>) objBundle.getSerializable("datos");

        lstlistado.setAdapter(new personalizacion(this,lista));

    }

    public void regresar () {
        Intent objIntent=new Intent(listar.this, MainActivity.class);
        startActivity(objIntent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v==btnregresar2){
            regresar();
        }
    }
}