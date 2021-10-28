package ucv.andorid.lab06_fragmento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String nombre;
    int num1,num2,num3;

    FragmentTransaction transaction; //definir una variable transaction de tipo FragmentTransaction(como la linea 10), permite establece el dinamismo
    Fragment fragmentHome,fragmentVerde,fragmentRojo; //como la linea 11

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentHome=new HomeFragment();
        fragmentRojo=new RojoFragment();
        fragmentVerde= new VerdeFragment();
        //se indica que con el beginTransaction, se le asigna a un contenedor un fragmento
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragment,fragmentHome).commit();
    }

    public void CambiarFondo(View v){
        //descubrir a que boton le dio clic
        transaction= getSupportFragmentManager().beginTransaction() ;
/*
        if (v.getId()==R.id.btnRojo) {
            transaction.replace(R.id.contenedorFragment,fragmentRojo).commit();
        }else{
            transaction.replace(R.id.contenedorFragment,fragmentVerde).commit();
        }
        v.getId();*/
        switch (v.getId()){
            case R.id.btnRojo:
                transaction.replace(R.id.contenedorFragment,fragmentRojo).commit();
                break;
            case R.id.btnVerde:
                transaction.replace(R.id.contenedorFragment,fragmentVerde).commit();
                break;
        }
    }
}