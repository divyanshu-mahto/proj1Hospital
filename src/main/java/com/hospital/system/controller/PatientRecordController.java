package com.hospital.system.controller;

import com.hospital.system.model.PatientRecord;
import com.hospital.system.service.PatientRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient-records")
@RequiredArgsConstructor
public class PatientRecordController {

    private final PatientRecordService patientRecordService;

    @PostMapping
    public PatientRecord saveRecord(@RequestBody PatientRecord record) {
        return patientRecordService.saveRecord(record);
    }

    @GetMapping
    public List<PatientRecord> getAllRecords() {
        return patientRecordService.getAllRecords();
    }

    @GetMapping("/{patientId}")
    public PatientRecord getRecordByPatientId(@PathVariable String patientId) {
        return patientRecordService.getRecordByPatientId(patientId);
    }
}
