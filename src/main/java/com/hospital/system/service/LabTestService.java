package com.hospital.system.service;

import com.hospital.system.model.LabTest;
import com.hospital.system.repository.LabTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LabTestService {

    private final LabTestRepository labTestRepository;
    private final EmailService emailService;

    public LabTest scheduleLabTest(LabTest labTest) {
        LabTest saved = labTestRepository.save(labTest);
        emailService.sendEmail(
                saved.getEmail(),
                "Lab Test Confirmation",
                "Dear " + saved.getPatientName() + ", your " + saved.getTestType()
                        + " test is scheduled for " + saved.getTestDate() + "."
        );
        return saved;
    }
}
