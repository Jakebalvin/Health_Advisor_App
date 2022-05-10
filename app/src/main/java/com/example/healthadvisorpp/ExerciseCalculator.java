package com.example.healthadvisorpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ExerciseCalculator extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    int minutes, spinnerposition;
    double MET, MPH, caloriesburned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_calculator);

        //exercise choice spinnner
        Spinner espinner = findViewById(R.id.exercisespinner);
        List<String> routines = new ArrayList<>();
        routines.add(0, "Please select an exercise");
        routines.add("Burpees");                        // 1    8
        routines.add("Dumbell rows");                   // 2    6
        routines.add("Overhead dumbbell presses");      // 3    6
        routines.add("Lunges");                         // 4    3.8
        routines.add("Pushups");                        // 5    3.8
        routines.add("Planks");                         // 6    3.8
        routines.add("Side planks");                    // 7    3.8
        routines.add("Single-leg deadlifts");           // 8    6
        routines.add("Jumping Jacks");                  // 9    8
        routines.add("Squats");                         // 10   6
        routines.add("Mountain Climbers");              // 11   8
        routines.add("Crunches");                       // 12   3.8
        routines.add("Sit-ups");                        // 13   3.8
        routines.add("Glute Brigdes");                  // 14   3.8
        routines.add("Planks to Downward Dog");         // 15   3.8
        routines.add("Bicycles");                       // 16   6
        routines.add("Calf Raises");                    // 17   3.8
        routines.add("Skipping");                       // 18   8
        routines.add("Bench Dips");                     // 19   6
        routines.add("Thrusters");                      // 20   8
        routines.add("Dumbbell floor press");           // 21   6
        routines.add("Deadbug");                        // 22   3.8
        routines.add("Bicep curl");                     // 23   6
        routines.add("Jumping Lunges");                 // 24   8
        routines.add("Running on a Treadmill");
        ArrayAdapter<String> exercisespinner = new ArrayAdapter(this, android.R.layout.simple_spinner_item, routines);
        exercisespinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        espinner.setAdapter(exercisespinner);
        espinner.setOnItemSelectedListener(this);

    }

    public void calculate(View v) {
        EditText etminutes = findViewById(R.id.minutes);
        String sminutes = etminutes.getEditableText().toString();
        minutes = Integer.parseInt(sminutes);

        Intent intent = getIntent();
        double weightkg = intent.getDoubleExtra("weightkg", 100);

        if (spinnerposition != 25)
        {
            caloriesburned = (MET * 3.5 * weightkg / 200) * minutes;
        }
        else {
            if (MPH <= 3.7) {
                MPH *= 26.8;
                caloriesburned = (.1 * MPH) + (1.8 * MPH) + 3.5;
                caloriesburned = (caloriesburned * weightkg) / 200;
                caloriesburned *= minutes;
            } else {
                MPH *= 26.8;
                caloriesburned = (.2 * MPH) + (.9 * MPH) + 3.5;
                caloriesburned = (caloriesburned * weightkg) / 200;
                caloriesburned *= minutes;
            }
        }
            TextView displaycaloriesburned = findViewById(R.id.caloriesburned);
            displaycaloriesburned.setVisibility(View.VISIBLE);
            displaycaloriesburned.setText(String.format("You have burned %.0f calories", caloriesburned));
    }
    public void returntohomepage(View v){
        Intent returntohomepage = new Intent(this, MainActivity.class);
        startActivity(returntohomepage);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        spinnerposition = position;
        EditText hiddeennumbereditview = findViewById(R.id.hiddeneditview);
        TextView hiddeennumbertextview = findViewById(R.id.hiddentextview);
        switch (position){
            case 4:
            case 5:
            case 6:
            case 7:
            case 12:
            case 13:
            case 14:
            case 15:
            case 17:
            case 22:
                hiddeennumbereditview.setVisibility(View.GONE);
                hiddeennumbertextview.setVisibility(View.GONE);
                MET = 3.8;
                break;
            case 2:
            case 3:
            case 8:
            case 10:
            case 16:
            case 19:
            case 21:
            case 23:
                hiddeennumbereditview.setVisibility(View.GONE);
                hiddeennumbertextview.setVisibility(View.GONE);
                MET = 6;
                break;
            case 1:
            case 9:
            case 11:
            case 18:
            case 20:
            case 24:
                hiddeennumbereditview.setVisibility(View.GONE);
                hiddeennumbertextview.setVisibility(View.GONE);
                MET = 8;
                break;
            case 25:
                hiddeennumbereditview.setVisibility(View.VISIBLE);
                hiddeennumbertextview.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}