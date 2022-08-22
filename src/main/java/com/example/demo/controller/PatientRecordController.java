package com.example.demo.controller;

import com.example.demo.Model.PatientRecord;
import com.example.demo.repository.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000/patient")
public class PatientRecordController {
    @Autowired
    PatientRecordRepository patientRecordRepository;

    @GetMapping("/listPatient")
    public List<PatientRecord> getAllPatient(){
        return patientRecordRepository.findAll();
    }

    @GetMapping("patient{id}")
    public PatientRecord getPatientId(@PathVariable Integer id){
        return (PatientRecord) patientRecordRepository.findById(id).get();
    }

    @PostMapping("/patient")
    public List<PatientRecord> addPatient(@RequestBody PatientRecord patientRecord){
        patientRecordRepository.save(patientRecord);
        return patientRecordRepository.findAll();
    }
    @PutMapping("/patient/{id}")
    public List<PatientRecord> updatePatient(@RequestBody PatientRecord patientRecord, @PathVariable Integer id){
        PatientRecord patientRecord1 = (PatientRecord) patientRecordRepository.findById(id).get();
        patientRecord1.setName(patientRecord.getName());
        patientRecord1.setAddress(patientRecord.getAddress());
        patientRecordRepository.save(patientRecord1);
        return patientRecordRepository.findAll();
    }

    @DeleteMapping("/patient/{id}")
    public List<PatientRecord> deletePatient(@PathVariable Integer id){
        patientRecordRepository.delete(patientRecordRepository.findById(id).get());
        return patientRecordRepository.findAll();
    }
}
