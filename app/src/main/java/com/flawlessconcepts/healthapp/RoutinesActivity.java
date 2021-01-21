package com.flawlessconcepts.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.flawlessconcepts.healthapp.roompckg.dao.WorkoutRoutineDAO;
import com.flawlessconcepts.healthapp.roompckg.db.AppDatabase;
import com.flawlessconcepts.healthapp.roompckg.entities.WorkRoutine;

import java.util.ArrayList;
import java.util.List;

public class RoutinesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.routines);
        AppDatabase db = getAppDatabase();
        WorkoutRoutineDAO wrk = db.workoutRoutineDAO();
        List<WorkRoutine> allRoutines = wrk.getAll();
        db.close();
        String [] routs = new String[allRoutines.size()];
        for(int i = 0; i < routs.length; i++){
              routs[i] = allRoutines.get(i).getRoutineName() + "\n" + allRoutines.get(i).getDescription();
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.routines_list, R.id.routines_list, routs);

        ListView listView = (ListView) findViewById(R.id.routines);
        listView.setAdapter(adapter);
    }

    protected AppDatabase getAppDatabase(){
        return Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "health").allowMainThreadQueries().build();
    }

}
