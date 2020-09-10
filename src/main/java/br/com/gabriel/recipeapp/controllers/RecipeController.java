package br.com.gabriel.recipeapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.recipeapp.facade.RecipeFacade;
import br.com.gabriel.recipeapp.models.Recipe;
import br.com.gabriel.recipeapp.models.RecipeDTO;
import br.com.gabriel.recipeapp.repository.RecipeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Recipes")
@CrossOrigin(origins = "*")
public class RecipeController {
	
	RecipeFacade recipeFacade = new RecipeFacade();
	
	@GetMapping("/recipe")
	@ApiOperation(value = "Retorna todas as receitas cadastradas")
	public ResponseEntity<?> listAllRecipe() {
		return new ResponseEntity<>(recipeFacade.listAllRecipe(), HttpStatus.OK);
	}
	
	@GetMapping("/recipe/{id}")
	@ApiOperation(value = "Retorna uma determinada receita")
	public ResponseEntity<?> listRecipeById(@PathVariable(value = "id") long id) {
		return new ResponseEntity<>(recipeFacade.listRecipeById(id), HttpStatus.OK);
	}
	
	@PostMapping(path = "/recipe", consumes = { "multipart/form-data" })
	@ApiOperation(value = "Cadastra uma receita")
	public ResponseEntity<?> createRecipe(@ModelAttribute RecipeDTO recipe) {
		return new ResponseEntity<>(recipeFacade.createRecipe(recipe), HttpStatus.OK);
	}
	
	@DeleteMapping("/recipe/{id}")
	@ApiOperation(value = "Deleta uma receita especifica")
	public ResponseEntity<?> deleteRecipe(@PathVariable(value = "id") long id) {
		return new ResponseEntity<>(recipeFacade.deleteRecipe(id), HttpStatus.OK);
	}

	@PutMapping("/recipe/{id}")
	@ApiOperation(value = "Atualiza uma receita especifica")
	public ResponseEntity<?> updateRecipe(@PathVariable(value = "id") long id, @RequestBody Recipe recipe) {
		return new ResponseEntity<>(recipeFacade.updateRecipe(id, recipe), HttpStatus.OK);
	}
}
