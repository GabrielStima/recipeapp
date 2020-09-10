package br.com.gabriel.recipeapp.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import br.com.gabriel.recipeapp.models.ImgBBDTO;
import br.com.gabriel.recipeapp.models.Recipe;

public class ImgBBService {
	public File convert(MultipartFile file) {
		File convFile = new File(file.getOriginalFilename());
		try {
			convFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(file.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return convFile;
	}
	
	public List<ImgBBDTO> requestForImgBB(long id, List<MultipartFile> imageCollection) {
		List<ImgBBDTO> imageCollectionResponse = new ArrayList<ImgBBDTO>();
		String url = "https://api.imgbb.com/1/upload?key=6633f36fac958ae5399dcfbd92a6d7e1";
		MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
		
		for (int i = 0; i < imageCollection.size(); i++) {
			bodyMap.add("image", new FileSystemResource(convert(imageCollection.get(i))));
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);
			HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);
			RestTemplate restTemplate = new RestTemplate();			
			ResponseEntity<ImgBBDTO> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, ImgBBDTO.class);
			System.out.println(response);
		}
		
		
		
		
		
//		ImageController imageController = new ImageController();
		
//		ResponseEntity<?> responseImage = imageController.createImage(response, step, recipe);
		
//		System.out.println(responseImage);
		
		return imageCollectionResponse;
	}
}
