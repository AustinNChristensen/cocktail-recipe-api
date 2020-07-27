package com.austinchristensen.cocktailrecipeapi.service;

import com.austinchristensen.cocktailrecipeapi.models.AllCategoriesResponse;
import com.austinchristensen.cocktailrecipeapi.models.Category;
import com.austinchristensen.cocktailrecipeapi.models.CocktailDBResponse;
import com.austinchristensen.cocktailrecipeapi.models.Drink;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RecipeService {

    private final String cocktailAPIBaseURL = "https://www.thecocktaildb.com/api/json/v1/1";

    private final String listGlassesEndpoint = "/list.php?g=list";
    private final String listIngredientsEndpoint = "/list.php?i=list";
    private final String listAlcoholicEndpoint = "/list.php?a=list";

    public Drink getRandomRecipe() {
        RestTemplate restTemplate = new RestTemplate();
        String randomEndpoint = "/random.php";
        CocktailDBResponse dbResponse = restTemplate.getForObject(cocktailAPIBaseURL + randomEndpoint, CocktailDBResponse.class);
        return Objects.requireNonNull(dbResponse).getDrinks().get(0);
    }

    public CocktailDBResponse getAllRecipes() {
        RestTemplate restTemplate = new RestTemplate();
        String searchEndpoint = "/search.php";
        return restTemplate.getForObject(cocktailAPIBaseURL + searchEndpoint, CocktailDBResponse.class);
    }

    public List<String> getAllDrinkCategories() {
        String listCategoriesEndpoint = "/list.php?c=list";
        RestTemplate restTemplate = new RestTemplate();
        List<String> response = new ArrayList<>();

        for(Category category : Objects.requireNonNull(restTemplate.getForObject(cocktailAPIBaseURL + listCategoriesEndpoint, AllCategoriesResponse.class)).getDrinks()){
            response.add(category.getStrCategory());
        }

        return response;
    }

    public ResponseEntity<List<Drink>> getAllCocktails() {
        String getCocktailsEndpoint = "/list.php?c=Cocktail";
        RestTemplate restTemplate = new RestTemplate();

        CocktailDBResponse response2 = restTemplate.getForObject(cocktailAPIBaseURL + getCocktailsEndpoint, CocktailDBResponse.class);
        List<Drink> drinks = new ArrayList<>(Objects.requireNonNull(response2).getDrinks());
        return ResponseEntity.ok(drinks);
    }
}
