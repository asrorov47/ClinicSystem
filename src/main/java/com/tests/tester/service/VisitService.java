package com.tests.tester.service;

import com.tests.tester.model.Visit;
import com.tests.tester.repository.DoctorRepository;
import com.tests.tester.repository.PatientRepository;
import com.tests.tester.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VisitService {

    @Autowired
    private VisitService visitService;
    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;




    public Visit create(Visit visit) {
        doctorService.check(visit.getDoctorId());
        patientService.check(visit.getPatientId());
    visit.setCreatedAt(LocalDateTime.now());
    visit.setStatus(true);
    visitRepository.save(visit);
    return visit;
    }

    public Visit get(Integer id) {
        Optional<Visit> optional = visitRepository.findById(id);
        if (optional.isEmpty()){
            throw  new IllegalArgumentException(" Visit Not Found ");
        }
        return optional.get();
    }

    public Visit update(Integer id, Visit visit) {
        Visit old=get(id);
        doctorService.check(visit.getDoctorId());
        old.setDoctorId(visit.getDoctorId());

        patientService.check(visit.getPatientId());
        old.setPatientId(visit.getPatientId());

        old.setDiagnosis(visit.getDiagnosis());
        visitRepository.save(old);
    return old;
    }

    public boolean delete(Integer id) {
        Visit visit=get(id);
        visitRepository.delete(visit);
    return true;
    }
}
