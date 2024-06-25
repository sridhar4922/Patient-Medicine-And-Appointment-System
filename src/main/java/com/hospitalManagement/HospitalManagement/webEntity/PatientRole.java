package com.hospitalManagement.HospitalManagement.webEntity;

import jakarta.persistence.*;


@Entity
@Table(name = "PatientRole")
public class PatientRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    //Default Constructor
    public PatientRole(){

    }
    public PatientRole(String name) {
        this.name = name;
    }

    //Getter and Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
