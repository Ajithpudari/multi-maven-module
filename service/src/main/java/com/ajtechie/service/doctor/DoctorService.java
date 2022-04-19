package com.ajtechie.service.doctor;

import com.ajtechie.dao.doctor.DoctorRepository;
import com.ajtechie.mailservice.EmailService;
import com.ajtechie.model.doctor.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;
    @Autowired
    private EmailService service;

    @PostConstruct
    public void initDoctor(){
        repository.saveAll(Stream.of
                (new Doctor(101,"billa","Cardiac"),
                        new Doctor(102,"naryanagaru","eye"))
                .collect(Collectors.toList()));
    }

    public List<Doctor> getDoctors(){
        service.sendEMail();
        return repository.findAll();
    }
}
