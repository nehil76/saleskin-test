package com.example.saleskin_test.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.saleskin_test.model.AuthenticationRequest;
import com.example.saleskin_test.model.AuthenticationResponse;

@RestController
public class AuthenticationController {


	@Autowired
	private AuthenticationManager authManager;

	

	@RequestMapping(method = RequestMethod.POST, value = "/authentication")
	public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest autehenticationRequest) throws Exception {

		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(autehenticationRequest.getUsername(),
					autehenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Bad credentials", e);
		}
		return ResponseEntity.ok(new AuthenticationResponse(true));
	}

	@RequestMapping("/logout")
	public @ResponseBody AuthenticationResponse logout(Principal principal) {

		Authentication auth = (Authentication) principal;

		auth.setAuthenticated(false);

		return new AuthenticationResponse(false);
	}
}
