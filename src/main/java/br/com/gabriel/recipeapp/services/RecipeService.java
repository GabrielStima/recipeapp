package br.com.gabriel.recipeapp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.gabriel.recipeapp.models.Recipe;
import br.com.gabriel.recipeapp.repository.RecipeRepository;

public class RecipeService {
	
	@Autowired
	RecipeRepository recipeRepository;
	
	public RecipeService(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}
	
	public List<Recipe> listAllRecipe() {
		return recipeRepository.findAll();
	}
	
	public Recipe listRecipeById(long id) {
		return recipeRepository.findById(id);
	}
	
	public Recipe createRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}
	
	public void deleteRecipe(long id) {
		recipeRepository.deleteById(id);
	}
	
	public Recipe updateRecipe(Recipe recipe) {
		Recipe getExistentRecipe = recipeRepository.findById(recipe.getId());
		getExistentRecipe = recipe;
		return recipeRepository.save(getExistentRecipe);
	}
}
