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

    public String deleteById(Long recipeId) {
        recipeRepository.deleteById(recipeId);
        return "deleted recipe";
    }

    public Recipe updateRecipe(Recipe recipe) {
        Recipe existingRecipe = recipeRepository.findById(recipe.getId()).orElseThrow();
        existingRecipe.setId(recipe.getId());
        existingRecipe.setName(recipe.getName());
        existingRecipe.setIngredients(recipe.getIngredients());
        existingRecipe.setDescription(recipe.getDescription());
        existingRecipe.setInstructions(recipe.getInstructions());
        return recipeRepository.save(existingRecipe);
    }
}