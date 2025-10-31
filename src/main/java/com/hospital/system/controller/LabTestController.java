package com.hospital.system.controller;

import com.hospital.system.model.LabTest;
import com.hospital.system.service.LabTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import lombok.Data;


@RestController
@RequestMapping("/api/lab-tests")
@RequiredArgsConstructor
public class LabTestController {

    private final LabTestService labTestService;

    @PostMapping("/schedule")
    public LabTest scheduleLabTest(@RequestBody LabTestRequest request) {
        return labTestService.scheduleLabTest(request.getTestType(), request.getPatientId());
    }

    @Data
    public static class LabTestRequest {
        private String testType;
        private String patientId;
    }
}
