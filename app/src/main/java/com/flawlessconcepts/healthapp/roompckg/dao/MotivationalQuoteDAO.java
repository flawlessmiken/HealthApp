package com.flawlessconcepts.healthapp.roompckg.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.flawlessconcepts.healthapp.roompckg.entities.MotivationalQuote;
import com.flawlessconcepts.healthapp.roompckg.entities.WorkRoutine;

import java.util.List;

@Dao
public interface MotivationalQuoteDAO {
    @Query("SELECT * FROM motivationalQuotes")
    List<MotivationalQuote> getAll();

    @Query("SELECT * FROM motivationalQuotes WHERE quote LIKE :quote LIMIT 1")
    MotivationalQuote findByQuote(String quote);

    @Insert
    void addMotivationalQuote(MotivationalQuote quote);

}
