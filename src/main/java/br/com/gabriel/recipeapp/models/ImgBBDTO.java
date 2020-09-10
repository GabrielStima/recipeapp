package br.com.gabriel.recipeapp.models;

public class ImgBBDTO {
	private ImgBBDataDTO data;
	private String sucess;
	private String status;
	
	public ImgBBDataDTO getData() {
		return data;
	}
	public void setData(ImgBBDataDTO data) {
		this.data = data;
	}
	public String getSucess() {
		return sucess;
	}
	public void setSucess(String sucess) {
		this.sucess = sucess;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
