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
        List<String> exercises = new ArrayList<>();
        exercises.add(0, "Please select an exercise");
        exercises.add("push ups");
        exercises.add("sit ups");
        exercises.add("treadmill");
        ArrayAdapter<String> exercisespinner = new ArrayAdapter(this, android.R.layout.simple_spinner_item, exercises);
        exercisespinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        espinner.setAdapter(exercisespinner);
        espinner.setOnItemSelectedListener(this);

    }

    public void calculate(View v) {
        EditText etminutes = findViewById(R.id.minutes);
        String sminutes = etminutes.getEditableText().toString();
        minutes = Integer.parseInt(sminutes);

        Intent intent = getIntent();
        double weightkg = intent.getDoubleExtra("weightkg", 0);


        /*else if (spinnerposition == 3)
        {
            if (MPH <= 3.7) {
                MPH *= 26.8;
                caloriesburned = (.1 * MPH) + (1.8 * MPH) + 3.5;
            } else {
                MPH *= 26.8;
                caloriesburned = (.2 * MPH) + (.9 * MPH) + 3.5;
                caloriesburned = (caloriesburned * weightkg) / 200;
                caloriesburned *= minutes;
            }*/
        if (spinnerposition != 3)
            {
                caloriesburned = (MET * 3.5 * weightkg / 200) * minutes;
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
        EditText hiddeennumbereditview = findViewById(R.id.hiddeneditview);
        TextView hiddeennumbertextview = findViewById(R.id.hiddentextview);
        spinnerposition = position;
        switch (position){
            case 1:
            case 2:
                hiddeennumbereditview.setVisibility(View.GONE);
                hiddeennumbertextview.setVisibility(View.GONE);
                MET = 3.8;
                break;
            case 3:
                //hiddeennumbereditview.setVisibility(View.VISIBLE);
                //hiddeennumbertextview.setVisibility(View.VISIBLE);
                //MPH = Double.parseDouble(hiddeennumbereditview.getText().toString());
                //break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}