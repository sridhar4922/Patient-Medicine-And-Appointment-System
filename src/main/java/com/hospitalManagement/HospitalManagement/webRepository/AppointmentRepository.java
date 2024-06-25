package com.hospitalManagement.HospitalManagement.webRepository;

import com.hospitalManagement.HospitalManagement.webEntity.Appointment;
import com.hospitalManagement.HospitalManagement.webEntity.PatientUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

    //Method to find user
    List<Appointment> findByPatientUser(PatientUser patientUser);

}
