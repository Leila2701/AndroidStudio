package ucv.andorid.spinner_personalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import ucv.andorid.spinner_personalizado.adapter.Adaptador;
import ucv.andorid.spinner_personalizado.model.Entidad;

public class ListView_Personalizado extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lvItems;
    private Adaptador adaptador;
    private Entidad itemdata;
    private ArrayList<Entidad> arrayentidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view__personalizado);

        lvItems=(ListView) findViewById(R.id.lvItems);
        adaptador=new Adaptador(this,GetArrayItems());
        lvItems.setAdapter(adaptador);

        lvItems.setOnItemClickListener(this);
    }
    private ArrayList<Entidad> GetArrayItems() {
        ArrayList<Entidad> lisItems=new ArrayList<>();
        lisItems.add(new Entidad(R.drawable.alarma,"Alerta"));
        lisItems.add(new Entidad(R.drawable.llamada,"Llamada"));
        lisItems.add(new Entidad(R.drawable.contacto,"Contactos"));
        lisItems.add(new Entidad(R.drawable.guardarcontacto,"Guardar Contactos"));
        lisItems.add(new Entidad(R.drawable.correo,"Correo"));
        lisItems.add(new Entidad(R.drawable.camara,"Camara"));
        lisItems.add(new Entidad(R.drawable.wifi,"Wifi"));


        return lisItems;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}