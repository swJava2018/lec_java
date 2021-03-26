package com.lec.lib.auth;

public enum LectureStatus {
	APPLY("apply"), ACCEPT("accept"), REJECT("reject"), COMPLETE("complete");

	private final String value;

	LectureStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static LectureStatus valueOfType(String value) {
		for (LectureStatus v : values()) {
			if (v.value.equals(value)) {
				return v;
			}
		}
		return null;
	}
}
