package com.lec.my.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	@Id
	@Column
	private String id; // 학번 or 교수코드 or 직원코드

	@Column
	private String name; // 이름

	@Column
	private String address; // 주소

	@Column
	private String phoneNumber; // 전화번호

	@Column
	private String country; // 국적

	@Column
	private String regdentNumber; // 주민번호

	@Column
	private String email; // 이메일

	@Column
	private String birthDate; // 생년월일

	@Column
	private String password; // 비밀번호

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegdentNumber() {
		return regdentNumber;
	}

	public void setRegdentNumber(String regdentNumber) {
		this.regdentNumber = regdentNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "id:" + id + ",name:" + name;
	}
}
