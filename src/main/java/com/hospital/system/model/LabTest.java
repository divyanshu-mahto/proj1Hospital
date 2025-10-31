package com.hospital.system.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "lab_tests")
public class LabTest {
    @Id
    private String id;
    private String patientName;
    private String testType;
    private String email;
    private LocalDateTime testDate;
}
