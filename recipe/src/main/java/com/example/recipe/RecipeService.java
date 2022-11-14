package com.example.recipe;

import com.example.recipe.Models.Recipe;
import com.example.recipe.Repository.IngredientsRepository;
import com.example.recipe.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final IngredientsRepository ingredientsRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, IngredientsRepository ingredientsRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientsRepository = ingredientsRepository;
    }

    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> findAllRecipes() {
        return recipeRepository.findAll();
    }

    public void deleteById(Long recipeId) {
        recipeRepository.deleteById(recipeId);
    }

    public void updateRecipe(Long recipeId, String name, String description) {
        recipeRepository.findById(recipeId);
    }
}