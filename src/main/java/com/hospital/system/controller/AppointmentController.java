package com.hospital.system.controller;

import com.hospital.system.model.Appointment;
import com.hospital.system.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import lombok.Data;


@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/schedule")
    public Appointment scheduleAppointment(@RequestBody AppointmentRequest request) {
        return appointmentService.scheduleAppointment(request.getPatientId(), request.getDoctorSpec());
    }

    @Data
    public static class AppointmentRequest {
        private String patientId;
        private String doctorSpec;
    }
}
