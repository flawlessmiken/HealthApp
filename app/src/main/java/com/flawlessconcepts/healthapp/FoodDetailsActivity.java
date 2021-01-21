package com.flawlessconcepts.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.flawlessconcepts.healthapp.roompckg.utils.AFood;

public class FoodDetailsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.food_details);
        TextView fname = (TextView)findViewById(R.id.fname);
        TextView ing = (TextView)findViewById(R.id.ing);
        TextView cal = (TextView)findViewById(R.id.cal);
        TextView guide = (TextView)findViewById(R.id.guide);
        Button bk = (Button)findViewById(R.id.rear);
        fname.setText("Name:" + AFood.getFood().getName());
        ing.setText("Ingridients: " + AFood.getFood().getIngridients());
        cal.setText("Calories: " + String.valueOf(AFood.getFood().getCalories()));
        guide.setText("Guide: " + AFood.getFood().getGuide());
        bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodDetailsActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
    }

}
