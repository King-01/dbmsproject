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
@Table(name="group_s")
public class Group {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="groupname")
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String groupName;
	
	@Column(name="schedulename")
	@NotNull(message = "is required")
	private Long schedule;
	
	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	

	

	public Long getSchedule() {
		return schedule;
	}

	public void setSchedule(Long schedule) {
		this.schedule = schedule;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", groupName=" + groupName + ", schedule=" + schedule + "]";
	}
	
	
}
