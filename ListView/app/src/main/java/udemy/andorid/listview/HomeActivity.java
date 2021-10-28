package udemy.andorid.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    List<String> andoridVersionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //1. Conectar nuestro listView(lista al componente visual a traves del id
        lista=findViewById(R.id.listView);

        //2. Cargar la lista de elementos
        andoridVersionList=new ArrayList<>();
        andoridVersionList.add("Pie");
        andoridVersionList.add("Oreo");
        andoridVersionList.add("Nougat");
        andoridVersionList.add("Mashmallow");
        andoridVersionList.add("Lollipoop");
        andoridVersionList.add("Kikat");
        andoridVersionList.add("etc");

        //3. Adaptador(transforma la lista de string a vista de la lista)
        ArrayAdapter adaptadorVersionAndroid=new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                andoridVersionList
        );

        //4. Vinculacion listView- adapter
        lista.setAdapter(adaptadorVersionAndroid);

        //5.Gestiòn de evento click en la lista
        lista.setOnItemClickListener(this);
    }
    //Accion que se realiza cuando el usuario hace clic en algun elemento de la lista
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String androidVersion = andoridVersionList.get(position);
        Log.i("APP","Version click: "+ androidVersion);
    }
}