package com.hospitalManagement.HospitalManagement.webRepository;

import com.hospitalManagement.HospitalManagement.webEntity.Medicine;
import com.hospitalManagement.HospitalManagement.webEntity.PatientUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface MedicineRepository extends JpaRepository<Medicine,Integer> {

    //Method to find patient Serial No
    Optional<Medicine> findById(Integer serialNo);

    //Method to find user in medicine section
    List<Medicine> findByPatientUser(PatientUser patientUser);
}
