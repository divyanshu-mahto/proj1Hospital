package com.hospital.system.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "appointments")
public class Appointment {
    @Id
    private String id;
    private String patientName;
    private String doctorName;
    private String email;
    private LocalDateTime appointmentDate;
}
