package ucv.android.myapplication.Fragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ucv.android.myapplication.R;

public class MA_FragmentContenedor extends AppCompatActivity implements FragmentEstatico1.Comunicador{
    private Button btn1,btn2;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_fragment_contenedor);
        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);

        //Fragmento que aparece cuando inicia(android)
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new FragmentEstatico3()).commit();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"clic",Toast.LENGTH_LONG).show();
                Fragment fragmentoA=new FragmentEstatico1();
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragmentoA).commit();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"clic",Toast.LENGTH_LONG).show();
                Fragment fragmentoB=new FragmentEstatico2();
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragmentoB).commit();
            }
        });


    }
    @Override
    public void enviar(String mensaje) {
        RecibirFragment recibirFragmento = (RecibirFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        recibirFragmento.recibir(mensaje);
    }

    public void Inicio (View v){
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new FragmentEstatico3()).commit();

    }
}