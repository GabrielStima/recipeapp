package br.com.gabriel.recipeapp.models;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public class RecipeDTO {

	private String name;
	private String description;
	private String preparationTime;
	private int numberSteps;
	private BigDecimal difficult;
	private BigDecimal quality;
	private ArrayList<MultipartFile> imageCollection;
	
	public RecipeDTO(String name, String description, String preparationTime, int numberSteps,
			BigDecimal difficult, BigDecimal quality, ArrayList<MultipartFile> imageCollection) {
		this.name = name;
		this.description = description;
		this.preparationTime = preparationTime;
		this.numberSteps = numberSteps;
		this.difficult = difficult;
		this.quality = quality;
		this.imageCollection = imageCollection;
	}

	public ArrayList<MultipartFile> getImageCollection() {
		return imageCollection;
	}

	public void setImageCollection(ArrayList<MultipartFile> imageCollection) {
		this.imageCollection = imageCollection;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(String preparationTime) {
		this.preparationTime = preparationTime;
	}

	public int getNumberSteps() {
		return numberSteps;
	}

	public void setNumberSteps(int numberSteps) {
		this.numberSteps = numberSteps;
	}

	public BigDecimal getDifficult() {
		return difficult;
	}

	public void setDifficult(BigDecimal difficult) {
		this.difficult = difficult;
	}

	public BigDecimal getQuality() {
		return quality;
	}

	public void setQuality(BigDecimal quality) {
		this.quality = quality;
	}

	@Override
	public String toString() {
		return "RecipeDTO [name=" + name + ", description=" + description + ", preparationTime=" + preparationTime
				+ ", numberSteps=" + numberSteps + ", difficult=" + difficult + ", quality=" + quality
				+ ", imageCollection=" + imageCollection + "]";
	}
}
