package empre.practice.pruebaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;


public class Spin extends AppCompatActivity {

    private Spinner opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        opciones=(Spinner)findViewById(R.id.spin_opc);
    }

    public void mostrarView (View v) {
        int posicion=opciones.getSelectedItemPosition();
        String pos=opciones.getSelectedItem().toString();

        if (pos.equals("ListView")){
            Intent int1=new Intent(this, ListViews.class);
            startActivity(int1);
        }
        else if (pos.equals("Fragments")){
            Intent int2=new Intent(this,Fragments.class);
            startActivity(int2);
        }
        else if (pos.equals("SQLLite")){
            Intent int3=new Intent(this,SQLLite.class);
            startActivity(int3);
        }
    }

}