package com.lec.lib.repo.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lecture")
public class Lecture {
	@Id
	@Column(name = "code")
	private String code; // 강의 코드

	@OneToMany(mappedBy="lecture")
	private Set<LectureHistory> history = new HashSet<LectureHistory>();
	
	@ManyToOne
	@JoinColumn(name = "professor_id", insertable = false, updatable = false)
	private Professor professor; // 교수 번호

	@ManyToOne
	@JoinColumn(name = "subject_code", insertable = false, updatable = false)
	private Subject subject; // 과목 코드

	@Column(name = "description")
	private String description; // 강의 내용

	@Convert(converter = LectureTimeConverter.class)
	@Column(name = "time")
	private Map<String, List<Integer>> time = new HashMap<String, List<Integer>>(); // 강의 요일, 강의 시간

	@Column(name = "year")
	private int year; // 강의 년도
	
	@Column(name = "semester")
	private int semester; // 강의 학기
	
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}
}