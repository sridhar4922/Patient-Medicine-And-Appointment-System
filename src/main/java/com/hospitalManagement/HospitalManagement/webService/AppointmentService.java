package com.hospitalManagement.HospitalManagement.webService;


import com.hospitalManagement.HospitalManagement.webEntity.Appointment;
import com.hospitalManagement.HospitalManagement.webEntity.PatientUser;
import com.hospitalManagement.HospitalManagement.webRepository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    //Method to save Patient Appointments
    public Appointment saveAppointment(Appointment appointment){

        return appointmentRepository.save(appointment);
    }

    //Method to get All Appointments
    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    //Method to display own appointments only
    public List<Appointment> findAppointmentsByPatientUser(PatientUser patientUser) {
        return appointmentRepository.findByPatientUser(patientUser);
    }
}
