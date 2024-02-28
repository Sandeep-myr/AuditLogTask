package com.rt.pot.sandeep.request;

import java.time.LocalDateTime;

public class AuditLogUpdateRequest {
	private Long auditLogDetailsId;
	private String apiName;
	private LocalDateTime upTime;
	private LocalDateTime downTime;
	
	private Long loggedInUserId;
	private String loggedInUserName;
	private String userEmail;
	private String description;
	public Long getAuditLogDetailsId() {
		return auditLogDetailsId;
	}
	public void setAuditLogDetailsId(Long auditLogDetailsId) {
		this.auditLogDetailsId = auditLogDetailsId;
	}
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public LocalDateTime getUpTime() {
		return upTime;
	}
	public void setUpTime(LocalDateTime upTime) {
		this.upTime = upTime;
	}
	public LocalDateTime getDownTime() {
		return downTime;
	}
	public void setDownTime(LocalDateTime downTime) {
		this.downTime = downTime;
	}
	
	public Long getLoggedInUserId() {
		return loggedInUserId;
	}
	public void setLoggedInUserId(Long loggedInUserId) {
		this.loggedInUserId = loggedInUserId;
	}
	public String getLoggedInUserName() {
		return loggedInUserName;
	}
	public void setLoggedInUserName(String loggedInUserName) {
		this.loggedInUserName = loggedInUserName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
