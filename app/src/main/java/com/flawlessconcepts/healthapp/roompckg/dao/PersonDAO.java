package com.flawlessconcepts.healthapp.roompckg.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.flawlessconcepts.healthapp.roompckg.entities.Person;

@Dao
public interface PersonDAO {

    @Query("SELECT * FROM persons WHERE email LIKE :email AND " +
            "password LIKE :pword LIMIT 1")
    Person findByName(String email, String pword);

    @Insert
    void addPerson(Person person);
}
