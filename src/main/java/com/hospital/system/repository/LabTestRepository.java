package com.hospital.system.repository;

import com.hospital.system.model.LabTest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LabTestRepository extends MongoRepository<LabTest, String> {}
