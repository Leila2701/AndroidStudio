package ucv.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import ucv.android.myapplication.Model.Nombres;
import ucv.android.myapplication.adapter.AdaptadorNombre;

public class Spinner extends AppCompatActivity {
    private android.widget.Spinner sp_nombres;
    private Nombres objNombres;
    private AdaptadorNombre adapterNombres;
    private ArrayList<Nombres> listaNombres;
    private Button buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        getSupportActionBar().setTitle("Seleccionar ");

        sp_nombres= (android.widget.Spinner) findViewById(R.id.sp_item);

        cargarSpinnerNombres();
        adapterNombres= new AdaptadorNombre(this, listaNombres);
        sp_nombres.setAdapter(adapterNombres);
        buscar=findViewById(R.id.bt_ingresar);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sp_nombres.getSelectedItemPosition()==0){
                    Intent ingresar=new Intent(Spinner.this, ListView.class);
                    startActivity(ingresar);
                }else if(sp_nombres.getSelectedItemPosition()==1){
                    Intent ingresar=new Intent(Spinner.this, Fragment.class);
                    startActivity(ingresar);
                }
            }
        });

    }

   public void cargarSpinnerNombres(){
        listaNombres = new ArrayList<>();
        listaNombres.add(new Nombres("ListView",R.drawable.listview));
        listaNombres.add(new Nombres("Fragments",R.drawable.fragment));
        listaNombres.add(new Nombres("SQLite",R.drawable.bd));

    }

}