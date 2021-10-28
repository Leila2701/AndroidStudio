package ucv.android.myapplication.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import ucv.android.myapplication.BD.Vista.MA_RegistrarCurso;
import ucv.android.myapplication.BD.Vista.MA_SQLite;
import ucv.android.myapplication.BD.Vista.MainActivity_Registrar;
import ucv.android.myapplication.Formulario_Covid;
import ucv.android.myapplication.Fragmentos.MA_FragmentContenedor;
import ucv.android.myapplication.ListView.ListView;
import ucv.android.myapplication.R;

public class Spinner extends AppCompatActivity {
    private android.widget.Spinner sp_nombres;
    private Nombres objNombres;
    private AdaptadorNombre adapterNombres;
    private ArrayList<Nombres> listaNombres;
    private Button buscar;
    TextView txtnombre;

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

        Bundle extras =getIntent().getExtras();
        String nombre=extras.getString("objetoDataLogin");
        txtnombre=findViewById(R.id.txtNombre);

        txtnombre.setText(nombre);


        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre_u= txtnombre.getText().toString();
                if(sp_nombres.getSelectedItemPosition()==0){
                    Intent ingresar=new Intent(Spinner.this,  MainActivity_Registrar.class);
                    ingresar.putExtra("objetoDataSpinner",nombre_u);
                    startActivity(ingresar);
                }else if(sp_nombres.getSelectedItemPosition()==1){
                    Intent ingresar=new Intent(Spinner.this, Formulario_Covid.class);
                    startActivity(ingresar);
                }else{
                    Intent ingresar=new Intent(Spinner.this, MA_SQLite.class);
                    ingresar.putExtra("objetoDataSpinner",nombre_u);
                    startActivity(ingresar);
                }

            }
        });

    }

   public void cargarSpinnerNombres(){
        listaNombres = new ArrayList<>();
        listaNombres.add(new Nombres("Registrar Usuario",R.drawable.listview));
        listaNombres.add(new Nombres("Verificar Sintomas Covid",R.drawable.fragment));
        listaNombres.add(new Nombres("Gestión de accesorios",R.drawable.bd));

    }

    public void LayoutCurso(View v){
        Intent ingresar=new Intent(Spinner.this, MA_RegistrarCurso.class);
        startActivity(ingresar);
    }



}