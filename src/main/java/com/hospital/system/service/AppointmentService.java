package com.hospital.system.service;

import com.hospital.system.model.Appointment;
import com.hospital.system.model.Doctor;
import com.hospital.system.repository.AppointmentRepository;
import com.hospital.system.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;

    public Appointment scheduleAppointment(String patientId, String doctorSpec) {
        Doctor doctor = doctorRepository.findBySpecialization(doctorSpec)
                .orElseThrow(() -> new RuntimeException("No doctor found for specialization: " + doctorSpec));

        Appointment appointment = new Appointment();
        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctor.getDoctorId());
        appointment.setDoctorName(doctor.getDoctorName());
        appointment.setDoctorSpecialization(doctor.getSpecialization());
        appointment.setDoctorTiming(doctor.getTimings());
        appointment.setAppointmentDate(LocalDateTime.now().plusDays(1));

        return appointmentRepository.save(appointment);
    }
}
