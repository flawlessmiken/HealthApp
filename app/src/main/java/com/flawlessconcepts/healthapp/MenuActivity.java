package com.flawlessconcepts.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.flawlessconcepts.healthapp.roompckg.db.AppDatabase;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.health_menu);
        TextView lb = (TextView)findViewById(R.id.menulb);
        TextView qt = (TextView)findViewById(R.id.quote);
        Button toFood = (Button)findViewById(R.id.fdtlb);
        Button routines = (Button)findViewById(R.id.wrkrtns);
        Button waterIntake = (Button)findViewById(R.id.wt);
        Button search = (Button)findViewById(R.id.srch);
        AppDatabase db = getAppDatabase();
        qt.setText(db.motivationalQuoteDAO().getAll().get(0).getQuote());
        db.close();
        toFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,FoodFormActivity.class);
                startActivity(intent);
            }
        });
        routines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,RoutinesActivity.class);
                startActivity(intent);
            }
        });
        waterIntake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,WaterIntakeActivity.class);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,SearchFoodActivity.class);
                startActivity(intent);
            }
        });
    }

    protected AppDatabase getAppDatabase(){
        return Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "health").allowMainThreadQueries().build();
    }

}
