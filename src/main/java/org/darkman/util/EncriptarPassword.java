package org.darkman.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
	public static void main(String[] args) {
		var passwd = "jaedwein";
		System.out.println(encrypPassword(passwd));

	}
	
	public static String encrypPassword(String pass) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(pass);
	}
}
