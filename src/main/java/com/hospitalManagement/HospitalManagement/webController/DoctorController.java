package com.hospitalManagement.HospitalManagement.webController;


import com.hospitalManagement.HospitalManagement.webEntity.Doctor;
import com.hospitalManagement.HospitalManagement.webService.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    //Endpoint to display Doctors
    @GetMapping(value = "/displayDoctors")
    public String getAllDoctors(Model model){
        List<Doctor> doctorList=doctorService.displayAllDoctors();
        model.addAttribute("doctor",doctorList);
        return "viewDoctors";
    }

    //Endpoint to BookAppointment
    @GetMapping(value = "/bookAppointment/{doctorId}")
    public String bookAppointment(@PathVariable int doctorId, Model model){
        Doctor doctor=doctorService.findDocById(doctorId);
        model.addAttribute("doctor",doctor);
        return "appointment";
    }

}
