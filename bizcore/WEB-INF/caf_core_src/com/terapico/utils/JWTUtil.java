package com.terapico.utils;

import java.util.Date;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTUtil {
	
	
	public static final String HEADER_NAME = "Authorization";

	public static DecodedJWT decodeToken(String token) {
		if (TextUtil.isBlank(token)) {
			return null;
		}
		try {
		    Algorithm algorithm = Algorithm.HMAC256(getSecret());
		    JWTVerifier verifier = JWT.require(algorithm)
		        .withIssuer(getIssuer())
		        .acceptLeeway(1)   //1 sec for nbf and iat
		        .acceptExpiresAt(5)
		        .build(); //Reusable verifier instance
		    DecodedJWT jwt = verifier.verify(token);
		    return jwt;
		} catch (JWTVerificationException exception){
			exception.printStackTrace();
			return null;
		}
	}
	
	public static String getJwtToken(String userId) {
		try {
			
		    Algorithm algorithm = Algorithm.HMAC256(getSecret());
		    String token = JWT.create()
		        .withIssuer(getIssuer())
		        .withKeyId(userId)
		        .withIssuedAt(new Date())
		        .withExpiresAt(DateTimeUtil.addMonths(new Date(), 12))
		        .sign(algorithm);
		    return token;
		} catch (JWTCreationException exception){
			exception.printStackTrace();
			return null;
		}
	}

	private static String getSecret() {
		return TextUtil.getExtVariable("JWT_SECRET", "com.skynet.caf");
	}

	private static String getIssuer() {
		return TextUtil.getExtVariable("JWT_ISSUER", "clariones");
	}

	public static String trimJwtToken(String jwtToken) {
		if (jwtToken.trim().startsWith("Bearer")) {
			jwtToken = jwtToken.trim().substring("Bearer".length()).trim();
		}
		return jwtToken.trim();
	}
}
