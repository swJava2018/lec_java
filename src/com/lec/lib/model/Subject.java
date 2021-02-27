package com.lec.lib.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {
	@Id
	@Column(name = "code")
	private String code; // 과목 코드

	@Column(name = "name")
	private String name; // 과목 이름
}
