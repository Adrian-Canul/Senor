package com.example.adrian.sensorplus;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Adrian on 29/07/2017.
 */

public class Menu extends AppCompatActivity {
    //Button a,b,c;
    ImageView x,y,z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        //c=(Button)findViewById(R.id.button);
        //a=(Button)findViewById(R.id.button2);
        //b=(Button)findViewById(R.id.button3);
        x=(ImageView)findViewById(R.id.imageView);
        y=(ImageView)findViewById(R.id.imageView2);
        z=(ImageView)findViewById(R.id.imageView3);

        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pri = new Intent(Menu.this,MainActivity.class);
                startActivity(pri);
                //finish();

            }
        });
        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seg = new Intent(Menu.this,Acelerometro.class);
                startActivity(seg);
                //finish();
            }
        });
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ter = new Intent(Menu.this,Luz.class);
                startActivity(ter);
                //finish();
            }
        });

    }
}

