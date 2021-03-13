package com.lec.lib.auth;

public enum LectureDay {
	MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);

	private final int value;

	LectureDay(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static LectureDay valueOfType(int value) {
		for (LectureDay v : values()) {
			if (v.value == value) {
				return v;
			}
		}
		return null;
	}
}
