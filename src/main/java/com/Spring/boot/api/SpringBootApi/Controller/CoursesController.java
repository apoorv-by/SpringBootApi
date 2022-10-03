package com.Spring.boot.api.SpringBootApi.Controller;

import com.Spring.boot.api.SpringBootApi.Entity.Courses;
import com.Spring.boot.api.SpringBootApi.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    CoursesService coursesService;

    @PostMapping("/addCourse")
    public Courses addCourse(@RequestBody Courses course){
        return coursesService.addCourses(course);
    }

    @GetMapping("/getCourseById/{course_id}")
    public Courses getCourseById(@PathVariable int course_id){
        return coursesService.findCoursesByID(course_id);
    }

    @GetMapping
    public List<Courses> getAllCourses(){
        return coursesService.getAllCourses();
    }

    @GetMapping("/countCourses")
    public int getTotalCourses(){
        return coursesService.countCourses();
    }

    @DeleteMapping("/deleteCourse/{course_id}")
    public void deleteCourse(@PathVariable int course_id){
        coursesService.deleteCourse(course_id);
    }

    @GetMapping("/checkCourseExistence/{course_id}")
    public boolean checkCourseExistence(@PathVariable int course_id){
        return coursesService.checkCourseExists(course_id);
    }
}
