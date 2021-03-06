package com.lec.lib.repo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
}