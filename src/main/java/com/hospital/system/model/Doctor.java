package com.hospital.system.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "doctors")
public class Doctor {
    @Id
    private String doctorId;
    private String doctorName;
    private String specialization;
    private String timings; // e.g. "10:00 AM - 2:00 PM"
}
