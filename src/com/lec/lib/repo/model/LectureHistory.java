package com.lec.lib.repo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.lec.lib.auth.LectureStatus;

@SuppressWarnings("serial")
@Entity
//@IdClass(LectureHistoryId.class)
@Table(name = "lecture_history")
public class LectureHistory implements Serializable {
	@EmbeddedId
	private LectureHistoryId id;

	@ManyToOne
	@MapsId("lecture")
	@JoinColumn(name = "lecture_code", referencedColumnName = "code")
	private Lecture lecture; // 강의 코드

	@ManyToOne
	@MapsId("student")
	@JoinColumn(name = "student_id", referencedColumnName = "id")
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

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private LectureStatus status; // 상태

	public LectureHistoryId getId() {
		return id;
	}

	public void setId(LectureHistoryId id) {
		this.id = id;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public Student getStudent() {
		return student;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
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

	public LectureStatus getStatus() {
		return status;
	}

	public void setStatus(LectureStatus status) {
		this.status = status;
	}
}
