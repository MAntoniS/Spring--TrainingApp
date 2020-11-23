package com.example.demoWebApp;

import com.example.demoWebApp.controlllers.HomeController;
import com.example.demoWebApp.controlllers.LectureController;
import com.example.demoWebApp.controlllers.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoWebAppApplicationTests {

	@Autowired
	HomeController homeController;
	@Autowired
	LectureController lectureController;
	@Autowired
	StudentController studentController;

	@Test
	public void contextLoadsHomeController(){
		assertThat(homeController).isNotNull();
	}
	@Test
	public void contextLoadsLectureController(){
		assertThat(lectureController).isNotNull();
	}
	@Test
	public void contextLoadStudentController(){
		assertThat(studentController).isNotNull();
	}


}
