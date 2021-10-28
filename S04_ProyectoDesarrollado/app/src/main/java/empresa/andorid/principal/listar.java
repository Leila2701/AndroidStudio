package empresa.andorid.principal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class listar extends AppCompatActivity implements View.OnClickListener {
    Button btn_regresar;
    //EditText txtarea;
    ArrayList<Persona> lista=null;
    ListView lstlistado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        btn_regresar=(Button)findViewById(R.id.btn_regresar);
        btn_regresar.setOnClickListener(this);
        //txtarea=(EditText)findViewById(R.id.txtarea);
        lstlistado=(ListView)findViewById(R.id.lstlistado);

        Intent objIntent=getIntent();
        Bundle objBundle= objIntent.getExtras();
        lista=(ArrayList<Persona>) objBundle.getSerializable("datos");

        lstlistado.setAdapter(new perzonalizacion(this,lista));

        /*String acum="";
        for(Persona obj:lista){
            acum+=obj.getNombre()+" "+obj.getApellido()+"\n";
        }
        txtarea.setText(acum);*/
    }

    public void regresar(){
        Intent objIntent= new Intent(listar.this, MainActivity.class);
        startActivity(objIntent);
        finish();
    }

    public void onClick (View v){
        if(v==btn_regresar){
            regresar();
        }
    }

}