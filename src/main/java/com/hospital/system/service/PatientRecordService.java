package com.hospital.system.service;

import com.hospital.system.model.PatientRecord;
import com.hospital.system.repository.PatientRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientRecordService {

    private final PatientRecordRepository patientRecordRepository;

    public PatientRecord saveRecord(PatientRecord record) {
        return patientRecordRepository.save(record);
    }

    public List<PatientRecord> getAllRecords() {
        return patientRecordRepository.findAll();
    }

    public PatientRecord getRecordByPatientId(String patientId) {
        return patientRecordRepository.findByPatientId(patientId);
    }
}
