package ucv.andorid.spinner_personalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import ucv.andorid.spinner_personalizado.adapter.AdaptadorLenguajeProgramacion;
import ucv.andorid.spinner_personalizado.model.LenguajeProgramacion;

public class MainActivity extends AppCompatActivity {

    private Spinner sp_lenguaje;
    private LenguajeProgramacion objLenguaje;
    private AdaptadorLenguajeProgramacion adapterLenguaje;
    private ArrayList<LenguajeProgramacion> listaLenguaje;
    private Button buscar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Lenguaje de Programacion");

        sp_lenguaje= (Spinner) findViewById(R.id.sp_item);

        cargarSpinnerLenguaje();
        adapterLenguaje= new AdaptadorLenguajeProgramacion(this, listaLenguaje);
        sp_lenguaje.setAdapter(adapterLenguaje);
        buscar=findViewById(R.id.bt_ingresar);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp_lenguaje.getSelectedItemPosition()==0){
                    Intent intent =new Intent(v.getContext(),ListView_Formulario.class);
                    startActivityForResult(intent,0);
                }else if(sp_lenguaje.getSelectedItemPosition()==1){
                    Intent intent =new Intent(v.getContext(),ListView_Personalizado.class);
                    startActivityForResult(intent,0);
                }else if(sp_lenguaje.getSelectedItemPosition()==2){
                    Intent intent =new Intent(v.getContext(),ListView_Simple.class);
                    startActivityForResult(intent,0);
                }
            }
        });
    }

    public void cargarSpinnerLenguaje(){
        listaLenguaje = new ArrayList<>();
        listaLenguaje.add(new LenguajeProgramacion("ListView Completo",R.drawable.lista));
        listaLenguaje.add(new LenguajeProgramacion("ListView Personalizado",R.drawable.lista2));
        listaLenguaje.add(new LenguajeProgramacion("ListView",R.drawable.lista3));

    }

}