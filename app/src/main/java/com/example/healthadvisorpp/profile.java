package com.example.healthadvisorpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class profile extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    int positionspinnerweight, positionspinnerheight, positionspinnergender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //weight spinner
        Spinner wspinner = findViewById(R.id.spinnerweight);
        List<String> wmeasurements = new ArrayList<>();
        wmeasurements.add(0, "lbs");
        wmeasurements.add("kg");
        ArrayAdapter<String> weightspinner = new ArrayAdapter(this, android.R.layout.simple_spinner_item, wmeasurements);
        weightspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        wspinner.setAdapter(weightspinner);
        wspinner.setOnItemSelectedListener(this);

        //height spinner
        Spinner hspinner = findViewById(R.id.spinnerheight);
        List<String> hmeasurements = new ArrayList<>();
        hmeasurements.add(0, "inches");
        hmeasurements.add("centimeters");
        ArrayAdapter<String> heightspinner = new ArrayAdapter(this, android.R.layout.simple_spinner_item, hmeasurements);
        heightspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hspinner.setAdapter(heightspinner);
        hspinner.setOnItemSelectedListener(this);

        //gender spinner
        Spinner gspinner = findViewById(R.id.spinnergender);
        List<String> genders = new ArrayList<>();
        genders.add(0, "Male");
        genders.add("Female");
        ArrayAdapter<String> genderspinner = new ArrayAdapter(this, android.R.layout.simple_spinner_item, genders);
        genderspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gspinner.setAdapter(genderspinner);
        gspinner.setOnItemSelectedListener(this);
        }

    //Enter info for profile
    public void storeandgotohomescreen(View v){
        EditText etname = findViewById(R.id.insertname);
        String name = etname.getEditableText().toString();

        EditText etage = findViewById(R.id.insertage);
        String sage = etage.getEditableText().toString();
        int age = Integer.parseInt(sage);

        EditText etweight = findViewById(R.id.insertweight);
        double weight = Double.parseDouble(etweight.getText().toString());

        EditText etheight = findViewById(R.id.insertheight);
        double height = Double.parseDouble(etheight.getText().toString());

        Intent intent = new Intent (this, MainActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("age", age);
        intent.putExtra("weight", weight);
        intent.putExtra("height", height);
        intent.putExtra("positionweight", positionspinnerweight);
        intent.putExtra("positionhheight", positionspinnerheight);
        intent.putExtra("gender", positionspinnergender);
        startActivity(intent);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        Spinner spinner = (Spinner) parent;
        if(spinner.getId() == R.id.spinnerweight) {
            positionspinnerweight = position;
        }
        else if(spinner.getId() == R.id.spinnerheight){
            positionspinnerheight = position;
        }
        else if(spinner.getId() == R.id.spinnergender){
            positionspinnergender = position;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}