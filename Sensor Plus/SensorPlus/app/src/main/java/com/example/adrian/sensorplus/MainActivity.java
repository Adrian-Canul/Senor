package com.example.adrian.sensorplus;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private MediaPlayer mp;
    RelativeLayout In;
    SensorManager sm;
    Sensor sensor;
    TextView tv;
    //Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mp = MediaPlayer.create(MainActivity.this,R.raw.sandstorm);
        In =(RelativeLayout) findViewById(R.id.activyti_main);
        tv =(TextView) findViewById(R.id.text);
        sm =(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        //sm.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        //reg=(Button)findViewById(R.id.back1);


        //reg.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  finish();


            //}
       // });
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        sm.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        super.onResume();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        String text = String.valueOf(event.values[0]);
        tv.setText(text);
        float valor = Float.parseFloat(text);
        if(valor == 0){
            mp = MediaPlayer.create(MainActivity.this,R.raw.sandstorm);
            mp.start();
            //In.setBackground();
            In.setBackgroundColor(Color.RED);
        }else{
            if(mp != null){
                mp.release();
            }
            In.setBackgroundColor(Color.BLUE);
            //In.setBackground();
            //mp = MediaPlayer.create(MainActivity.this,R.raw.sandstorm);


        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
