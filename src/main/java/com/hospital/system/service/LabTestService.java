package com.hospital.system.service;

import com.hospital.system.model.LabTest;
import com.hospital.system.repository.LabTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LabTestService {

    private final LabTestRepository labTestRepository;

    public LabTest scheduleLabTest(String testType, String patientId) {
        LabTest labTest = new LabTest();
        labTest.setTestType(testType);
        labTest.setPatientId(patientId);
        labTest.setTestDate(LocalDateTime.now().plusDays(1));

        return labTestRepository.save(labTest);
    }
}
