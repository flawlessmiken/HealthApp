package com.flawlessconcepts.healthapp.roompckg.utils;

import com.flawlessconcepts.healthapp.roompckg.entities.Food;

public class AFood {

    private static Food food;

    public static Food getFood() {
        return food;
    }

    public static void setFood(Food food) {
        AFood.food = food;
    }
}
