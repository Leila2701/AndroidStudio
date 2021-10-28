package com.udemyandroid.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    List<String> androidVersionList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle extras = getIntent().getExtras();
        String emailUsuario = extras.getString("valorEmail");
        setTitle(emailUsuario);

        //1. Conectar nuestro listView (lista) al componente visual
        // a travez del id.

        lista = findViewById(R.id.ListView);

        //2. cargar a lista de elementos
        androidVersionList = new ArrayList<>();
        androidVersionList.add("Alerta");
        androidVersionList.add("Llamada");
        androidVersionList.add("Contactos");
        androidVersionList.add("Guardar Contactos");
        androidVersionList.add("Correo");
        androidVersionList.add("Camara");
        androidVersionList.add("Wifi");

        //3. Adaptor
        ArrayAdapter adaptadorVersionesAndroid = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                androidVersionList
        );

        //4. Vinculacion Listview - Adapter
        lista.setAdapter(adaptadorVersionesAndroid);

        //5. gestion de evento click en la lista
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        String androidVersion = androidVersionList.get(position);
      // Log.i("APP","Version click: "+androidVersion);

      switch(androidVersion){
          case "Alerta": Toast.makeText(getApplicationContext(), "Hola Pie", Toast.LENGTH_SHORT).show();
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
          case "Camara": Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,0);
                break;
          case "Wifi": Intent in = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivityForResult(in,0);
                break;



      }

    }


}