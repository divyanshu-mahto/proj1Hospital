package com.hospital.system.repository;

import com.hospital.system.model.PatientRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRecordRepository extends MongoRepository<PatientRecord, String> {
    PatientRecord findByPatientId(String patientId);
}
