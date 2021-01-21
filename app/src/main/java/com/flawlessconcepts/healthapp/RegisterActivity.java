package com.flawlessconcepts.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.flawlessconcepts.healthapp.roompckg.dao.PersonDAO;
import com.flawlessconcepts.healthapp.roompckg.db.AppDatabase;
import com.flawlessconcepts.healthapp.roompckg.entities.Person;
import com.flawlessconcepts.healthapp.roompckg.utils.User;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.register);
        TextView lb = (TextView)findViewById(R.id.reglb);
        EditText phone = (EditText)findViewById(R.id.phone);
        EditText name = (EditText)findViewById(R.id.name);
        EditText email = (EditText)findViewById(R.id.email);
        EditText weight = (EditText)findViewById(R.id.weight);
        EditText height = (EditText)findViewById(R.id.height);
        EditText pword = (EditText)findViewById(R.id.pass);
        Button reg = (Button)findViewById(R.id.regis);
        Button bck = (Button)findViewById(R.id.back);
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person();
                person.setName(name.getText().toString());
                person.setPhone(phone.getText().toString());
                person.setEmail(email.getText().toString());
                person.setWeight(Double.parseDouble(weight.getText().toString()));
                person.setHeight(Double.parseDouble(height.getText().toString()));
                person.setPassword(pword.getText().toString());
                AppDatabase db = getAppDatabase();
                PersonDAO pd = db.personDAO();
                db.close();
                pd.addPerson(person);
                User.setPerson(person);
                Intent intent = new Intent(RegisterActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
    }

    protected AppDatabase getAppDatabase(){
        return Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "health").allowMainThreadQueries().build();
    }

}
