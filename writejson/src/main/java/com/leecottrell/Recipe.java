package com.leecottrell;

import java.util.Map;
import java.util.List;
public class Recipe {
    private String RecipeName;
    private int Calories;
    private List<String> Ingredients;
    private Map<String, String> Steps;
    private boolean AllergyWarning;
    //build setters, getters, both constructors
    public String getRecipeName() {
        return RecipeName;
    }
    public void setRecipeName(String recipeName) {
        RecipeName = recipeName;
    }
    public int getCalories() {
        return Calories;
    }
    public void setCalories(int calories) {
        Calories = calories;
    }
    public List<String> getIngredients() {
        return Ingredients;
    }
    public void setIngredients(List<String> ingredients) {
        Ingredients = ingredients;
    }
    public Map<String, String> getSteps() {
        return Steps;
    }
    public void setSteps(Map<String, String> steps) {
        Steps = steps;
    }
    public boolean isAllergyWarning() {
        return AllergyWarning;
    }
    public void setAllergyWarning(boolean allergyWarning) {
        AllergyWarning = allergyWarning;
    }
    public Recipe() {
    }
    public Recipe(String recipeName, int calories, List<String> ingredients, Map<String, String> steps,
            boolean allergyWarning) {
        RecipeName = recipeName;
        Calories = calories;
        Ingredients = ingredients;
        Steps = steps;
        AllergyWarning = allergyWarning;
    }

    //setters and getters, construtors
    


}
