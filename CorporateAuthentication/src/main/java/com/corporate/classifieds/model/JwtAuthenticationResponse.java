package com.corporate.classifieds.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class JwtAuthenticationResponse {
	private String accessToken;
    private final  String tokenType = "Bearer";
	public JwtAuthenticationResponse(String accessToken) {
		super();
		this.accessToken = accessToken;
	}
    
	
}
