package com.flawlessconcepts.healthapp.roompckg.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.flawlessconcepts.healthapp.roompckg.entities.Food;
import com.flawlessconcepts.healthapp.roompckg.entities.WorkRoutine;

import java.util.List;

@Dao
public interface FoodDAO {

    @Query("SELECT * FROM foods")
    List<Food> getAll();

    @Query("SELECT * FROM foods WHERE name LIKE :name LIMIT 1")
    Food findByName(String name);

    @Query("SELECT * FROM foods WHERE ailmentID LIKE :id")
    List<Food> findByDisease(int id);

    @Insert
    void addFood(Food food);

}
