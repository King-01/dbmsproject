package com.love2code.springsecurity.demo.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.luv2code.springsecurity.demo.entity.Schedule;
import com.luv2code.springsecurity.demo.validation.IsValidPassword;

public class ScheduleForm {
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String scheduleName;
	private String prev;
	@NotNull(message="is required")
	@IsValidPassword
	private String confirmPassword;
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public ScheduleForm()
	{
		
	}
	public ScheduleForm(Schedule thes)
	{
		this.scheduleName = thes.getScheduleName();
		this.prev = this.scheduleName;
	}
	public String getPrev() {
		return prev;
	}
	public void setPrev(String prev) {
		this.prev = prev;
	}
	public String getScheduleName() {
		return scheduleName;
	}
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	@Override
	public String toString() {
		return "ScheduleForm [scheduleName=" + scheduleName + ", prev=" + prev + ", confirmPassword=" + confirmPassword
				+ "]";
	}
}
