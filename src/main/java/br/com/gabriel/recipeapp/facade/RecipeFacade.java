package br.com.gabriel.recipeapp.facade;

import java.util.List;

import br.com.gabriel.recipeapp.models.ImgBBDTO;
import br.com.gabriel.recipeapp.models.Recipe;
import br.com.gabriel.recipeapp.models.RecipeDTO;
import br.com.gabriel.recipeapp.repository.RecipeRepository;
import br.com.gabriel.recipeapp.services.ImgBBService;
import br.com.gabriel.recipeapp.services.RecipeService;

public class RecipeFacade {
	
	RecipeRepository recipeRepository;
	RecipeService recipeService = new RecipeService(recipeRepository);
	ImgBBService imgBBService = new ImgBBService();
	
	public List<Recipe> listAllRecipe() {
		return recipeService.listAllRecipe();
	}
	
	public Recipe listRecipeById(long id) {
		return recipeService.listRecipeById(id);
	}
	
	public String createRecipe(RecipeDTO recipe) {
		Recipe recipeWithoutImageList = new Recipe(recipe.getName(), recipe.getDescription(), recipe.getPreparationTime(), recipe.getNumberSteps(), recipe.getDifficult(), recipe.getQuality());
		Recipe recipeWithId = recipeService.createRecipe(recipeWithoutImageList);

		List<ImgBBDTO> returnImgBBService = imgBBService.requestForImgBB(recipeWithId.getId(), recipe.getImageCollection());
		
		return "a";
	}
	
	public Recipe deleteRecipe(long id) {
		recipeService.deleteRecipe(id);
		return recipeService.listRecipeById(id);
	}
	
	public Recipe updateRecipe(long id, Recipe recipe) {
		Recipe tempRecipe = new Recipe(id, recipe.getName(), recipe.getDescription(), recipe.getPreparationTime(), recipe.getNumberSteps(), recipe.getDifficult(), recipe.getQuality(), recipe.getImageCollection());
		return recipeService.updateRecipe(tempRecipe);
	}
}
