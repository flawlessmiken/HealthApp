package com.flawlessconcepts.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.flawlessconcepts.healthapp.roompckg.dao.FoodDAO;
import com.flawlessconcepts.healthapp.roompckg.db.AppDatabase;
import com.flawlessconcepts.healthapp.roompckg.entities.Food;
import com.flawlessconcepts.healthapp.roompckg.utils.AFood;

public class SearchFoodActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstace) {
        super.onCreate(savedInstace);
        setContentView(R.layout.search_food);
        TextView lb = (TextView)findViewById(R.id.srlb);
        EditText fdn = (EditText)findViewById(R.id.fdname);
        Button search = (Button)findViewById(R.id.src);
        Button bk = (Button)findViewById(R.id.enyi);
        bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchFoodActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = getAppDatabase();
                FoodDAO fdo = db.foodDAO();
                Food fd = fdo.findByName(fdn.getText().toString());
                db.close();
                if(fd != null){
                    AFood.setFood(fd);
                    Intent intent = new Intent(SearchFoodActivity.this,FoodDetailsActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Food Not in Records",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected AppDatabase getAppDatabase(){
        return Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "health").allowMainThreadQueries().build();
    }

}
