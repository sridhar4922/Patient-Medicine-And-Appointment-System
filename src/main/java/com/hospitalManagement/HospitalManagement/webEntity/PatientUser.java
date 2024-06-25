package com.hospitalManagement.HospitalManagement.webEntity;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PatientUser",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class PatientUser {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     @Column(name="first_Name")
     private String firstName;
     @Column(name="last_Name")
     private String lastName;
     private String email;
     private String password;

     @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
     @JoinTable(
               name = "users_roles",
               joinColumns = @JoinColumn(
                       name = "user_id",referencedColumnName = "id"),
             inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
     private Collection<PatientRole> roles;


     //Getter and Setter
     public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
     }

     public String getFirstName() {
          return firstName;
     }

     public void setFirstName(String firstName) {
          this.firstName = firstName;
     }

     public String getLastName() {
          return lastName;
     }

     public void setLastName(String lastName) {
          this.lastName = lastName;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public Collection<PatientRole> getRoles() {
          return roles;
     }

     public void setRoles(Collection<PatientRole> roles) {
          this.roles = roles;
     }

     //Default Constructor
     public PatientUser(){

     }
     //Constructor
     public PatientUser(String firstName, String lastName, String email, String password, Collection<PatientRole> roles) {
          this.firstName = firstName;
          this.lastName = lastName;
          this.email = email;
          this.password = password;
          this.roles = roles;
     }
}
