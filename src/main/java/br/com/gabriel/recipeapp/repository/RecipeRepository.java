package br.com.gabriel.recipeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabriel.recipeapp.models.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{
	Recipe findById(long id);
}
