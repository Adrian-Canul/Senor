package com.example.adrian.sensorplus;

import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Adrian on 29/07/2017.
 */



public class Luz extends AppCompatActivity implements SensorEventListener {

    TextView z;
    TextView tex;
    SensorManager sensorManager;
    Sensor sensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.luz);
        tex = (TextView)findViewById(R.id.text);
        z =(TextView)findViewById(R.id.baj);

        sensorManager = (SensorManager)getSystemService(Service.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }


    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {

        super.onResume();
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_LIGHT){
            //int x;
           float x = event.values[0];
            tex.setText(""+event.values[0]);
            if (x>=5000){
                String y ="LUZ ALTA";
                z.setText(y);



                //xd.setText();
            }else
                {
                    String y ="LUZ BAJA";
                    z.setText(y);
                }
            //if(tex == "0")







        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
