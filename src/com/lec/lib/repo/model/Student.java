package com.lec.lib.repo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "student")
public class Student implements Serializable {
	@Id
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id")
	private User user; // 학생 번호

	@OneToMany(mappedBy = "student")
	private Set<LectureHistory> history = new HashSet<LectureHistory>();

	@ManyToOne
	@JoinColumn(name = "div_code", insertable = false, updatable = false)
	private Division div; // 학부 코드

	@ManyToOne
	@JoinColumn(name = "dep_code", insertable = false, updatable = false)
	private Department dep; // 학과 코드

	@Column(name = "status")
	private String status; // 학적 상태

	@Column(name = "disability")
	private Boolean disability; // 장애 여부

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Division getDiv() {
		return div;
	}

	public void setDiv(Division div) {
		this.div = div;
	}

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getDisability() {
		return disability;
	}

	public void setDisability(Boolean disability) {
		this.disability = disability;
	}
}
