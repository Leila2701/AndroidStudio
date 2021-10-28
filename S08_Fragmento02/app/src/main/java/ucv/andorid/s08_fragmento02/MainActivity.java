package ucv.andorid.s08_fragmento02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager miFragment=getSupportFragmentManager();
        FragmentTransaction myFragmentTransaccion= miFragment.beginTransaction();//se define otra variable,

        //obtener el atributo display, es decir la pantalla del dispositivo
        WindowManager wm=getWindowManager();
        Display d=wm.getDefaultDisplay();


        Toast.makeText(getApplicationContext(),""+d.getRotation(),Toast.LENGTH_LONG).show();
        if(d.getRotation()== Surface.ROTATION_90){
            Fragmento1 fr1=new Fragmento1();
            myFragmentTransaccion.replace(android.R.id.content,fr1).commit();
        }else{
            Fragmento2 fr2=new Fragmento2();
            myFragmentTransaccion.replace(android.R.id.content,fr2).commit();
        }
    }
}