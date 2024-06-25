package com.hospitalManagement.HospitalManagement;


import com.hospitalManagement.HospitalManagement.webRepository.PatientRepository;
import com.hospitalManagement.HospitalManagement.webService.PatientUserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PatientUserServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientUserService patientUserService;

    @Test
    public void testLoadUserByUsername_UserNotFound() {
        when(patientRepository.findByEmail(anyString())).thenReturn(null);

        // Call the method under test and assert that it throws UsernameNotFoundException
        Assertions.assertThatThrownBy(() -> patientUserService.loadUserByUsername("john.doe@example.com"))
                .isInstanceOf(UsernameNotFoundException.class);
    }
}
