package com.rt.pot.sandeep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rt.pot.sandeep.model.AuditLogDetails;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLogDetails, Long>{

}
