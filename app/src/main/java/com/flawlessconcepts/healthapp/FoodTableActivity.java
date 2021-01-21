package com.flawlessconcepts.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.flawlessconcepts.healthapp.roompckg.utils.FoodItems;

import java.util.List;

public class FoodTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_table);
        String [] routs = new String[FoodItems.getDailyTable().size()];
        for(int i = 0; i < FoodItems.getDailyTable().size(); i++){
            routs[i] = FoodItems.getDailyTable().get(i).getName() + "\nCalories: " + FoodItems.getDailyTable().get(i).getCalories();
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.afood, R.id.afood, routs);

        ListView listView = (ListView) findViewById(R.id.foods);
        listView.setAdapter(adapter);
    }

}
