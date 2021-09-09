package com.terapico.utils;

import java.util.Date;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * <pre><xmp>
 *     <property name="securityStatus">
 *        <option value="ANONYMOUS" code="0"/>
 *        <option value="URL-PARAM" code="1"/>
 *        <option value="AUTO-SIGNIN" code="2"/>
 *        <option value="HTTP-BASIC-AUTH" code="3"/>
 *        <option value="EXPLICIT-SIGNIN" code="4"/>
 *        <option value="SECURE-SIGNIN" code="5"/>
 *        <option value="CERTIFICATE" code="6"/>
 *      </property>
 * </xmp></pre>
 */
public class JWTUtil {
	
	
	public static final String HEADER_NAME = "authorization";

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
		} catch (JWTVerificationException e){
			// exception.printStackTrace();
			System.out.println("[    Exception]: " + e.getMessage());
			return null;
		}
	}
	
	@Deprecated
	/**
	 * replaced with getJwtToken(String userId, String userUploadHome, String envType, Date now);
	 * @param userId
	 * @param userUploadHome
	 * @param envType
	 * @return
	 */
	public static String getJwtToken(String userId, String userUploadHome, String envType) {
		return getJwtToken(userId, userUploadHome, envType, userId);
	}
	public static String getJwtToken(String userId, String userUploadHome, String envType, String tokenKey) {
		return getJwtToken(userId, userUploadHome, envType, tokenKey, new Date());
	}
	public static String getJwtToken(String userId, String userUploadHome, String envType, String tokenKey, Date date) {
		return getJwtToken(userId, userUploadHome, envType, tokenKey, date, new String[] {userId});
	}
	public static String getJwtToken(String userId, String userUploadHome, String envType, String tokenKey, Date date, String[] tags) {
		try {
			
		    Algorithm algorithm = Algorithm.HMAC256(getSecret());
		    String securityStatus = "CERTIFICATE";
		    if (userId == null || "anonymous".equals(userId)){
				securityStatus = "ANONYMOUS";
				userId = "anonymous_"+tokenKey;
			}
		    String token = JWT.create()
		        .withIssuer(getIssuer())
		        .withKeyId(userId)
		        .withIssuedAt(date)
		        .withExpiresAt(DateTimeUtil.addDays(date, 7, false))
		        .withClaim("userUploadHome", userUploadHome)
		        .withClaim("envType", envType)
		        .withClaim("tokenKey", tokenKey)
				.withClaim("userId", userId)
				.withClaim("securityStatus", securityStatus)
		        .withArrayClaim("tags", tags)
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
