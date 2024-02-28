package com.rt.pot.sandeep.util;

import com.rt.pot.sandeep.model.AuditLogDetails;
import com.rt.pot.sandeep.response.AuditLogResponse;
import com.rt.pot.sandeep.response.AuditLogResponseUnCredentials;

public class EntityToResponseMapping {

	public static AuditLogResponse auditLogDetailsToResponse(AuditLogDetails auditLogDetails) {
		AuditLogResponse auditLogResponse = new AuditLogResponse();

		auditLogResponse.setAuditLogDetailsId(auditLogDetails.getAuditLogDetailsId());
		auditLogResponse.setApiName(auditLogDetails.getApiName());
		auditLogResponse.setUpTime(auditLogDetails.getUpTime());
		auditLogResponse.setDownTime(auditLogDetails.getDownTime());
		auditLogResponse.setTotalDuration(auditLogDetails.getTotalDuration());
		auditLogResponse.setLoggedInUserId(auditLogDetails.getLoggedInUserId());
		auditLogResponse.setLoggedInUserName(auditLogDetails.getLoggedInUserName());
		auditLogResponse.setUserEmail(auditLogDetails.getUserEmail());
		auditLogResponse.setDescription(auditLogDetails.getDescription());

		return auditLogResponse;
	}

	
	public static AuditLogResponseUnCredentials auditLogDetailsUncredentialToResponse(AuditLogDetails auditLogDetails) {
		AuditLogResponseUnCredentials auditLogResponse = new AuditLogResponseUnCredentials();

		auditLogResponse.setAuditLogDetailsId(auditLogDetails.getAuditLogDetailsId());
		auditLogResponse.setApiName(auditLogDetails.getApiName());
		auditLogResponse.setUpTime(auditLogDetails.getUpTime());
		auditLogResponse.setDownTime(auditLogDetails.getDownTime());
		auditLogResponse.setTotalDuration(auditLogDetails.getTotalDuration());

		auditLogResponse.setDescription(auditLogDetails.getDescription());

		return auditLogResponse;
	}

}
