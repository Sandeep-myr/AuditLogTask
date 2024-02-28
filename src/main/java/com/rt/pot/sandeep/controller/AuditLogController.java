package com.rt.pot.sandeep.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rt.pot.sandeep.common.ConstantsUrl;
import com.rt.pot.sandeep.error.GlobalException;
import com.rt.pot.sandeep.model.AuditLogDetails;
import com.rt.pot.sandeep.request.AuditLogRequest;
import com.rt.pot.sandeep.request.AuditLogUpdateRequest;
import com.rt.pot.sandeep.service.AuditLogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(ConstantsUrl.AuditLogUrl.API_BASE)
@Tag(name = "Audit Module", description = "Audit Log does 1.Gets All Audit Log Data, 2. Updates Audit Log Data, 3.Save Audit Log  Data etc..")
public class AuditLogController {

	@Autowired
	private AuditLogService auditLogService;

	private static final Logger LOGGER = LoggerFactory.getLogger(AuditLogController.class);

	@Operation(summary = "Saving Audit Log  Data ", description = "This service is used for saving Audit Log Data.")
	@ApiResponses({ @ApiResponse(responseCode = "422", description = "Audit Details Are Not Saved ..."),
			@ApiResponse(responseCode = "200", description = "Audit Log Details Are Saved Successfully") })

	@PostMapping(ConstantsUrl.AuditLogUrl.SAVE_AUDIT_LOG_DATA)
	public ResponseEntity<?> saveAuditResponseDetails(@Valid @RequestBody AuditLogRequest auditLogRequest)
			throws GlobalException {
		try {
			LOGGER.info("saveAuditResponseDetails()");
			AuditLogDetails response = (AuditLogDetails) this.auditLogService.saveAuditLogData(auditLogRequest);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error occurred while saving audit log data: " + e.getMessage());
			return new ResponseEntity<>("Error occurred while saving audit log data", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//============================================================================================

	// Updating Audit Log Data
	@Operation(summary = "Updating Audit Log Data", description = "This service is used for updating Audit Log Data.")
	@ApiResponses({ @ApiResponse(responseCode = "422", description = "Audit Details Are Not Updated ..."),
			@ApiResponse(responseCode = "200", description = "Audit Log Details Are Updated Successfully") })
	@PutMapping(ConstantsUrl.AuditLogUrl.UPDATE_AUDIT_lOG_DATA)
	public ResponseEntity<?> updateAuditResponseDetails(@Valid @RequestBody AuditLogUpdateRequest auditLogUpdateRequest)
			throws GlobalException {
		try {
			LOGGER.info("updateAuditResponseDetails()");

			return new ResponseEntity<>(this.auditLogService.updateDetails(auditLogUpdateRequest), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error occurred while updating audit log data: " + e.getMessage());
			return new ResponseEntity<>("Error occurred while updating audit log data",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//============================================================================================

	// Getting All Audit Log Data
	@Operation(summary = "Getting All Audit Log Data", description = "This service is used for retrieving all Audit Log Data.")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Audit Log Details Retrieved Successfully") })
	@GetMapping(ConstantsUrl.AuditLogUrl.AUDIT_LOG_GET_ALL)
	public ResponseEntity<?> getAllAuditLogData() {
		try {
			LOGGER.info("getAllAuditLogData()");

			return new ResponseEntity<>(this.auditLogService.getAllAuditLogData(), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error occurred while retrieving all audit log data: " + e.getMessage());
			return new ResponseEntity<>("Error occurred while retrieving all audit log data",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//============================================================================================

	// Archiving Audit Log Data by ID
	@Operation(summary = "Archiving Audit Log Data by ID", description = "This service is used for archiving Audit Log Data by ID.")
	@ApiResponses({ @ApiResponse(responseCode = "422", description = "Audit Log Data Archiving Failed ..."),
			@ApiResponse(responseCode = "200", description = "Audit Log Data Archived Successfully") })

	@PutMapping(ConstantsUrl.AuditLogUrl.ARCHIVE_AUDIT_LOG_DATA)
	public ResponseEntity<?> archiveAuditLogData(@PathVariable("id") Long id) throws GlobalException {
		try {
			LOGGER.info("archiveAuditLogData()");

			return new ResponseEntity<>(this.auditLogService.archiveAuditLogData(id), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error occurred while archiving audit log data: " + e.getMessage());
			return new ResponseEntity<>("Error occurred while archiving audit log data",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//============================================================================================

	// Getting Single Audit Log Data by ID
	@Operation(summary = "Getting Single Audit Log Data by ID", description = "This service is used for retrieving a single Audit Log Data by ID.")
	@ApiResponses({ @ApiResponse(responseCode = "422", description = "Audit Log Data Retrieval Failed ..."),
			@ApiResponse(responseCode = "200", description = "Audit Log Data Retrieved Successfully") })
	@GetMapping(ConstantsUrl.AuditLogUrl.GET_SINGLE_AUDIT_LOG_DATA)
	public ResponseEntity<?> getSingleAuditLogData(@PathVariable("id") Long id) {
		try {
			LOGGER.info("getSingleAuditLogData()");

			return new ResponseEntity<>(this.auditLogService.getSingleAuditLogData(id), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error occurred while retrieving single audit log data: " + e.getMessage());
			return new ResponseEntity<>("Error occurred while retrieving single audit log data",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}