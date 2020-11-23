package com.example.demoWebApp.controlllers;

import com.example.demoWebApp.Student;
import com.example.demoWebApp.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
class StudentControllerTest {

    @Test
    void shouldShowRegistrationForm() throws Exception {
        StudentController controller = new StudentController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/student/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    void shouldRegister() throws Exception {
        StudentRepository mockRepository =
                mock(StudentRepository.class);

        Student unsaved = new Student("mock","12hours","Mark","Ock");
        Student saved = new Student(24L,"mock","12hours","Mark","Ock");
        when(mockRepository.save(unsaved)).thenReturn(saved);

        StudentController controller =
                new StudentController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/students/register")
                .param("firstname", "Mark")
                .param("lastName", "Ock")
                .param("username", "mock")
                .param("password", "12hours"))
                .andExpect(redirectedUrl("/student/mock"));
        verify(mockRepository,atLeastOnce()).save(unsaved);
    }
}