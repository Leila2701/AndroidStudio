package empre.practice.pruebaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViews extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView myList;


    List<String> ListaNombres;
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView myList = (ListView) findViewById(R.id.List_view);

        ListaNombres = new ArrayList<>();
        ListaNombres.add("Redes y Comunicaciones II");
        ListaNombres.add("Aplicaciones Moviles");
        ListaNombres.add("Gobierno de Tecnologia de Informacion");
        ListaNombres.add("Gestión de Servicios de Tecnología de Información");
        ListaNombres.add("Sistemas Inteligentes");

        ArrayAdapter myAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,ListaNombres);
        myList.setAdapter(myAdapter);

        myList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        String Listas = ListaNombres.get(position);
        TextView resultado = (TextView) findViewById (R.id.contenedor);

        switch(Listas){
            case "Jose": resultado.setText("Nota: 14");
                //Toast.makeText(getApplicationContext(),"Entro al sistema",Toast.LENGTH_LONG).show();
                 break;
            case "Mariana": resultado.setText("Nota: 15");
                 break;
            case "Nicol": resultado.setText("Nota: 16");
                 break;
            case "Maria": resultado.setText("Nota: 17");
                 break;
            case "Raul": resultado.setText("Nota: 18");
                 break;
            case "Tito": resultado.setText("Nota: 19");
                 break;
        }

    }
}