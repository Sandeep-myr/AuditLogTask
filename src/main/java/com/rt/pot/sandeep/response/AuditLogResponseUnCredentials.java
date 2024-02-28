package com.rt.pot.sandeep.response;

import java.time.LocalDateTime;

public class AuditLogResponseUnCredentials {
	private Long auditLogDetailsId;
	private String apiName;
	private LocalDateTime upTime;
	private LocalDateTime downTime;
	private String totalDuration;

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

	public String getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(String totalDuration) {
		this.totalDuration = totalDuration;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
