package com.hospitalManagement.HospitalManagement;




import com.hospitalManagement.HospitalManagement.webController.AppointmentController;
import com.hospitalManagement.HospitalManagement.webEntity.Doctor;
import com.hospitalManagement.HospitalManagement.webEntity.PatientUser;
import com.hospitalManagement.HospitalManagement.webService.AppointmentService;
import com.hospitalManagement.HospitalManagement.webService.DoctorService;
import com.hospitalManagement.HospitalManagement.webService.PatientUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class AppointmentControllerTest {

    @Mock
    private AppointmentService appointmentService;

    @Mock
    private DoctorService doctorService;

    @Mock
    private PatientUserService patientUserService;

    @InjectMocks
    private AppointmentController appointmentController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(appointmentController).build();
    }

    @Test
    public void testDisplayAppointmentForm() throws Exception {
        when(doctorService.findDocById(anyInt())).thenReturn(new Doctor());
        when(patientUserService.getCurrentlyLoggedInPatientUser()).thenReturn(new PatientUser());

        mockMvc.perform(get("/appointment/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("appointment"))
                .andExpect(model().attributeExists("appointment"))
                .andExpect(model().attributeExists("doctor"))
                .andExpect(model().attributeExists("patientUser"));
    }
}

