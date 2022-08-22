package com.example.demo.repository;

import com.example.demo.Model.PatientRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRecordRepository<Patient> extends JpaRepository<PatientRecord, Integer> {
}
