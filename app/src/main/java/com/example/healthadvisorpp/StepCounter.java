package com.example.healthadvisorpp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.os.Bundle;

public class StepCounter extends AppCompatActivity implements SensorEventListener {

    TextView displaysteps;
    private SensorManager sensorManager;
    Sensor stepcountersensor;
    boolean isSensorPresent;
    int stepcount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_counter);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        displaysteps = findViewById(R.id.stepstaken);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null){
            stepcountersensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            isSensorPresent = true;
        }
        else
        {
            displaysteps.setText("Counter Sensor is not Present");
            isSensorPresent = false;
        }

    }

    public void ReturnHome(View v) {
        Intent returnhome = new Intent(this, MainActivity.class);
        startActivity(returnhome);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor == stepcountersensor)
        {
            stepcount = (int) sensorEvent.values[0];
            displaysteps.setText(String.valueOf(stepcount));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null)
            sensorManager.registerListener(this, stepcountersensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null)
            sensorManager.unregisterListener(this, stepcountersensor);
    }
}