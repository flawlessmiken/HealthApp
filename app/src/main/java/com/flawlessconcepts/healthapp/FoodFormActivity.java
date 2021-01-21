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

import com.flawlessconcepts.healthapp.roompckg.dao.AilmentDAO;
import com.flawlessconcepts.healthapp.roompckg.dao.FoodDAO;
import com.flawlessconcepts.healthapp.roompckg.db.AppDatabase;
import com.flawlessconcepts.healthapp.roompckg.entities.Ailment;
import com.flawlessconcepts.healthapp.roompckg.entities.Food;
import com.flawlessconcepts.healthapp.roompckg.utils.FoodItems;

import java.util.List;

public class FoodFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.food_form);
        TextView fmlb = (TextView)findViewById(R.id.fdlb);
        TextView qt2 = (TextView)findViewById(R.id.quote2);
        EditText disName = (EditText)findViewById(R.id.disName);
        Button sh = (Button)findViewById(R.id.shtb);
        Button bk = (Button)findViewById(R.id.bk);
        AppDatabase dbs = getAppDatabase();
        qt2.setText(dbs.motivationalQuoteDAO().getAll().get(1).getQuote());
        dbs.close();
        sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = getAppDatabase();
                AilmentDAO ail = db.ailmentDAO();
                Ailment ailm = ail.findByName(disName.getText().toString());
                db.close();
                if(ailm != null){
                    FoodDAO fdo = db.foodDAO();
                    List<Food> fds = fdo.findByDisease(ailm.getAilmentID());
                    FoodItems.setDailyTable(fds);
                    Intent intent = new Intent(FoodFormActivity.this,FoodTableActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Disease not in Records",Toast.LENGTH_SHORT).show();
                }
            }
        });
        bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodFormActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
    }

    protected AppDatabase getAppDatabase(){
        return Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "health").allowMainThreadQueries().build();
    }

}
