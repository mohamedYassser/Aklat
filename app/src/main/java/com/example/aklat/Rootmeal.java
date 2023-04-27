package com.example.aklat;

import java.util.ArrayList;

public class Rootmeal {
    public ArrayList<Meal> meals;

    public Rootmeal() {
    }

    public Rootmeal(ArrayList<Meal> meals) {
        this.meals = meals;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }
}
