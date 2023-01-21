package com.example.lampeauto;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.hardware.camera2.CameraManager;
import android.widget.Toast;


public class SensorActivity<textView> extends AppCompatActivity implements SensorEventListener {
    private  TextView luminosite;
    private SensorManager sensorManager;
    private Sensor lightSensor;
    private CameraManager cameraManager;
    private Switch onoff;
    private  TextView etat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        luminosite = findViewById(R.id.luminosite);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        cameraManager = (CameraManager) getSystemService (CAMERA_SERVICE);
        onoff = findViewById(R.id.switchFlashLight);
        etat = findViewById(R.id.etat);


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        luminosite.setText(String.valueOf((int) sensorEvent.values[0]));

        if (onoff.isChecked()){
            try {
                etat.setText("Allumer");
                cameraManager.setTorchMode("0",50 > sensorEvent.values[0]);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }

        }
        else{
            etat.setText("Eteint")
            ;
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public  void onResume() {

        super.onResume();
        sensorManager.registerListener(this,lightSensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }









}