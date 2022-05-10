package com.example.healthadvisorpp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class Search extends AppCompatActivity {

    EditText searchbar;
    ListView foodlist;
    ArrayAdapter foodarrayadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchbar = findViewById(R.id.searchbar);
        foodlist = findViewById(R.id.foodlist);

        DatabaseHelper databaseHelper = new DatabaseHelper(Search.this);
        List<FoodModel> everything = databaseHelper.getFood();

        foodarrayadapter = new ArrayAdapter<FoodModel>(Search.this, android.R.layout.simple_list_item_1, everything);
        foodlist.setAdapter((foodarrayadapter));

        searchbar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Search.this.foodarrayadapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}