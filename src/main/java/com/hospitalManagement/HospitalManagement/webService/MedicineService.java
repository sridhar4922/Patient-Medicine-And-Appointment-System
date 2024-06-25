package com.hospitalManagement.HospitalManagement.webService;


import com.hospitalManagement.HospitalManagement.webEntity.Medicine;
import com.hospitalManagement.HospitalManagement.webEntity.PatientUser;
import com.hospitalManagement.HospitalManagement.webRepository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {


    @Autowired
    private MedicineRepository medicineRepository;

    //Method to add Medicine
    public Medicine saveMedicine(Medicine medicine){
        return medicineRepository.save(medicine);
    }

    //Method to getAll Medicine
    public List<Medicine> getAllMedicine(PatientUser patientUser){
        return medicineRepository.findByPatientUser(patientUser);
    }

    //Method to getMedicine By Id
    public Optional<Medicine> getMedicineById(int serialNo){
        return medicineRepository.findById(serialNo);
    }

    //Method to edit medicine quantity
    public Medicine updateMedicine(Medicine updateMedicineRequest,PatientUser loggedInUser){
        Optional<Medicine> existMedicineQuantity=medicineRepository.findById(updateMedicineRequest.getSerialNo());

        if(existMedicineQuantity.isPresent()){
            Medicine medicine=existMedicineQuantity.get();
            if (medicine.getPatientUser().getId() != loggedInUser.getId()) {
                throw new RuntimeException("Unauthorized update attempt");
            }
            medicine.setQuantity(updateMedicineRequest.getQuantity());
            return medicineRepository.save(medicine);
        }else{
            throw new RuntimeException("Medicine not found with this Id:"+updateMedicineRequest.getMedicineId());
        }
    }
}
