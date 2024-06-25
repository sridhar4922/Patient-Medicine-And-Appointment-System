package com.hospitalManagement.HospitalManagement;



import com.hospitalManagement.HospitalManagement.webEntity.PatientUser;
import com.hospitalManagement.HospitalManagement.webRepository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testFindByEmail() {
        PatientUser user = new PatientUser("John", "Doe", "john.doe@example.com", "password", null);
        patientRepository.save(user);

        PatientUser foundUser = patientRepository.findByEmail("john.doe@example.com");
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getEmail()).isEqualTo("john.doe@example.com");
    }
}

