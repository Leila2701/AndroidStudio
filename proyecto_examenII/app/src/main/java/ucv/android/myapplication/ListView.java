package ucv.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

import ucv.android.myapplication.Model.Entidad;
import ucv.android.myapplication.adapter.Adapter;

public class ListView extends AppCompatActivity {
    private android.widget.ListView lvItems;
    private Adapter adaptador;
    private Entidad itemdata;
    private ArrayList<Entidad> arrayentidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lvItems=(android.widget.ListView) findViewById(R.id.lvItems);
        adaptador=new Adapter(this,GetArrayItems());
        lvItems.setAdapter(adaptador);

        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(ListView.this, DetalleItem.class);
                //intent.putExtra("objetoData",arrayentidad.get(position));
                startActivity(intent);
            }
        });

    }

    private ArrayList<Entidad> GetArrayItems() {
        ArrayList<Entidad> lisItems=new ArrayList<>();
        lisItems.add(new Entidad(R.drawable.redes,"Redes y Comunicaciones II"));
        lisItems.add(new Entidad(R.drawable.aplicaciones,"Aplicaciones Moviles"));
        lisItems.add(new Entidad(R.drawable.sistemas,"Sistemas Inteligentes"));
        lisItems.add(new Entidad(R.drawable.gsti,"Gestión de Tecnología de Información"));
        lisItems.add(new Entidad(R.drawable.gti,"Gobierno de Tecnología de Información"));

        return lisItems;
    }


}