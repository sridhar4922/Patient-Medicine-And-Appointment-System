package com.hospitalManagement.HospitalManagement.webRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospitalManagement.HospitalManagement.webEntity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    //Method to find Doctor by Id
    Optional<Doctor> findById(int doctorId);

}