package com.terapico.caf;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.terapico.utils.TextUtil;

public class Images extends ArrayList<Image> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 206182274332463629L;

	public static Images fromString(String dataInDb) {
		if (TextUtil.isBlank(dataInDb)) {
			return null;
		}
	    try {
			return objectMapper().readValue(dataInDb, Images.class);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
	        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		return mapper;
	}

	@Override
	public String toString() {
		try {
			return objectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return super.toString();
		}
	}

	

}
