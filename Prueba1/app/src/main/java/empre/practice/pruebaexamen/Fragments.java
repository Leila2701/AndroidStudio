package empre.practice.pruebaexamen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class Fragments extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragmentCalculadora,fragmentCovid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);
        fragmentCalculadora= new CalculadoraFragment();
        fragmentCovid=new CovidFragment();
    }

    public void CambiarFondo(View v){
        transaction=getSupportFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.btnCalculadora:
                transaction.replace(R.id.contenedorFragment,fragmentCalculadora).commit();
                break;
            case R.id.btnCovid:
                transaction.replace(R.id.contenedorFragment,fragmentCovid).commit();
                break;

        }
    }

}