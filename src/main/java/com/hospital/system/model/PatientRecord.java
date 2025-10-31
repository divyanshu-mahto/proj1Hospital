package com.hospital.system.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "patient_records")
public class PatientRecord {

    @Id
    private String id;
    private String patientName;
    private String patientMail;
    private String patientId;
    private Map<String, Object> demographics;
    private Map<String, Object> labResults;
    private Map<String, Object> voiceAnalysis;
}
