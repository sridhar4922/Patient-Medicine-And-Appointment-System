package com.hospitalManagement.HospitalManagement.webService;

import com.hospitalManagement.HospitalManagement.webEntity.PatientUser;
import com.hospitalManagement.HospitalManagement.webController.Dto.PatientRegistrationDto;

public interface PatientService {

    //Method to Save patient using DTO
    PatientUser save(PatientRegistrationDto registrationDto);

}
