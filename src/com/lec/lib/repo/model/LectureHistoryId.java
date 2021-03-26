package com.lec.lib.repo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@SuppressWarnings("serial")
public class LectureHistoryId implements Serializable {

	@Column(name = "lecture_code")
	private String lecture; // 강의코드

	@Column(name = "student_id")
	private String student; // 학생번호

	public LectureHistoryId() {
	}

	public LectureHistoryId(String lecture, String student) {
		this.lecture = lecture;
		this.student = student;
	}

	public String getLecture() {
		return lecture;
	}

	public String getStudent() {
		return student;
	}

	public void setLecture(String lecture) {
		this.lecture = lecture;
	}

	public void setStudent(String student) {
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
