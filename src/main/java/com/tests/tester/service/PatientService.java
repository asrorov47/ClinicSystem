package com.tests.tester.service;

import com.sun.xml.bind.v2.TODO;
import com.tests.tester.dto.PatientDto;
import com.tests.tester.model.Patient;
import com.tests.tester.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;


    public PatientDto create(PatientDto patientDto){
       Patient patient = new Patient();
       patient.setName(patientDto.getName());
       patient.setSurname(patientDto.getSurname());
       patient.setBirthday(patientDto.getBirthday());
        //TODO LocalDatega from qo`shildi tekshirtish kerak Samandar akaga;
       patient.setAge(LocalDate.now().getYear() - patientDto.getBirthday().getYear());
       patient.setContact(patientDto.getContact());
       patient.setCreatedAt(LocalDateTime.now());
        patient.setStatus(true);
        patientRepository.save(patient);
        patientDto.setId(patient.getId());
        return patientDto;
    }


    public PatientDto get(Integer id) {

        Patient patient = check(id);
    PatientDto patientDto = new PatientDto();
    patientDto.setId(patient.getId());
    patientDto.setName(patient.getName());
    patientDto.setSurname(patient.getSurname());
    patientDto.setAge(patient.getAge());
    patientDto.setBirthday(patient.getBirthday());
    patientDto.setContact(patient.getContact());
    return patientDto;

    }

    public Patient check(Integer id){

        Optional<Patient> optional = patientRepository.findById(id);
        if (optional.isEmpty()){
            //TODO: IllegalArgumentEx-BadRequest bumayapti Samandar akaga ko`rsatish kere;
            throw  new IllegalArgumentException(" Patient Not Found ");
        }
        return optional.get();
    }

    public PatientDto check(Integer id,PatientDto patientDto){
        Patient old=check(id);
        old.setName(patientDto.getName());
        old.setSurname(patientDto.getSurname());
        old.setContact(patientDto.getContact());
        patientDto.setAge(LocalDate.now().getYear() - patientDto.getBirthday().getYear());
        old.setBirthday(patientDto.getBirthday());
        patientRepository.save(old);
        return old;
    }



    public boolean delete(Integer id){
        Patient patient=check(id);
        patientRepository.delete(patient);
        return true;
    }



}
