package com.best.info.config;


import org.springframework.stereotype.Component;

@Component

public class Proproperties {
	private String headerApiKey;
	 private String imagePath;
	 
	 

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getHeaderApiKey() {
		return headerApiKey;
	}

	public void setHeaderApiKey(String headerApiKey) {
		this.headerApiKey = headerApiKey;
	}
}
