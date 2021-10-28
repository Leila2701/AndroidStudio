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

public class MainActivity extends AppCompatActivity {
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


        //evento click

      /*  AdapterView.OnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String androidVersion = (String)lvItems.getItemAtPosition(i).toString();
                Log.i("APP","Version click: "+androidVersion);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                String androidVersion = (String)lvItems.getItemAtPosition(i).toString();
                Log.i("APP","Version click: "+androidVersion);
                switch(androidVersion){
                    case "Alerta":
                        Toast.makeText(getApplicationContext(), "Hola Pie", Toast.LENGTH_SHORT).show();
                        break;
                    case "Llamada": Snackbar.make(view,"Quiero Oreo",Snackbar.LENGTH_LONG).show();
                        break;
                    case "Contactos":String texto="miguel";
                        Intent intentWeb =new Intent(Intent.ACTION_WEB_SEARCH);
                        intentWeb.putExtra(SearchManager.QUERY,texto);
                        startActivity(intentWeb);
                        break;
                    case "Guardar Contactos":Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                        intent.putExtra(ContactsContract.Intents.Insert.PHONE,"94038852").putExtra(ContactsContract.Intents.Insert.NAME,"POLLITO CON PAPAS" );
                        startActivity(intent);
                        break;
                    case "Correo": String textO="Miguel";
                        Intent email = new Intent(Intent.ACTION_SEND);
                        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"roxylarosaspar@gmail.com"});
                        email.putExtra(Intent.EXTRA_SUBJECT, "Grupo 6");
                        email.putExtra(Intent.EXTRA_TEXT, ""+textO);
                        email.setType("message/rfc822");
                        startActivity(Intent.createChooser(email, "roxylarosaspar@gmail.comt :"));
                        break;
                    case "Camara": Intent ii = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(ii,0);
                        break;
                    case "Wifi": Intent in = new Intent(Settings.ACTION_WIFI_SETTINGS);
                        startActivityForResult(in,0);
                        break;



                }
            }
        });*/

    }

    private ArrayList<Entidad> GetArrayItems() {
        ArrayList<Entidad> lisItems=new ArrayList<>();
        lisItems.add(new Entidad(R.drawable.img1,"Alerta"));
        lisItems.add(new Entidad(R.drawable.img1,"Llammada"));
        lisItems.add(new Entidad(R.drawable.img1,"Contactos"));
        lisItems.add(new Entidad(R.drawable.img1,"Guardar Contactos"));
        lisItems.add(new Entidad(R.drawable.img1,"Correo"));
        lisItems.add(new Entidad(R.drawable.img1,"Camara"));
        lisItems.add(new Entidad(R.drawable.img1,"Wifi"));

        return lisItems;
    }



}