package com.love2code.springsecurity.demo.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DateScheduleForm {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	private Long scheduleId;
	public Long getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}
	@Override
	public String toString() {
		return "DateScheduleForm [startDate=" + startDate + ", endDate=" + endDate + ", scheduleId=" + scheduleId + "]";
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
