package com.hospitalManagement.HospitalManagement.webEntity;



import jakarta.persistence.*;

@Entity
@Table(name = "Appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String appointmentSlots;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="patient_User_Id",referencedColumnName = "id")
    private PatientUser patientUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id",referencedColumnName = "doctor_id")
    private Doctor doctorDetails;
    private String medicalHistory;
    private String date;

    //Getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppointmentSlots() {
        return appointmentSlots;
    }

    public void setAppointmentSlots(String appointmentSlots) {
        this.appointmentSlots = appointmentSlots;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    //Default Constructor
    public Appointment() {

    }

    //Constructor
    public Appointment(int id, String appointmentSlots, Doctor doctorDetails, String medicalHistory, String date) {
        this.id = id;
        this.appointmentSlots = appointmentSlots;
        this.doctorDetails = doctorDetails;
        this.medicalHistory = medicalHistory;
        this.date = date;
    }

    // Getter and Setter for doctorDetails
    public Doctor getDoctorDetails(Doctor doctor) {
        return doctorDetails;
    }

    public void setDoctorDetails(Doctor doctorDetails) {
        this.doctorDetails = doctorDetails;
    }

    public PatientUser getPatientUser() {
        return patientUser;
    }

    public void setPatientUser(PatientUser patientUser) {
        this.patientUser = patientUser;
    }
}
