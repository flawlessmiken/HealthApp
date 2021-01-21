package com.flawlessconcepts.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.flawlessconcepts.healthapp.roompckg.utils.User;

public class WaterIntakeActivity extends AppCompatActivity {

    protected void onCreate(Bundle sBundle) {
        super.onCreate(sBundle);
        setContentView(R.layout.water_intake);
        TextView name = (TextView)findViewById(R.id.wname);
        TextView hgt = (TextView)findViewById(R.id.wh);
        TextView wgt = (TextView)findViewById(R.id.ww);
        TextView water = (TextView)findViewById(R.id.presc);
        Button but = (Button)findViewById(R.id.azu);
        name.setText("Name: " + User.getPerson().getName());
        hgt.setText("Height: " + String.valueOf(User.getPerson().getHeight()));
        wgt.setText("Weight: " + String.valueOf(User.getPerson().getWeight()));
        double wt = User.getPerson().getWeight();
        double ater = 0.67 * wt;
        water.setText("Water Intake: " + ater + " ounces daily");
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WaterIntakeActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
    }

}
