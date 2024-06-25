package com.hospitalManagement.HospitalManagement.webEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "medicine_Management")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serialNo;

    private String medicineId;
    private String medicineName;
    private String Dosage;
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="patient_User_Id",referencedColumnName = "id")
    private PatientUser patientUser;


    //Getter and Setter
    public PatientUser getPatientUser() {
        return patientUser;
    }

    public void setPatientUser(PatientUser patientUser) {
        this.patientUser = patientUser;
    }


    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDosage() {
        return Dosage;
    }

    public void setDosage(String dosage) {
        Dosage = dosage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Default Constructor
    public Medicine(){

    }

    //Constructor
    public Medicine(int serialNo, String medicineId, String medicineName, String dosage, int quantity) {
        this.serialNo = serialNo;
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        Dosage = dosage;
        this.quantity = quantity;
    }
}
