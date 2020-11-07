package com.luv2code.springsecurity.demo.user;

import javax.validation.constraints.NotNull;

import com.luv2code.springsecurity.demo.validation.FieldMatch;
import com.luv2code.springsecurity.demo.validation.IsValidPassword;
@FieldMatch.List({
    @FieldMatch(first = "changePassword", second = "changeConfirmPassword", message = "The new password fields must match")
})
public class PasswordUser {
	@NotNull(message="is required")
	private String userName;

	@NotNull(message="is required")
	@IsValidPassword
	private String confirmPassword;
	@IsValidPassword
	@NotNull(message="is required")
	private String changePassword;
	@IsValidPassword
	@NotNull(message="is required")
	private String changeConfirmPassword;
	@Override
	public String toString() {
		return "PasswordUser [userName=" + userName + ", confirmPassword=" + confirmPassword + ", changePassword="
				+ changePassword + ", changeConfirmPassword=" + changeConfirmPassword + "]";
	}
	public String getUserName() {
		return userName;
	}
	public PasswordUser() {
		super();
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getChangePassword() {
		return changePassword;
	}
	public void setChangePassword(String changePassword) {
		this.changePassword = changePassword;
	}
	public String getChangeConfirmPassword() {
		return changeConfirmPassword;
	}
	public void setChangeConfirmPassword(String changeConfirmPassword) {
		this.changeConfirmPassword = changeConfirmPassword;
	}
}
