package com.example.healthadvisorpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FoodCalculator extends AppCompatActivity {

    int calories, totalcalories = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_calculator);
    }

    public void AddCalories(View v) {
        TextView displaycalories = findViewById(R.id.calorieseatentoday);
        EditText etcalories = findViewById(R.id.mealcalories);
        String scalories = etcalories.getEditableText().toString();
        calories = Integer.parseInt(scalories);

        totalcalories += calories;

        displaycalories.setText("You have eaten " + totalcalories + " calories today");

        etcalories.setText("");
    }

    public void ResetCalories(View v) {
        TextView displaycalories = findViewById(R.id.calorieseatentoday);
        displaycalories.setText("");
        totalcalories = 0;
    }
}