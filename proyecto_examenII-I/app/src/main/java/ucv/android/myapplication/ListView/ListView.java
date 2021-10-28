package ucv.android.myapplication.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ucv.android.myapplication.BD.Modelo.Curso;
import ucv.android.myapplication.BD.Controlador.CursoDao;
import ucv.android.myapplication.R;

import static ucv.android.myapplication.R.id.LV_lista;

public class ListView extends AppCompatActivity {

    ArrayList<String> lista ;
    //Usuario objUsuario;
    //UsuarioDAO objUsuarioDAO;
    Curso objCurso;
    CursoDao objCursoDAO;
    ArrayAdapter adaptador2;
    private android.widget.ListView lv;
    //private Adapter adaptador;
    TextView txtnombre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lv=(android.widget.ListView) findViewById(LV_lista);
       // adaptador=new Adapter(this,GetArrayItems());

        Bundle extras =getIntent().getExtras();
        String nombre=extras.getString("objetoDataSpinner");
        txtnombre=findViewById(R.id.txt_list_nombre);

        txtnombre.setText(nombre);

        objCursoDAO=new CursoDao(this);
        objCursoDAO.open();
        lista=objCursoDAO.ListarNombreCurso();
        adaptador2= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lista);
        lv.setAdapter(adaptador2);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String p=lista.get(position);
                String nombre_u= txtnombre.getText().toString();
                Intent intent=new Intent(ListView.this, DetalleItem.class);
                intent.putExtra("objetoData",p);
                intent.putExtra("objetoDatausu",nombre_u);
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