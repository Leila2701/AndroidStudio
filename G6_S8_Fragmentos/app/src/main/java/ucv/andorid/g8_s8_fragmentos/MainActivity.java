package ucv.andorid.g8_s8_fragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction transaction;
    Fragment fragmentHome,fragmentHome2,fragmentCalculadora,fragmentCovid, fragmentItent, fragmentPromedio;
    TextView nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentHome= new HomeFragment();
        fragmentHome2= new HomeFragment_2();
        fragmentCalculadora= new CalculadoraFragment();
        fragmentCovid=new CovidFragment();
        fragmentItent= new ItentFragment();
        fragmentPromedio= new PromedioFragment();
        nombre=findViewById(R.id.txtTexto);

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragment, fragmentHome2).commit();
    }
    public void CambiarFondp(View v){
        transaction=getSupportFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.btnCalculadora:
                transaction.replace(R.id.contenedorFragment,fragmentCalculadora).commit();
                break;
            case R.id.btnCovid:
                transaction.replace(R.id.contenedorFragment,fragmentCovid).commit();
                break;
            case R.id.btnIntent:
                transaction.replace(R.id.contenedorFragment,fragmentItent).commit();
                break;
            case R.id.btnPromedio:
                transaction.replace(R.id.contenedorFragment,fragmentPromedio).commit();
                break;

        }
    }
    public void Inicio (View v){
        transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contenedorFragment,fragmentHome2).commit();
    }
}