package com.udemyandroid.s6_grupo6_lisviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.net.CookieHandler;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lvItems;
    private Adaptador adaptador;
    private Entidad itemdata;
    private ArrayList<Entidad> arrayentidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            if(AdapterView<>)
    }
}