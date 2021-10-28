package ucv.andorid.s08_fragmento01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Fragment IniFragment,FragmentoRojo,FragmentoAzul;
    FragmentTransaction myTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //IniFragment=new InicioFragment();
        FragmentoRojo=new FragmentRojo();
        FragmentoAzul=new FragmentAzul();
        IniFragment= InicioFragment.newInstance("dato1","dato2");
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragment,IniFragment).commit();

    }
    public void cambiarToRojo(View v){
        myTransaction=getSupportFragmentManager().beginTransaction();
        myTransaction.replace(R.id.contenedorFragment,FragmentoRojo).commit();
    }
    public void cambiarToAzul(View v){
        myTransaction=getSupportFragmentManager().beginTransaction();
        myTransaction.replace(R.id.contenedorFragment,FragmentoAzul).commit();
    }
    public void cambiarFondo(View v){
        myTransaction=getSupportFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.btnAzul:
                myTransaction.replace(R.id.contenedorFragment,FragmentoAzul).commit();
                break;
            case R.id.btnRojo:
                myTransaction.replace(R.id.contenedorFragment,FragmentoRojo).commit();
                break;
        }
    }
}