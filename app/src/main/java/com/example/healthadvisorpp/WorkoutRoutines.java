package com.example.healthadvisorpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WorkoutRoutines extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_routines);

        //routine spinnner
        Spinner rspinner = findViewById(R.id.spinner);
        List<String> routines = new ArrayList<>();
        routines.add(0, "Please select an exercise");
        routines.add("Burpees");
        routines.add("Dumbell rows");
        routines.add("Overhead dumbell presses");
        routines.add("Lunges");
        routines.add("Pushups");
        routines.add("Planks");
        routines.add("Side planks");
        routines.add("Single-leg deadlifts");
        ArrayAdapter<String> routinespinner = new ArrayAdapter(this, android.R.layout.simple_spinner_item, routines);
        routinespinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rspinner.setAdapter(routinespinner);
        rspinner.setOnItemSelectedListener(this);
    }

    public void ReturnHome(View v) {
        Intent returnhome = new Intent(this, MainActivity.class);
        startActivity(returnhome);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        TextView routinedescription = findViewById(R.id.routinedescription);
        if(position != 0)
            routinedescription.setVisibility(View.VISIBLE);
        switch (position) {
            case 0:
                routinedescription.setVisibility(View.GONE);
                break;
            case 8:
                routinedescription.setText("" +
                        "1. Begin standing with a dumbbell in your right hand with your knees slightly bent\n" +
                        "2. Hinging at the hips, begin to kick your left leg straight back behind you," +
                            "lowering the dumbbell down towards the ground\n" +
                        "3. When you reach a comfortable height with your left leg, slowly return to the starting" +
                            "position in a controlled motion, squeezing your right glute. Ensure that your pelvis stays" +
                            "square to the ground during the movement\n" +
                        "4. Repeat 10 to 12 reps before moving the weight to your left hand and repeating the same" +
                            "steps on the left leg");
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}