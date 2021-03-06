package com.lec.lib.repo.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LectureHistoryId implements Serializable {
	private String lecture; // 강의코드
	private String student; // 학생번호

	public LectureHistoryId() {
	}

	public LectureHistoryId(String lecture, String student) {
		this.lecture = lecture;
		this.student = student;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof LectureHistoryId)) {
			return false;
		}
		LectureHistoryId other = (LectureHistoryId) o;
		return this.lecture.equals(other.lecture) && this.student.equals(other.student);
	}

	@Override
	public int hashCode() {
		return this.lecture.hashCode() ^ this.student.hashCode();
	}
}
