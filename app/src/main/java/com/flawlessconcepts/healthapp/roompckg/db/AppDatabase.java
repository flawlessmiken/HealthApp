package com.flawlessconcepts.healthapp.roompckg.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.flawlessconcepts.healthapp.roompckg.dao.AilmentDAO;
import com.flawlessconcepts.healthapp.roompckg.dao.FoodDAO;
import com.flawlessconcepts.healthapp.roompckg.dao.MotivationalQuoteDAO;
import com.flawlessconcepts.healthapp.roompckg.dao.PersonDAO;
import com.flawlessconcepts.healthapp.roompckg.dao.WorkoutRoutineDAO;
import com.flawlessconcepts.healthapp.roompckg.entities.Ailment;
import com.flawlessconcepts.healthapp.roompckg.entities.Food;
import com.flawlessconcepts.healthapp.roompckg.entities.MotivationalQuote;
import com.flawlessconcepts.healthapp.roompckg.entities.Person;
import com.flawlessconcepts.healthapp.roompckg.entities.WorkRoutine;

@Database(entities = {Ailment.class, Food.class, MotivationalQuote.class, Person.class, WorkRoutine.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract AilmentDAO ailmentDAO();
    public abstract FoodDAO foodDAO();
    public abstract MotivationalQuoteDAO motivationalQuoteDAO();
    public abstract PersonDAO personDAO();
    public abstract WorkoutRoutineDAO workoutRoutineDAO();

}
