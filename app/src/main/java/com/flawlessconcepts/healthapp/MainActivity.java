package com.flawlessconcepts.healthapp;

import android.content.Intent;
import android.os.Bundle;

import com.flawlessconcepts.healthapp.roompckg.dao.AilmentDAO;
import com.flawlessconcepts.healthapp.roompckg.dao.FoodDAO;
import com.flawlessconcepts.healthapp.roompckg.dao.MotivationalQuoteDAO;
import com.flawlessconcepts.healthapp.roompckg.dao.PersonDAO;
import com.flawlessconcepts.healthapp.roompckg.dao.WorkoutRoutineDAO;
import com.flawlessconcepts.healthapp.roompckg.db.AppDatabase;
import com.flawlessconcepts.healthapp.roompckg.entities.Ailment;
import com.flawlessconcepts.healthapp.roompckg.entities.Food;
import com.flawlessconcepts.healthapp.roompckg.entities.MotivationalQuote;
import com.flawlessconcepts.healthapp.roompckg.entities.Person;
import com.flawlessconcepts.healthapp.roompckg.entities.WorkRoutine;
import com.flawlessconcepts.healthapp.roompckg.utils.User;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loadData();
        TextView txtView = (TextView)findViewById(R.id.frmLabel);
        EditText email = (EditText)findViewById(R.id.email);
        EditText pword = (EditText)findViewById(R.id.pword);
        Button lgn = (Button)findViewById(R.id.lgn);
        Button reg = (Button)findViewById(R.id.reg);

        lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db = getAppDatabase();
                PersonDAO personDAO = db.personDAO();
                Person person = personDAO.findByName(email.getText().toString(),pword.getText().toString());
                db.close();
                if(person != null){
                    User.setPerson(person);
                    Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Invalid User Details",Toast.LENGTH_SHORT).show();
                }
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        AppDatabase database = getAppDatabase();
        MotivationalQuoteDAO mot = database.motivationalQuoteDAO();
        if(mot.getAll().isEmpty()) {
            MotivationalQuote quote = new MotivationalQuote();
            quote.setQuote("The best way to get started is to quit talking");
            mot.addMotivationalQuote(quote);
            System.out.println("First Quote Added");
            MotivationalQuote quote2 = new MotivationalQuote();
            quote.setQuote("Dont let way yesterday take up too much of today");
            mot.addMotivationalQuote(quote2);
            System.out.println("Second Quote Added");
        }
        WorkoutRoutineDAO wrd = database.workoutRoutineDAO();
        if(wrd.getAll().isEmpty()) {
            WorkRoutine wr = new WorkRoutine();
            wr.setRoutineName("Jumping Jacks");
            wr.setDescription("Stand straight with your feet together and hands on the side. Jump along with raising your arm" +
                    "above your head and bring your feet apart. Reverse the movement immediately and come back to the original position." +
                    "Start doing it faster");
            wrd.addWorkRoutine(wr);
            WorkRoutine wr2 = new WorkRoutine();
            wr2.setRoutineName("Plank");
            wr2.setDescription("Get into push up position with elbows bent in 90 degrees keeping your body weight on your forearms" +
                    "Ensure your body forms a straight line from your head. Hold that position as long as you can.");
            wrd.addWorkRoutine(wr2);
            WorkRoutine wr3 = new WorkRoutine();
            wr3.setRoutineName("Squats");
            wr3.setDescription("Start with the hips back, with back straight, chest and shoulders up. Bend your knees and squat down" +
                    "keeping them in line with your feet. Start with 25 squats a day and increase");
            wrd.addWorkRoutine(wr3);
        }
        AilmentDAO ado = database.ailmentDAO();
        if(ado.getAll().isEmpty()){
            Ailment ailment = new Ailment();
            ailment.setAilmentName("Diabetes");
            ailment.setDescription("High blood sugar levels");
            ado.addAilment(ailment);
            Ailment ailment2 = new Ailment();
            ailment2.setAilmentName("Hypertension");
            ailment2.setDescription("High blood pressure levels");
            ado.addAilment(ailment2);
        }
        FoodDAO foodDAO = database.foodDAO();
        if(foodDAO.getAll().isEmpty()){
            Food food1 = new Food();
            food1.setName("Spanish Omelet");
            food1.setIngridients("Available on Request");
            food1.setGuide("Available on Request");
            food1.setCalories(210);
            food1.setAilmentID(ado.getAll().get(0).getAilmentID());
            foodDAO.addFood(food1);
            Food food2 = new Food();
            food2.setName("Caribbean Fiesta");
            food2.setIngridients("Available on Request");
            food2.setGuide("Available on Request");
            food2.setCalories(440);
            food2.setAilmentID(ado.getAll().get(0).getAilmentID());
            foodDAO.addFood(food2);
            Food food3 = new Food();
            food3.setName("Turkey Stew");
            food3.setIngridients("Available on Request");
            food3.setGuide("Available on Request");
            food3.setCalories(450);
            food3.setAilmentID(ado.getAll().get(0).getAilmentID());
            foodDAO.addFood(food3);
            Food food4 = new Food();
            food4.setName("Caribbean Red Snapper");
            food4.setIngridients("Available on Request");
            food4.setGuide("Available on Request");
            food4.setCalories(210);
            food4.setAilmentID(ado.getAll().get(1).getAilmentID());
            foodDAO.addFood(food4);
            Food food5 = new Food();
            food5.setName("Two Cheese Pizza");
            food5.setIngridients("Available on Request");
            food5.setGuide("Available on Request");
            food5.setCalories(440);
            food5.setAilmentID(ado.getAll().get(1).getAilmentID());
            foodDAO.addFood(food5);
            Food food6 = new Food();
            food6.setName("Cuban Beans and rice");
            food6.setIngridients("Available on Request");
            food6.setGuide("Available on Request");
            food6.setCalories(400);
            food6.setAilmentID(ado.getAll().get(1).getAilmentID());
            foodDAO.addFood(food6);

        }
        database.close();
    }

    protected AppDatabase getAppDatabase(){
        return Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "health").allowMainThreadQueries().build();
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    } */
}