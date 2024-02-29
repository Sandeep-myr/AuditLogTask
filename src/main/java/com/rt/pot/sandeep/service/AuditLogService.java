package com.rt.pot.sandeep.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.pot.sandeep.common.Constants;
import com.rt.pot.sandeep.model.AuditLogDetails;
import com.rt.pot.sandeep.repository.AuditLogRepository;
import com.rt.pot.sandeep.request.AuditLogRequest;
import com.rt.pot.sandeep.request.AuditLogUpdateRequest;
import com.rt.pot.sandeep.response.AuditLogResponseUnCredentials;
import com.rt.pot.sandeep.response.Response;
import com.rt.pot.sandeep.util.EntityToResponseMapping;
import com.rt.pot.sandeep.util.RequestToEntityMapping;

@Service
public class AuditLogService {
	private static final Logger logger = LoggerFactory.getLogger(AuditLogService.class);

	@Autowired
	private AuditLogRepository auditLogRepository;

	public Response saveAuditLogData(AuditLogRequest auditLogRequest) {
		logger.info("Saving audit log data...");
		Response response = null;
		if (!isValidAuditLogRequest(auditLogRequest)) {
			logger.error("Invalid audit log request: {}", auditLogRequest);
			response = new Response(Constants.INVALID_INPUT, "Invalid audit log request", null);
		} else {
			AuditLogDetails auditLogDetails = RequestToEntityMapping.auditLogRequestToEntity(auditLogRequest);
			auditLogRepository.save(auditLogDetails);
			response = new Response(Constants.OK, "Audit log saved successfully", auditLogDetails);
		}
		logger.info("Audit log data saved():");
		return response;
	}

	private boolean isValidAuditLogRequest(AuditLogRequest auditLogRequest) {
		return auditLogRequest != null;
	}

	public Response getAllAuditLogData() {
		logger.info("Fetching all audit log data...");
		Response response = null;
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
			response = new Response(Constants.OK, "Audit log details", auditLogUnCredentialDetails);
		} else {
			logger.warn("No audit log data found");
			response = new Response(Constants.NO_CONTENT, "Unable to get the Audit Log Details", null);
		}
		return response;
	}

	public Response archiveAuditLogData(Long id) {
		logger.info("Archiving audit log data with id: {}", id);
		Response response = null;
		AuditLogDetails auditLogDetails = auditLogRepository.findById(id).orElse(null);

		if (auditLogDetails != null && auditLogDetails.getStatus().equals("Active")) {
			auditLogDetails.setStatus("Deleted");
			auditLogRepository.save(auditLogDetails);
			logger.info("Audit log data archived successfully");
			response = new Response(Constants.OK, "Audit log details deleted", "one record deleted");
		} else {
			logger.warn("No audit log data found with id: {}", id);
			response = new Response(Constants.NO_CONTENT, "Unable to get the Audit Log Details", null);
		}
		return response;
	}

	public Response getSingleAuditLogData(Long id) {
		logger.info("Fetching audit log data for id: {}", id);
		Response response = null;
		if (id != null) {
			AuditLogDetails auditLogDetails = this.auditLogRepository.findById(id).orElse(null);
			if (auditLogDetails != null && !auditLogDetails.getStatus().equalsIgnoreCase("Deleted")) {
				logger.info("Audit log data fetched successfully for id: {}", id);
				response = new Response(Constants.OK, "Audit log details deleted", auditLogDetails);
			} else {
				logger.warn("Audit log data not found for id: {}", id);
				response = new Response(Constants.NO_CONTENT, "Unable to get the Audit Log Details", null);
			}
		} else {
			logger.error("Given id is null");
			response = new Response(Constants.INVALID_INPUT, "INVALID INPUT", null);
		}
		return response;
	}

	public Response updateDetails(AuditLogUpdateRequest auditLogUpdateRequest) {
		logger.info("Updating audit log details...");
		Response response = null;
		if (auditLogUpdateRequest != null) {
			AuditLogDetails auditLogDetails = auditLogRepository.findById(auditLogUpdateRequest.getAuditLogDetailsId())
					.orElse(null);
			if (auditLogDetails != null) {
				AuditLogDetails updatedDetails = RequestToEntityMapping.auditLogRequestToEntity(auditLogDetails,
						auditLogUpdateRequest);
				auditLogRepository.save(updatedDetails);
				logger.info("Audit log details updated successfully");
				response = new Response(Constants.OK, "Audit log details deleted", "Details Updated Successfully");
			} else {
				logger.warn("Audit log details not found for update");
				response = new Response(Constants.NO_CONTENT, "Unable to get the Audit Log Details", null);
			}
		} else {
			logger.error("Insufficient data for update");
			response = new Response(Constants.INVALID_INPUT, "INVALID INPUT", null);
		}
		return response;
	}
}
