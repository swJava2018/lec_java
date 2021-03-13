package com.lec.lib.repo.model;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lec.lib.auth.LectureDay;

public class LectureTimeConverter implements AttributeConverter<Map<LectureDay, List<Integer>>, String> {
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(Map<LectureDay, List<Integer>> customerInfo) {

		String customerInfoJson = null;
		try {
			customerInfoJson = objectMapper.writeValueAsString(customerInfo);
		} catch (final JsonProcessingException e) {
//			logger.error("JSON writing error", e);
		}

		return customerInfoJson;
	}

	@Override
	public Map<LectureDay, List<Integer>> convertToEntityAttribute(String customerInfoJSON) {

		Map<LectureDay, List<Integer>> customerInfo = null;
		try {
			customerInfo = objectMapper.readValue(customerInfoJSON, Map.class);
		} catch (final IOException e) {
//			logger.error("JSON reading error", e);
		}

		return customerInfo;
	}
}
