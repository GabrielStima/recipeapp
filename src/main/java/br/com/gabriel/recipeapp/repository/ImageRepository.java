package br.com.gabriel.recipeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabriel.recipeapp.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{
	Image findById(long id);
}
