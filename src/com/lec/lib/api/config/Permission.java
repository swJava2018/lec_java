package com.lec.lib.api.config;

public enum Permission {
	Admin("admin"), Employee("employee"), Professor("professor"), Student("student");

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
