package com.rt.pot.sandeep.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="audit_log_details")
public class AuditLogDetails {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_log_details_id")
    private Long auditLogDetailsId;

    
    @Column(name = "api_name", length = 20)
    private String apiName;

    
    @Column(name = "up_time")
    private LocalDateTime upTime;

    
    @Column(name = "down_time")
    private LocalDateTime downTime;

    
    @Column(name = "total_duration", length = 20)
    private String totalDuration;

    
    @Column(name = "loggedin_userid")
    private Long loggedInUserId;

   
    @Column(name = "loggedin_user_name", length = 20)
    private String loggedInUserName;

    
    @Column(name = "user_email", length = 255)
    private String userEmail;

    
    @Column(name = "description", length = 2550)
    private String description;
    
    
    @Column(name="status" )
    private String status;
    

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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
