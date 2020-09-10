package br.com.gabriel.recipeapp.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Recipe{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	private String preparationTime;
	private int numberSteps;
	private BigDecimal difficult;
	private BigDecimal quality;
	
	@ElementCollection(targetClass = Image.class)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private List<Image> imageCollection;
	
	public Recipe(long id, String name, String description, String preparationTime, int numberSteps,
			BigDecimal difficult, BigDecimal quality, List<Image> imageCollection) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.preparationTime = preparationTime;
		this.numberSteps = numberSteps;
		this.difficult = difficult;
		this.quality = quality;
		this.imageCollection = imageCollection;
	}
	
	public Recipe(String name, String description, String preparationTime, int numberSteps,
			BigDecimal difficult, BigDecimal quality) {
		this.name = name;
		this.description = description;
		this.preparationTime = preparationTime;
		this.numberSteps = numberSteps;
		this.difficult = difficult;
		this.quality = quality;
	}


	public long getId() {
		return id;
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
	

	public List<Image> getImageCollection() {
		return imageCollection;
	}

	public void setImageCollection(List<Image> imageCollection) {
		this.imageCollection = imageCollection;
	}

	public void getImageByStep(int step) {
		
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", description=" + description + ", preparationTime="
				+ preparationTime + ", numberSteps=" + numberSteps + ", difficult=" + difficult + ", quality=" + quality
				+ ", imageCollection=" + imageCollection + "]";
	}
	
	
}
