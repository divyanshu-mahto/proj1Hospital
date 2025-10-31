package com.hospital.system.service;

import com.hospital.system.model.Appointment;
import com.hospital.system.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final EmailService emailService;

    public Appointment scheduleAppointment(Appointment appointment) {
        Appointment saved = appointmentRepository.save(appointment);
        emailService.sendEmail(
                saved.getEmail(),
                "Appointment Confirmation",
                "Dear " + saved.getPatientName() + ", your appointment with Dr. "
                        + saved.getDoctorName() + " is confirmed for "
                        + saved.getAppointmentDate() + "."
        );
        return saved;
    }
}
