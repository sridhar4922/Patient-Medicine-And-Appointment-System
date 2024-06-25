package com.hospitalManagement.HospitalManagement.webEntity;


import jakarta.persistence.*;

@Entity
@Table(name = "Doctor_Details")
public class Doctor {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "doctor_Id")
     private int doctorId;
     @Column(name = "DoctorName")
     private String name;
     private String specialization;
     private String qualification;
     private int experience;
     private double consultationFee;
     private String availableSlot;
     private String availableDate;
     private String availableTime;

    //Getter and Setter
    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getAvailableSlot() {
        return availableSlot;
    }

    public void setAvailableSlot(String availableSlot) {
        this.availableSlot = availableSlot;
    }

    public String getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(String availableDate) {
        this.availableDate = availableDate;
    }

    public String getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(String availableTime) {
        this.availableTime = availableTime;
    }

    // Default constructor
    public Doctor() {

    }

    //Constructor
    public Doctor(int doctorId, String name, String specialization, String qualification, int experience,
                  double consultationFee, String availableSlot,String availableDate, String availableTime) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experience = experience;
        this.consultationFee = consultationFee;
        this.availableSlot = availableSlot;
        this.availableDate = availableDate;
        this.availableTime = availableTime;

    }
}
