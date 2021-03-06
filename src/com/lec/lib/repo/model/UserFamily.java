package com.lec.lib.repo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_family")
public class UserFamily {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private String id; // 구분 번호

	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user; // 사용자 번호 (학생 번호 or 교수 번호 or 직원 번호)

	@Column(name = "relation")
	private String relation; // 관계

	@Column(name = "name")
	private String name; // 이름

	@Column(name = "phone_number")
	private String phoneNumber; // 전화번호

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
