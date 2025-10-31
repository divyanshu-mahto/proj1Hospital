package com.hospital.system.controller;

import com.hospital.system.model.LabTest;
import com.hospital.system.service.LabTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lab-tests")
@RequiredArgsConstructor
public class LabTestController {

    private final LabTestService labTestService;

    @PostMapping("/schedule")
    public LabTest scheduleLabTest(@RequestBody LabTest labTest) {
        return labTestService.scheduleLabTest(labTest);
    }
}
