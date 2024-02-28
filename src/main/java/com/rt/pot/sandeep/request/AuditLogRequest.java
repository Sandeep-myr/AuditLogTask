package com.rt.pot.sandeep.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AuditLogRequest {

	@NotBlank(message = "API name cannot be empty")
	@Size(max = 20, message = "API name must be at most 20 characters long")
	private String apiName;

	@NotNull(message = "Up time cannot be empty")
	private LocalDateTime upTime;

	@NotNull(message = "Down time cannot be empty")
	private LocalDateTime downTime;

	

	@NotNull(message = "Logged-in user ID cannot be null")
	@Min(value = 1, message = "Logged-in user ID must be at least 1")
	private Long loggedInUserId;

	@NotBlank(message = "Logged-in user name cannot be empty")
	@Size(max = 20, message = "Logged-in user name must be at most 20 characters long")
	private String loggedInUserName;

	@NotBlank(message = "User email cannot be empty")
	@Email(message = "Invalid email format")
	@Size(max = 255, message = "User email must be at most 255 characters long")
	private String userEmail;

	@NotBlank(message = "Description cannot be empty")
	@Size(max = 2550, message = "Description must be at most 2550 characters long")
	private String description;

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
