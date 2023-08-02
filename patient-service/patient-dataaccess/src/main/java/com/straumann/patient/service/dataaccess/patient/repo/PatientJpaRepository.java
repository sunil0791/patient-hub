package com.straumann.patient.service.dataaccess.patient.repo;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.straumann.patient.service.dataaccess.patient.entity.PatientEntity;

@Repository
public interface PatientJpaRepository extends MongoRepository<PatientEntity, UUID> {

}
