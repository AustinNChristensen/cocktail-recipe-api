package com.austinchristensen.cocktailrecipeapi.controllers;

import com.austinchristensen.cocktailrecipeapi.models.CocktailDBResponse;
import com.austinchristensen.cocktailrecipeapi.models.Drink;
import com.austinchristensen.cocktailrecipeapi.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cocktails")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/random")
    public Drink getRandomRecipe() {
        return this.recipeService.getRandomRecipe();
    }

    @GetMapping("all")
    public ResponseEntity<List<Drink>> getAllRecipes() {
        return this.recipeService.getAllCocktails();
    }

    @GetMapping("/categories/all")
    public List<String> getAllCategories() {
        return this.recipeService.getAllDrinkCategories();
    }
}
