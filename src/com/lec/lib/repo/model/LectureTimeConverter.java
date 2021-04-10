package com.lec.lib.repo.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LectureTimeConverter implements AttributeConverter<Map<String, List<Integer>>, String> {
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(Map<String, List<Integer>> customerInfo) {

		String customerInfoJson = null;
		try {
			customerInfoJson = objectMapper.writeValueAsString(customerInfo);
		} catch (final JsonProcessingException e) {
			System.out.println("JSON writing error : " + e);
		}

		return customerInfoJson;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, List<Integer>> convertToEntityAttribute(String customerInfoJSON) {

		Map<String, List<Integer>> customerInfo = null;
		try {
			customerInfo = objectMapper.readValue(customerInfoJSON,
					(new HashMap<String, ArrayList<Integer>>()).getClass());
		} catch (final IOException e) {
			System.out.println("JSON reading error : " + e);
		}

		return customerInfo;
	}
}
