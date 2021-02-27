package com.lec.lib.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "professor")
public class Professor implements Serializable {
	@Id
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id")
	private User user; // 교수 번호

	@ManyToOne
	@JoinColumn(name = "div_code", insertable = false, updatable = false)
	private Division div; // 학부 코드

	@ManyToOne
	@JoinColumn(name = "dep_code", insertable = false, updatable = false)
	private Department dep; // 학과 코드

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
}
