package com.rt.pot.sandeep.util;

import java.time.Duration;
import java.time.LocalDateTime;

import com.rt.pot.sandeep.model.AuditLogDetails;
import com.rt.pot.sandeep.request.AuditLogRequest;
import com.rt.pot.sandeep.request.AuditLogUpdateRequest;

public class RequestToEntityMapping {
	
	

public static AuditLogDetails auditLogRequestToEntity(AuditLogRequest auditLogRequest) {
    AuditLogDetails auditLogDetails = new AuditLogDetails();
    
   
    auditLogDetails.setApiName(auditLogRequest.getApiName());
    auditLogDetails.setUpTime(auditLogRequest.getUpTime());
    auditLogDetails.setDownTime(auditLogRequest.getDownTime());
   
    auditLogDetails.setTotalDuration(getTime(auditLogRequest.getUpTime(), auditLogRequest.getDownTime()));
    auditLogDetails.setLoggedInUserId(auditLogRequest.getLoggedInUserId());
    auditLogDetails.setLoggedInUserName(auditLogRequest.getLoggedInUserName());
    auditLogDetails.setUserEmail(auditLogRequest.getUserEmail());
    auditLogDetails.setDescription(auditLogRequest.getDescription());
    auditLogDetails.setStatus("Active");
    return auditLogDetails;
}

public static AuditLogDetails auditLogRequestToEntity(AuditLogDetails auditLogDetails ,AuditLogUpdateRequest auditLogUpdateRequest) {
   
	 auditLogDetails.setApiName(auditLogUpdateRequest.getApiName());
	    auditLogDetails.setUpTime(auditLogUpdateRequest.getUpTime());
	    auditLogDetails.setDownTime(auditLogUpdateRequest.getDownTime());
	    auditLogDetails.setTotalDuration(getTime(auditLogUpdateRequest.getUpTime(), auditLogUpdateRequest.getDownTime()));
	    auditLogDetails.setLoggedInUserId(auditLogUpdateRequest.getLoggedInUserId());
	    auditLogDetails.setLoggedInUserName(auditLogUpdateRequest.getLoggedInUserName());
	    auditLogDetails.setUserEmail(auditLogUpdateRequest.getUserEmail());
	    auditLogDetails.setDescription(auditLogUpdateRequest.getDescription());
	return auditLogDetails;
}


public static String getTime(LocalDateTime upTime, LocalDateTime downTime) {
	 Duration duration =Duration.between(upTime,downTime);
	    long seconds = duration.getSeconds();

	    long hours = seconds / 3600;
	    long minutes = (seconds % 3600) / 60;
	    long remainingSeconds = seconds % 60;
	    String durationTieme = String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);
	return durationTieme;
}
}
