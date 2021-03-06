package com.lec.lib.repo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lec.lib.api.config.Permission;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "id")
	private String id; // 사용자 번호 (학생 번호 or 교수 번호 or 직원 번호)

	@Column(name = "name")
	private String name; // 이름

	@Column(name = "address")
	private String address; // 주소

	@Column(name = "phone_number")
	private String phoneNumber; // 전화번호

	@Column(name = "country")
	private String country; // 국적

	@Column(name = "regdent_number")
	private String regdentNumber; // 주민번호

	@Column(name = "email")
	private String email; // 이메일

	@Column(name = "birth_date")
	private String birthDate; // 생년월일

	@Column(name = "password")
	private String password; // 비밀번호

	@Column(name = "role")
	private Permission role; // 역할

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

	public Permission getRole() {
		return role;
	}

	public void setRole(Permission role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "id:" + id + ", name:" + name + ", role:" + role;
	}
}
