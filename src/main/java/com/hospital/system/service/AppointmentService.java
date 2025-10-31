package com.hospital.system.service;

import com.hospital.system.model.Appointment;
import com.hospital.system.model.Doctor;
import com.hospital.system.model.PatientRecord;
import com.hospital.system.repository.AppointmentRepository;
import com.hospital.system.repository.DoctorRepository;
import com.hospital.system.repository.PatientRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;

    private final PatientRecordRepository patientRecordRepository;
    private final EmailService emailService;

    public ResponseEntity<?> scheduleAppointment(String patientId, String doctorSpec) {
        Doctor doctor = doctorRepository.findBySpecialization(doctorSpec)
                .orElseThrow(() -> new RuntimeException("No doctor found for specialization: " + doctorSpec));

        Appointment appointment = new Appointment();
        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctor.getDoctorId());
        appointment.setDoctorName(doctor.getDoctorName());
        appointment.setDoctorSpecialization(doctor.getSpecialization());
        appointment.setDoctorTiming(doctor.getTimings());
        appointment.setAppointmentDate(LocalDateTime.now().plusDays(1));


        try{
            appointmentRepository.save(appointment);
            PatientRecord patientRecord = patientRecordRepository.findByPatientId(patientId);
            emailService.sendEmail(patientRecord.getPatientMail(), "Appointment Scheduled for "+appointment.getAppointmentDate(),
                    "Dear "+patientRecord.getPatientName()+" an appointment with "+appointment.getDoctorName()+ " has been scheduled for you on "+appointment.getAppointmentDate());

            return new ResponseEntity<>("Appointment scheduled successfully", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
