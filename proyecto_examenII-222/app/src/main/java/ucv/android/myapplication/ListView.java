package ucv.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import static ucv.android.myapplication.R.id.LV_lista;

public class ListView extends AppCompatActivity {

    ArrayList<String> lista ;
    //Usuario objUsuario;
    //UsuarioDAO objUsuarioDAO;
    Curso objCurso;
    CursoDao objCursoDAO;
    ArrayAdapter adaptador2;
    private android.widget.ListView lv;
    private Adapter adaptador;
    private Entidad itemdata;
    private ArrayList<Entidad> arrayentidad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lv=(android.widget.ListView) findViewById(LV_lista);
       // adaptador=new Adapter(this,GetArrayItems());

        objCursoDAO=new CursoDao(this);
        objCursoDAO.open();
        lista=objCursoDAO.ListarNombreCurso();
        adaptador2= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lista);
        lv.setAdapter(adaptador2);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String p=lista.get(position);
                Toast.makeText(getApplicationContext(),"seleccinaste el elemnto"+p,Toast.LENGTH_LONG).show();
                Intent intent=new Intent(ListView.this, DetalleItem.class);
                intent.putExtra("objetoData",p);
                startActivity(intent);
            }
        });

    }

   /* private ArrayList<Entidad> GetArrayItems() {
        ArrayList<Entidad> lisItems=new ArrayList<>();
        lisItems.add(new Entidad(R.drawable.redes,"Redes y Comunicaciones II"));
        lisItems.add(new Entidad(R.drawable.aplicaciones,"Aplicaciones Moviles"));
        lisItems.add(new Entidad(R.drawable.sistemas,"Sistemas Inteligentes"));
        lisItems.add(new Entidad(R.drawable.gsti,"Gestión de Tecnología de Información"));
        lisItems.add(new Entidad(R.drawable.gti,"Gobierno de Tecnología de Información"));

        return lisItems;
    }
*/

}