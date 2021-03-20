package com.lec.cli.input;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserInfoInput {
	@JsonProperty("div_code")
	private String divCode;
	
	@JsonProperty("dep_code")
	private String depCode;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("disabilty")
	private Boolean disability;

	public String getDivCode() {
		return divCode;
	}

	public String getDepCode() {
		return depCode;
	}

	public String getStatus() {
		return status;
	}

	public Boolean getDisability() {
		return disability;
	}

	public void parse(String info) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			UserInfoInput obj = mapper.readValue(info.getBytes(), UserInfoInput.class);
			divCode = obj.getDivCode();
			depCode = obj.getDepCode();
			status = obj.getStatus();
			disability = obj.getDisability();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
