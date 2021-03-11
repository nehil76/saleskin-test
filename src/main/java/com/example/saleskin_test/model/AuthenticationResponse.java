package com.example.saleskin_test.model;

public class AuthenticationResponse {

	private boolean autenticated = false;

	public AuthenticationResponse(boolean isAuth) {
		this.autenticated = isAuth;
	}

	public boolean isAutenticated() {
		return autenticated;
	}

	public void setAutenticated(boolean autenticated) {
		this.autenticated = autenticated;
	}

}
