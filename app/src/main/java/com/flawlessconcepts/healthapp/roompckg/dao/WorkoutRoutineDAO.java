package com.flawlessconcepts.healthapp.roompckg.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.flawlessconcepts.healthapp.roompckg.entities.WorkRoutine;

import java.util.List;

@Dao
public interface WorkoutRoutineDAO {

    @Query("SELECT * FROM workRoutines")
    List<WorkRoutine> getAll();

    @Query("SELECT * FROM workRoutines WHERE routineName LIKE :routineName LIMIT 1")
    WorkRoutine findByName(String routineName);

    @Insert
    void addWorkRoutine(WorkRoutine routine);
}
