package com.flawlessconcepts.healthapp.roompckg.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "foods")
public class Food {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int foodId;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "ingridients")
    private String ingridients;
    @ColumnInfo(name = "calories")
    private double calories;
    @ColumnInfo(name = "guide")
    private String guide;
    @ForeignKey(entity = Ailment.class, parentColumns = "ailmentID", childColumns = "ailmentID", onDelete = ForeignKey.CASCADE)
    private int ailmentID;

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngridients() {
        return ingridients;
    }

    public void setIngridients(String ingridients) {
        this.ingridients = ingridients;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public int getAilmentID() {
        return ailmentID;
    }

    public void setAilmentID(int ailmentID) {
        this.ailmentID = ailmentID;
    }
}
