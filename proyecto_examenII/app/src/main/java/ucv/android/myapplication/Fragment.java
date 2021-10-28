package ucv.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Fragment extends AppCompatActivity implements FragmentEstatico1.Comunicador{
    private Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);


    }

    @Override
    public void enviar(String mensaje) {
        RecibirFragment recibirFragmento = (RecibirFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        recibirFragmento.recibir(mensaje);
    }
}