package com.rt.pot.sandeep.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.pot.sandeep.model.AuditLogDetails;
import com.rt.pot.sandeep.repository.AuditLogRepository;
import com.rt.pot.sandeep.request.AuditLogRequest;
import com.rt.pot.sandeep.request.AuditLogUpdateRequest;
import com.rt.pot.sandeep.response.AuditLogResponseUnCredentials;
import com.rt.pot.sandeep.util.EntityToResponseMapping;
import com.rt.pot.sandeep.util.RequestToEntityMapping;

@Service
public class AuditLogService {
	private static final Logger logger = LoggerFactory.getLogger(AuditLogService.class);

	@Autowired
	private AuditLogRepository auditLogRepository;

	public Object saveAuditLogData(AuditLogRequest auditLogRequest) {
		logger.info("Saving audit log data...");
		if (!isValidAuditLogRequest(auditLogRequest)) {
			logger.error("Invalid audit log request: {}", auditLogRequest);
			return "Invalid audit log request";
		}

		AuditLogDetails auditLogDetails = RequestToEntityMapping.auditLogRequestToEntity(auditLogRequest);
		auditLogRepository.save(auditLogDetails);
		logger.info("Audit log data saved: {}", auditLogDetails);
		return auditLogDetails;
	}

	private boolean isValidAuditLogRequest(AuditLogRequest auditLogRequest) {
		return auditLogRequest != null;
	}

	public Object getAllAuditLogData() {
		logger.info("Fetching all audit log data...");
		
		List<AuditLogDetails> auditLogDetailsList = auditLogRepository.findAll();
		if (!auditLogDetailsList.isEmpty()) {
			List<AuditLogResponseUnCredentials> auditLogUnCredentialDetails = new ArrayList<>();
			auditLogDetailsList.stream().forEach(auditLog -> {
				if (auditLog.getStatus().equals("Active")) {
					AuditLogResponseUnCredentials auditLogResponseUnCredentials = EntityToResponseMapping
							.auditLogDetailsUncredentialToResponse(auditLog);
					auditLogUnCredentialDetails.add(auditLogResponseUnCredentials);
				}
			});
			logger.info("Audit log data fetched successfully");
			return auditLogUnCredentialDetails;
		} else {
			logger.warn("No audit log data found");
			return "No Data Present";
		}
	}

	public Object archiveAuditLogData(Long id) {
		logger.info("Archiving audit log data with id: {}", id);
		
		AuditLogDetails auditLogDetails = auditLogRepository.findById(id).orElse(null);
		
		if (auditLogDetails != null && auditLogDetails.getStatus().equals("Active")) {
			auditLogDetails.setStatus("Deleted");
			auditLogRepository.save(auditLogDetails);
			logger.info("Audit log data archived successfully");
			return "Record Deleted Successfully";
		} else {
			logger.warn("No audit log data found with id: {}", id);
			return "No Data Found With This Id";
		}
		
	}

	public Object getSingleAuditLogData(Long id) {
		logger.info("Fetching audit log data for id: {}", id);
		if (id != null) {
			AuditLogDetails auditLogDetails = this.auditLogRepository.findById(id).orElse(null);
			if (auditLogDetails != null && !auditLogDetails.getStatus().equalsIgnoreCase("Deleted")) {
				logger.info("Audit log data fetched successfully for id: {}", id);
				return auditLogDetails;
			} else {
				logger.warn("Audit log data not found for id: {}", id);
				return "Data Not Found";
			}
		} else {
			logger.error("Given id is null");
			return "Given Id Is Null";
		}
	}

	public Object updateDetails(AuditLogUpdateRequest auditLogUpdateRequest) {
		logger.info("Updating audit log details...");
		if (auditLogUpdateRequest != null) {
			AuditLogDetails auditLogDetails = auditLogRepository.findById(auditLogUpdateRequest.getAuditLogDetailsId())
					.orElse(null);
			if (auditLogDetails != null) {
				AuditLogDetails updatedDetails = RequestToEntityMapping.auditLogRequestToEntity(auditLogDetails,  auditLogUpdateRequest);
				auditLogRepository.save(updatedDetails);
				logger.info("Audit log details updated successfully");
				return "Details Updated Successfully";
			} else {
				logger.warn("Audit log details not found for update");
				return "Details Not Found";
			}
		} else {
			logger.error("Insufficient data for update");
			return "Insufficient Data";
		}
	}
}
