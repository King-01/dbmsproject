package com.luv2code.springsecurity.demo.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ScheduleUser {
	@NotNull(message="is required")
	@Size(min=1, message = "is required")
	private String ScheduleName;

	public String getScheduleName() {
		return ScheduleName;
	}

	public void setScheduleName(String scheduleName) {
		ScheduleName = scheduleName;
	}

	@Override
	public String toString() {
		return "ScheduleUser [ScheduleName=" + ScheduleName + "]";
	}
	
}
