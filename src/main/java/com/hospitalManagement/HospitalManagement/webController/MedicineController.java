package com.hospitalManagement.HospitalManagement.webController;


import com.hospitalManagement.HospitalManagement.webEntity.Medicine;
import com.hospitalManagement.HospitalManagement.webEntity.PatientUser;
import com.hospitalManagement.HospitalManagement.webService.MedicineService;
import com.hospitalManagement.HospitalManagement.webService.PatientUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private PatientUserService patientUserService;

    //Method to add medicine
    @GetMapping("/addMedicine")
    public String medicineRegister(Model model){
        model.addAttribute("medicine",new Medicine());
        PatientUser loggedInPatient=patientUserService.getCurrentlyLoggedInPatientUser();
        model.addAttribute("patientUser",loggedInPatient);
        return "addMedicine";
    }

    //addMedicine
    @PostMapping(value = "/save")
    public String saveMedicine(@ModelAttribute Medicine medicine, @RequestParam("patientUserId") long patientUserId){
        PatientUser patientUser = patientUserService.getById(patientUserId);
                medicine.setPatientUser(patientUser);
                medicineService.saveMedicine(medicine);
                return "redirect:/home";
    }

    //Method for view Medicine
    @GetMapping("/displayMedicine")
    public String getAllMedicine(Model model){
        PatientUser loggedInPatient=patientUserService.getCurrentlyLoggedInPatientUser();
        List<Medicine>medicineList=medicineService.getAllMedicine(loggedInPatient);
        model.addAttribute("medicine",medicineList);
        return "viewMedicine";
    }

    //Method to edit the Quantity
    @GetMapping("medicineUpdateById")
    public String updateMedicine(@RequestParam int serialNo, Model model) {
        Optional<Medicine> medicine = medicineService.getMedicineById(serialNo);
        if (medicine.isPresent()) {
            model.addAttribute("medicine", medicine.get());
            return "updateMedicineById";
        } else {
            model.addAttribute("error", "Medicine Not Found, Unable to Update!!!");
            return "error";
        }
    }

    //Method for Update employee
    @PutMapping(value = "/saveUpdate")
    public String medicineUpdateById(@ModelAttribute Medicine medicine, Model model) {
        PatientUser loggedInPatient = patientUserService.getCurrentlyLoggedInPatientUser();
        try {
            Medicine updateMedicine=medicineService.updateMedicine(medicine,loggedInPatient);
            model.addAttribute("medicine", updateMedicine);
            return "viewMedicine";
        } catch (RuntimeException e) {
            model.addAttribute("error", "Medicine Not Found, Unable to Update!!!");
            return "error";
        }
    }
}
