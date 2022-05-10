package com.example.healthadvisorpp;

public class FoodModel {

    private String name;
    private int calories;

    //constructor
    public FoodModel(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }
    public FoodModel() {
    }

    //toString is necessary for printing the contents of a class object
    @Override
    public String toString() {
        return name + '\n' + calories + " calories";
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
