package com.example.demoWebApp.controlllers;

import com.example.demoWebApp.Lecture;
import com.example.demoWebApp.repository.ILectureRepository;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
class LectureControllerTest {

    @Test
    void shouldShowLatestLectures() throws Exception {
        List<Lecture> expectedLectures = createLectureList(20);
        ILectureRepository mockRepository =
                mock(ILectureRepository.class);
        when(mockRepository.findLectures(Long.MAX_VALUE, 20))
                .thenReturn(expectedLectures);
        LectureController controller = new LectureController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(
                        new InternalResourceView("WEN-INF/views/lectures.jsp"))
                .build();
        mockMvc.perform(get("/lectures"))
                .andExpect(view().name("lectures"))
                .andExpect(model().attributeExists("lectureList"))
                .andExpect(model().attribute("lectureList",
                        hasItems(expectedLectures.toArray())));
    }

    @Test
    void  shouldShowPagedLectures() throws Exception {
        List<Lecture> expectedLectures = createLectureList(30);
        ILectureRepository mockRepository =
                mock(ILectureRepository.class);
        when(mockRepository.findLectures(238900, 30))
                .thenReturn(expectedLectures);
        LectureController controller = new LectureController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(
                        new InternalResourceView("WEN-INF/views/lectures.jsp"))
                .build();
        mockMvc.perform(get("/lectures?max=238900&count=30"))
                .andExpect(view().name("lectures"))
                .andExpect(model().attributeExists("lectureList"))
                .andExpect(model().attribute("lectureList",
                        hasItems(expectedLectures.toArray())));
    }

    void testLecture() throws Exception{
        Lecture expectedLecture = new Lecture("Hello", new Date());
        ILectureRepository mockRepository = mock(ILectureRepository.class);
        when(mockRepository.findOne(12345)).thenReturn(expectedLecture);

        LectureController controller = new LectureController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/lectures/12345"))
                .andExpect(view().name("lecture"))
                .andExpect(model().attributeExists("lecture"))
                .andExpect(model().attribute("lecture", expectedLecture));


    }

    private List<Lecture> createLectureList(int count) {
    List<Lecture> lectures = new ArrayList<Lecture>();
    for (int i = 0; i < count; i++)
    {
        lectures.add(new Lecture("Lecture" + i, new Date()));
    }
    return lectures;
    }
}