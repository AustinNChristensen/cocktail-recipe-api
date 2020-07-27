package com.austinchristensen.cocktailrecipeapi.models;

import java.util.List;

public class CocktailDBResponse {
    private List<Drink> drinks;

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }
}


