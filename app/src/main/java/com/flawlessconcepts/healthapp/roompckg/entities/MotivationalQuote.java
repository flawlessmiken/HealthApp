package com.flawlessconcepts.healthapp.roompckg.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "motivationalQuotes")
public class MotivationalQuote {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int mqId;
    @ColumnInfo(name = "quote")
    private String quote;

    public int getMqId() {
        return mqId;
    }

    public void setMqId(int mqId) {
        this.mqId = mqId;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
