package br.com.gabriel.recipeapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.recipeapp.models.Image;
import br.com.gabriel.recipeapp.models.ImgBBDTO;
import br.com.gabriel.recipeapp.models.Recipe;
import br.com.gabriel.recipeapp.repository.ImageRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Images")
@CrossOrigin(origins = "*")
public class ImageController {

	@Autowired
	ImageRepository imageRepository;
	
	public ImageController(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}

	@GetMapping("/image")
	@ApiOperation(value = "Retorna todas as imagens cadastradas")
	public List<Image> listAllImages() {
		return imageRepository.findAll();
	}

	@GetMapping("/image/{id}")
	@ApiOperation(value = "Retorna uma determinada imagem")
	public Image listImageById(@PathVariable(value = "id") long id) {
		return imageRepository.findById(id);
	}

	public ResponseEntity<?> createImage(ResponseEntity<ImgBBDTO> image, int step, Recipe recipe) {
		
		Image imageEntity = new Image(image.getBody().getData().getUrl(), image.getBody().getData().getTitle(), step,
				recipe);

		System.out.println(imageEntity);
		
		return new ResponseEntity<>(imageRepository.save(imageEntity), HttpStatus.OK);
	}

	@DeleteMapping("/image/{id}")
	@ApiOperation(value = "Deleta uma image especifica")
	public void deleteImage(@PathVariable(value = "id") long id) {

	}

	@PutMapping("/image/{id}")
	@ApiOperation(value = "Atualiza uma image especifica")
	public void updateImage(@PathVariable(value = "id") long id, @RequestBody Image image) {

	}
}
