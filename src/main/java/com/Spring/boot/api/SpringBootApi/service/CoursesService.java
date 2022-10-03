package com.Spring.boot.api.SpringBootApi.service;

import com.Spring.boot.api.SpringBootApi.Entity.Courses;
import com.Spring.boot.api.SpringBootApi.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {

    @Autowired
    CoursesRepository coursesRepository;

    //1. Saves the given entity.
    public Courses addCourses(Courses courses){
        return coursesRepository.save(courses);
    }

    //2. Return the entity identified by the given ID.
    public Courses findCoursesByID(int id)
    {
        Optional<Courses> tempCourses = coursesRepository.findById(id);

        Courses p = null;

        if(tempCourses.isPresent()) p = tempCourses.get();
        else{
            throw new RuntimeException("Course with id : "+id+" not found ");
        }
        return p;
    }

    //3.Returns all entities
    public List<Courses> getAllCourses(){
        return coursesRepository.findAll();
    }

    //4. Returns the number of entities.
    public int countCourses() {
        return (int) coursesRepository.count();
    }

    //5. Deletes the given entity by ID
    public void deleteCourse(int id)
    {
        Optional<Courses> tempCourse = coursesRepository.findById(id);

        if(tempCourse.isEmpty()) throw new RuntimeException("Course with id : "+id+" not found ");

        coursesRepository.delete(tempCourse.get());
    }

    //6. Indicate whether an entity with the given ID exists.
    public boolean checkCourseExists(int course_id){

        Optional<Courses> tempCourse = coursesRepository.findById(course_id);

        if(tempCourse.isEmpty()) return false;
        return true;
    }
}
