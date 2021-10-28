package com.ucv.fragmento03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button) findViewById(R.id.buttonA);
        btn2=(Button) findViewById(R.id.buttonB);
        btn3=(Button) findViewById(R.id.buttonC);

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new Fragmento1()).commit();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"clic",Toast.LENGTH_LONG).show();
                Fragment fragmentoA=new Fragmento1();
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragmentoA).commit();
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"clic",Toast.LENGTH_LONG).show();
                Fragment fragmentoB=new Fragmento2();
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragmentoB).commit();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"clic",Toast.LENGTH_LONG).show();
                Fragment fragmentoC=new Fragmento3();
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragmentoC).commit();
            }
        });

    }
}