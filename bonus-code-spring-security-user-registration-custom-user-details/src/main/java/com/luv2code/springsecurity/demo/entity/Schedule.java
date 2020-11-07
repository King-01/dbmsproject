package com.luv2code.springsecurity.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="schedules")
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="name")
	@NotNull(message="is required")
	@Size(min = 1, message="is required")
	private String scheduleName;
	@Column(name="username_id")
	@NotNull(message="is required")
	@Size(min = 1, message="is required")
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getScheduleName() {
		return scheduleName;
	}
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	@Override
	public String toString() {
		return "Schedule [id=" + id + ", scheduleName=" + scheduleName + ", userName=" + userName + "]";
	}
	public Long getId() {
		return id;
	}
}
