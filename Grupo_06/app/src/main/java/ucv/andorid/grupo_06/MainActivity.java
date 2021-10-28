package ucv.andorid.grupo_06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import ucv.andorid.grupo_06.adapter.FrameworkAdapter;
import ucv.andorid.grupo_06.model.Framework;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private ImageView imgFramework;
    private TextView txtNomFramework, txtContenido;
    private LinearLayout contenidoLayout;

    private ArrayList<Framework> frameworks;
    private FrameworkAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=findViewById(R.id.spinner);
        imgFramework= findViewById(R.id.imgFramework);
        txtNomFramework= findViewById(R.id.txtNombreFramework);
        txtContenido= findViewById(R.id.txtContenido);
        contenidoLayout= findViewById(View.GONE);

        llenarLista();

        adapter = new FrameworkAdapter(this, frameworks);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Framework framework = frameworks.get(position);
                if (position == 0) {
                    contenidoLayout.setVisibility(View.GONE);
                }
                if (position != 0) {
                    contenidoLayout.setVisibility(View.VISIBLE);
                    imgFramework.setImageResource(framework.getImg());
                    txtNomFramework.setText(framework.getNombre());
                    txtContenido.setText(framework.getContenido());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }




        });



    }

    private void llenarLista(){
        frameworks = new ArrayList<>();
        frameworks.add(new Framework(0,"..Seleccionar un Framework",0));
        frameworks.add(new Framework(R.drawable.spring,"Spring",R.string.spring));
        frameworks.add(new Framework(R.drawable.angular,"Angular",R.string.angular));
        frameworks.add(new Framework(R.drawable.laravel,"Lavavel",R.string.laravel));
        frameworks.add(new Framework(R.drawable.vue,"Vue",R.string.vue));
        frameworks.add(new Framework(R.drawable.django,"Django",R.string.django));
        frameworks.add(new Framework(R.drawable.flutter,"Flutter",R.string.flutter));
    }
}