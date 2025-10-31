package com.hospital.system.controller;

import com.hospital.system.model.Appointment;
import com.hospital.system.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.Data;


record ActionResponse(String message) {}

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/schedule")
    public ResponseEntity<?> scheduleAppointment(@RequestBody AppointmentRequest request) {
        System.out.println("Scheduling appointment for "+request.getPatientId()+" with "+request.getSpecialist());
        appointmentService.scheduleAppointment(request.getPatientId(), request.getSpecialist());

        String confirmationMessage = "Successfully scheduled " + " appointment for patient '"
                + request.getPatientId() + "' with " + request.getSpecialist() + ".";

        System.out.println("API: Action successful. Confirmation: " + confirmationMessage);
        return ResponseEntity.ok(new ActionResponse(confirmationMessage));
    }

    @Data
    public static class AppointmentRequest {
        private String patientId;
        private String specialist;
    }
}
