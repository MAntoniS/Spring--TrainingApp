package com.example.demoWebApp.controlllers;

import com.example.demoWebApp.Lecture;
import com.example.demoWebApp.repository.ILectureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
@RequestMapping("/lectures")
public class LectureController {

    private static final String MAX_LON_AS_STRING = "9223372036854775807";
    private ILectureRepository lectureRepository;

    //@Autowired
    public LectureController(ILectureRepository ILectureRepository) {
        this.lectureRepository = ILectureRepository;
    }

    @RequestMapping(method= GET)
    public List<Lecture> lectures(
            @RequestParam(value="max", defaultValue = MAX_LON_AS_STRING)long max,
            @RequestParam(value="count", defaultValue = "20")int count
    ) {
        return lectureRepository.findLectures(max,count);
    }

    @RequestMapping(value="/{lectureId}", method=GET)
    public String spittle(
            @PathVariable("lectureId") long spittleId,
            Model model) {
        model.addAttribute(lectureRepository.findOne(spittleId));
        return "lecture";
    }

}
