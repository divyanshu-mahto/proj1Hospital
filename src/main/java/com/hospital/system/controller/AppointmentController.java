package com.hospital.system.controller;

import com.hospital.system.model.Appointment;
import com.hospital.system.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/schedule")
    public Appointment scheduleAppointment(@RequestBody Appointment appointment) {
        return appointmentService.scheduleAppointment(appointment);
    }
}
