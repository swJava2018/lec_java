package com.lec.lib.auth;

public enum Permission {
	ADMIN("admin"), EMPLOYEE("employee"), PROFESSOR("professor"), STUDENT("student");

	private final String value;

	Permission(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static Permission valueOfType(String value) {
	    for (Permission p : values()) {
	        if (p.value.equals(value)) {
	            return p;
	        }
	    }
	    return null;
	}
}
