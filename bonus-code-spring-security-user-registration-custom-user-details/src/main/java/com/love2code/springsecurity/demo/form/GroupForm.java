package com.love2code.springsecurity.demo.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.luv2code.springsecurity.demo.entity.Group;
import com.luv2code.springsecurity.demo.validation.IsValidPassword;

public class GroupForm {
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String groupName;
	private Long groupId;
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	@NotNull(message="is required")
	@IsValidPassword
	private String confirmPassword;
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public GroupForm()
	{
		
	}
	public GroupForm(Group thes)
	{
		this.groupId = thes.getId();
		this.groupName = thes.getGroupName();
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Long getGroupId() {
		return groupId;
	}
	@Override
	public String toString() {
		return "GroupForm [groupName=" + groupName + ", groupId=" + groupId + ", confirmPassword=" + confirmPassword
				+ "]";
	}
}
