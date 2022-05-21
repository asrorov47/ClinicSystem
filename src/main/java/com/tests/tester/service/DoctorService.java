package com.tests.tester.service;

import com.tests.tester.dto.DoctorDto;
import com.tests.tester.model.Doctor;
import com.tests.tester.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DoctorService {

@Autowired
private DoctorRepository doctorRepository;

@Autowired
private DoctorService doctorService;

    public Doctor create(Doctor doctor) {
        doctor.setCreatedAt(LocalDateTime.now());
        doctor.setStatus(true);
        doctorRepository.save(doctor);
        return doctor;
    }



    public DoctorDto get(Integer id) {
        Doctor doctor = check(id);
   DoctorDto dto = new DoctorDto();
    dto.setName(doctor.getName());
    dto.setSurname(doctor.getSurname());
    dto.setContact(doctor.getContact());
    dto.setDirection(doctor.getDirection());
    dto.setExperience(doctor.getExperience());

    return dto;

    }
    public Doctor check(Integer id){

        Optional<Doctor> optional = doctorRepository.findById(id);
        if (optional.isEmpty()){
            throw  new IllegalArgumentException(" Doctor Not Found ");
        }
        return (Doctor) optional.get();
    }



    public Doctor update(Integer id, Doctor doctor) {
        Doctor old=check(id);
        old.setName(doctor.getName());
        old.setSurname(doctor.getSurname());
        old.setDirection(doctor.getDirection());
        old.setContact(doctor.getContact());
        old.setExperience(doctor.getExperience());
        doctorRepository.save(old);
        return old;
    }

    public boolean delete(Integer id) {
        Doctor doctor=check(id);
        doctorRepository.delete(doctor);
        return true;
    }
}
