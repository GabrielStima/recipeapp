package br.com.gabriel.recipeapp.models;

public class ImgBBDataDTO {
	private String id;
	private String title;
	private String url_viewer;
	private String url;
	private String display_url;
	private String size;
	private String time;
	private String expiration;
	private ImgBBImage image;
	private ImgBBImage thumb;
	private String delete_url;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl_viewer() {
		return url_viewer;
	}
	public void setUrl_viewer(String url_viewer) {
		this.url_viewer = url_viewer;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDisplay_url() {
		return display_url;
	}
	public void setDisplay_url(String display_url) {
		this.display_url = display_url;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getExpiration() {
		return expiration;
	}
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
	public ImgBBImage getImage() {
		return image;
	}
	public void setImage(ImgBBImage image) {
		this.image = image;
	}
	public ImgBBImage getThumb() {
		return thumb;
	}
	public void setThumb(ImgBBImage thumb) {
		this.thumb = thumb;
	}
	public String getDelete_url() {
		return delete_url;
	}
	public void setDelete_url(String delete_url) {
		this.delete_url = delete_url;
	}
}
