package com.example.healthadvisorpp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double heightcm, heightin, weightkg, weightlbs, BMI, BMR;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        //get positions
        int positionspinnerweight = intent.getIntExtra("positionweight", 0);
        int positionspinnerheight = intent.getIntExtra("positionheight", 0);
        int positionspinnergender = intent.getIntExtra("gender", 2);

        //display name
        String name = intent.getStringExtra("name");
        TextView displayname = findViewById(R.id.TextViewName);
        if (name == null)
            displayname.setText("Name: Not Entered");
        else
            displayname.setText("Name: " + name);

        //display age
        int age = intent.getIntExtra("age", 0);
        TextView displayage = findViewById(R.id.TextViewAge);
        if (age == 0)
            displayage.setText("Age: Not Entered");
        else
            displayage.setText("Age: " + age);

        //display weight
        double weight = intent.getDoubleExtra("weight", 0);
        if(positionspinnerweight == 0)
        {
            weightlbs = weight;
            weightkg = weightlbs / 2.205;
        }
        else if(positionspinnerweight == 1)
        {
            weightkg = weight;
            weightlbs = weightkg *2.205;
        }
        TextView displayweight = findViewById(R.id.TextViewWeight);
        if (weight == 0)
            displayweight.setText("Weight: Not Entered");
        else
            displayweight.setText(String.format("Weight: %.2f lbs %.2f kg", weightlbs, weightkg));

        //display height
        double height = intent.getDoubleExtra("height", 0);
        if(positionspinnerheight == 0)
        {
            heightin = height;
            heightcm = heightin * 2.54;
        }
        else if(positionspinnerheight == 1)
        {
            heightcm = height;
            heightin = heightcm / 2.54;
        }
        TextView displayheight = findViewById(R.id.TextViewHeight);
        if (height == 0)
            displayheight.setText("Height: Not Entered");
        else
            displayheight.setText(String.format("Height: %.2f\" %.2f cm", heightin, heightcm));

        //display gender
        TextView displaygender = findViewById(R.id.TextViewGender);
        if(positionspinnergender == 0)
          gender = "Male";
        else if(positionspinnergender == 1)
          gender = "Female";
        else
          gender = "Not Entered";
        displaygender.setText("Gender: " + gender);

        //calculate and display BMI and BMR
        BMI = weightkg / Math.pow(heightcm/ 100, 2);
        if(gender == "Male")
            BMR = (10 * weightkg) + (6.25 * heightcm) -(5 * age) + 5;
        else if(gender =="Female")
            BMR = (10 * weightkg) + (6.25 * heightcm) -(5 * age) - 161;
        TextView displayBMI = findViewById(R.id.TextViewBMI);
        if(weight == 0)
            displayBMI.setText("BMI: Can't Calculate");
            else
            displayBMI.setText(String.format("BMI: %.1f", BMI));
        TextView displayBMR = findViewById(R.id.TextViewBMR);
        if(weight == 0)
            displayBMR.setText("You burn X calories a day");
        else
            displayBMR.setText(String.format("You burn %.0f calories a day", BMR));

    }
    //buttons to go to different activities
    public void gotoexercisecalc(View v){
        Intent exercisecalc = new Intent(this, ExerciseCalculator.class);
        exercisecalc.putExtra("weightkg", weightkg);
        startActivity(exercisecalc);
    }
    public void gotoworkoutroutines(View v){
        Intent workoutroutines = new Intent(this, WorkoutRoutines.class);
        startActivity(workoutroutines);
    }
    public void gotofoodcalc(View v){
        Intent foodcalc = new Intent(this, FoodCalculator.class);
        startActivity(foodcalc);
    }
    public void gotostepcounter(View v){
        Intent stepcounter = new Intent(this, StepCounter.class);
        startActivity(stepcounter);
    }
    public void EditProfile(View v){
        Intent editprofile = new Intent (this, profile.class);
        startActivity(editprofile);
    }
    }
