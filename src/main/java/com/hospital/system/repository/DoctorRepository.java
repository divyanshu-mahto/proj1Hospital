package com.hospital.system.repository;

import com.hospital.system.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
    Optional<Doctor> findBySpecialization(String specialization);
}
