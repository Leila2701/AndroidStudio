package ucv.andorid.s09_fragmentocomunicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements EnviarFragmento.Comunicador{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void enviar(String mensaje) {
        RecibirFragmento recibirFragmento = (RecibirFragmento) getSupportFragmentManager().findFragmentById(R.id.fragmento_recibe);
        recibirFragmento.recibir(mensaje);
    }
}