package ucv.andorid.s09_adapter01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView myList;
    private ArrayList<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList=(ListView)findViewById(R.id.LisData);

        names= new ArrayList<String>();
        for(int i=1;i<10;i++){
            names.add("opcion"+i);
        }

        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
        myList.setAdapter(myAdapter);
    }
}