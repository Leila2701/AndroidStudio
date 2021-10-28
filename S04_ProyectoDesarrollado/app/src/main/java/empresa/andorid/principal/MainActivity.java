package empresa.andorid.principal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayList<String> listaop;
    ArrayAdapter<String> adaptador;
    ListView lstopciones;

    ArrayList<Persona> listarregistrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstopciones=(ListView)findViewById(R.id.lstopciones);
        lstopciones.setOnItemClickListener(this);

        listaop=cargar();
        adaptador= new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,listaop);
        lstopciones.setAdapter(adaptador);

        Intent objIntent= getIntent();
        Bundle objbundle= objIntent.getExtras();
        if(objbundle!=null){
            ArrayList<Persona> listarecibida=(ArrayList<Persona>) objbundle.getSerializable("datos");
            listarregistrada=listarecibida;
        }else{
            listarregistrada= new ArrayList<Persona>();
        }

    }
    public ArrayList<String> cargar(){
        listaop=null;
        listaop= new ArrayList<String>();
        String obj1= new String("REGISTRAR");
        listaop.add(obj1);

        String obj2= new String("LISTA");
        listaop.add(obj2);

        return listaop;
    }


    @SuppressLint("WrongConstant")
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //String mensaje= lstopciones.getItemAtPosition(position).toString();
        //Toast.makeText(getApplicationContext(),mensaje,3000).show();
        switch (position){
            case 0:{
                Intent objintent= new Intent(MainActivity.this, registrar.class);

                Bundle objbundle= new Bundle();
                       objbundle.putSerializable("datos",listarregistrada);
                       objintent.putExtras(objbundle);
                startActivity(objintent);
                finish();
                break;
            }
            case 1:{
                Intent objintent= new Intent(MainActivity.this, listar.class);
                Bundle objbundle=new Bundle();
                objbundle.putSerializable("datos",listarregistrada);
                objintent.putExtras(objbundle);
                startActivity(objintent);
                finish();
                break;
            }
        }
    }
}