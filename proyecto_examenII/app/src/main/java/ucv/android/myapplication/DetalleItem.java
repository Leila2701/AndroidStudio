
package ucv.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import ucv.android.myapplication.Model.Entidad;

public class DetalleItem extends AppCompatActivity {
    Entidad Item;
    TextView txtCurso;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_item);

        Item=(Entidad)getIntent().getSerializableExtra("objetoData");

        txtCurso=(TextView) findViewById(R.id.txtCurso);


        //txtCurso.setText(Item.getTitulo());


    }
}