package com.tests.tester.controller;

import com.tests.tester.dto.PatientDto;
import com.tests.tester.model.Patient;
import com.tests.tester.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/patients")
public class PatientController {
@Autowired
    private PatientService patientService;



@PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid PatientDto patient){
    PatientDto result=patientService.create(patient);
    return ResponseEntity.ok(result);
}

@GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
    PatientDto result = patientService.get(id);
    return ResponseEntity.ok(result);
}

@PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,@RequestBody @Valid Patient patient){
    PatientDto result=patientService.update(id,patient);
    return ResponseEntity.ok(result);
}

@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
    boolean result=patientService.delete(id);
    return ResponseEntity.ok(result);
}







}
