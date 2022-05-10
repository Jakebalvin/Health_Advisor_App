package com.example.healthadvisorpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Calendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

    }

    public void calc(View v) {

        Intent intent = getIntent();
        double BMR = intent.getDoubleExtra("BMR", 0);
        EditText mon, tues, wed, thur, fri, sat, sun;

        double calories = 0;

        mon = findViewById(R.id.monc);
        double monc = Double.parseDouble((mon.getText().toString()));
        tues = findViewById(R.id.Tuesc);
        double tuesc = Double.parseDouble((tues.getText().toString()));
        wed = findViewById(R.id.wedc);
        double wedc = Double.parseDouble((wed.getText().toString()));
        thur = findViewById(R.id.thurc);
        double thurc = Double.parseDouble((thur.getText().toString()));
        fri = findViewById(R.id.fric);
        double fric = Double.parseDouble((fri.getText().toString()));
        sat = findViewById(R.id.satc);
        double satc = Double.parseDouble((sat.getText().toString()));
        sun = findViewById(R.id.sunc);
        double sunc = Double.parseDouble((sun.getText().toString()));

        double[] weekdays = {monc, tuesc, wedc, thurc, fric, satc, sunc};

        TextView gainedorlost = findViewById(R.id.gainedorlost);

        for (double day : weekdays) {
            calories += BMR - day;
            if (calories > 0)
                gainedorlost.setText(String.format("You will loose %.0f calories / %.0f pounds this week", calories, calories / 3500));
            else
                gainedorlost.setText(String.format("You will gain %.0f calories / %.0f pounds this week", Math.abs(calories), Math.abs(calories) / 3500));
        }
    }
}