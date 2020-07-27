package com.austinchristensen.cocktailrecipeapi.models;

import java.util.List;

public class AllCategoriesResponse {

    private List<Category> drinks;

    public List<Category> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Category> drinks) {
        this.drinks = drinks;
    }
}
