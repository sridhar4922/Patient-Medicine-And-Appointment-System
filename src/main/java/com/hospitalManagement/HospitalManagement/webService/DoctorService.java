package com.hospitalManagement.HospitalManagement.webService;


import com.hospitalManagement.HospitalManagement.webEntity.Doctor;
import com.hospitalManagement.HospitalManagement.webRepository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    //Method to Display ALl Doctors
    public List<Doctor> displayAllDoctors(){
        return doctorRepository.findAll();
    }

    //Method to findDoc by Id
    public Doctor findDocById(int doctorId){
        return  doctorRepository.findById(doctorId).orElse(null);
    }
}
