package com.lec.lib.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "lecture_history")
public class LectureHistory implements Serializable {
	@Id
	@OneToOne
	@JoinColumn(name = "code", referencedColumnName = "code")
	private Lecture lecture; // 강의 코드

	@ManyToOne
	@JoinColumn(name = "student_id", insertable = false, updatable = false)
	private Student student; // 학생 번호

	@Column(name = "grade")
	@JoinColumn(name = "grade", insertable = false, updatable = false)
	private String grade; // 강의 성적

	@Column(name = "problem")
	@JoinColumn(name = "problem", insertable = false, updatable = false)
	private String problem; // 강의 이의 제기

	@Column(name = "opinion")
	@JoinColumn(name = "opinion", insertable = false, updatable = false)
	private String opinion; // 강의 평가

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
}
