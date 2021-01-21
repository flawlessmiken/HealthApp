package com.flawlessconcepts.healthapp.roompckg.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ailments")
public class Ailment {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int ailmentID;
    @ColumnInfo(name = "ailmentName")
    private String ailmentName;
    @ColumnInfo(name = "description")
    private String description;

    public int getAilmentID() {
        return ailmentID;
    }

    public void setAilmentID(int ailmentID) {
        this.ailmentID = ailmentID;
    }

    public String getAilmentName() {
        return ailmentName;
    }

    public void setAilmentName(String ailmentName) {
        this.ailmentName = ailmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
