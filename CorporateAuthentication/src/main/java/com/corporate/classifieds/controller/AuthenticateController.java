package com.corporate.classifieds.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.corporate.classifieds.model.AuthenticateRequest;
import com.corporate.classifieds.model.JwtAuthenticationResponse;
import com.corporate.classifieds.model.UserPrincipal;
import com.corporate.classifieds.service.JWTTokenProvider;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JWTTokenProvider jwtTokenProvider;

	@PostMapping("/authenticate")
	public ResponseEntity authenticateUser(@RequestBody AuthenticateRequest authenticateRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(), authenticateRequest.getPassword()));
        String token =jwtTokenProvider.generateToken((UserPrincipal)authentication.getPrincipal());
        log.info("Token Created {}",token);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
	}

	@GetMapping("/sample")
	@PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
	public ResponseEntity<String> sayHello() {
		return new ResponseEntity<>("Hello", HttpStatus.OK);
	}
	
}
