package com.lec.lib.repo.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lec.lib.auth.LectureDay;

@Entity
@Table(name = "lecture")
public class Lecture {
	@Id
	@Column(name = "code")
	private String code; // 강의 코드

	@ManyToOne
	@JoinColumn(name = "professor_id", insertable = false, updatable = false)
	private Professor professor; // 교수 번호

	@ManyToOne
	@JoinColumn(name = "subject_code", insertable = false, updatable = false)
	private Subject subject; // 과목 코드

	@Column(name = "name")
	private String name; // 강의 제목

	@Column(name = "description")
	private String description; // 강의 내용

	@Convert(converter = LectureTimeConverter.class)
	@Column(name = "time")
	private Map<String, List<Integer>> time = new HashMap<String, List<Integer>>(); // 강의 요일, 강의 시간

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<String, List<Integer>> getTime() {
		return time;
	}

	public void setTime(Map<String, List<Integer>> time) {
		this.time = time;
	}
}