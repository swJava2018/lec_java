package com.lec.lib.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LectureId implements Serializable {
	private String professor; // 교수번호
	private String subject; // 과목코드

	public LectureId() {
	}

	public LectureId(String professor, String subject) {
		this.professor = professor;
		this.subject = subject;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof LectureId)) {
			return false;
		}
		LectureId other = (LectureId) o;
		return this.professor.equals(other.professor) && this.subject.equals(other.subject);
	}

	@Override
	public int hashCode() {
		return this.professor.hashCode() ^ this.subject.hashCode();
	}
}
