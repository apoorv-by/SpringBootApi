package com.Spring.boot.api.SpringBootApi.Controller;


import com.Spring.boot.api.SpringBootApi.Entity.Courses;
import com.Spring.boot.api.SpringBootApi.Entity.Learners;
import com.Spring.boot.api.SpringBootApi.service.CoursesService;
import com.Spring.boot.api.SpringBootApi.service.LearnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/learners")
public class LearnersController {

    @Autowired
    LearnersService learnersService;

    @Autowired
    CoursesService coursesService;

    // 1. Save
    @PostMapping("addLearner")
    public Learners addLearner(@RequestBody Learners learner){
        return learnersService.addLearners(learner);
    }

    // 2. Return the entity identified by the given ID.
    @GetMapping("/getLearnerById/{learner_id}")
    public Learners getLearnerById(@PathVariable int learner_id){
        return learnersService.findLearnerByID(learner_id);
    }

    // 3. Returns all entities.
    @GetMapping
    public List<Learners> getAllLearners(){
        return learnersService.getAllLearners();
    }

    // 4. Returns the number of entities.
    @GetMapping("/getTotalLearners")
    public int getTotalLearners(){
        return learnersService.countLearners();
    }

    // 5. Deletes the given entity by ID
    @DeleteMapping("/deleteLearner/{learner_id}")
    public void deleteLearner(@PathVariable int learner_id){
        learnersService.deleteLearner(learner_id);
    }

    // 6. Indicate whether an entity with the given ID exists
    @GetMapping("/checkLearnerExistence/{learner_id}")
    public boolean checkLearnerExistence(@PathVariable int learner_id){
        return learnersService.checkLearnerExists(learner_id);
    }

    // 7. Put Mapping for grabbing course object into Learner
    @PutMapping("/{learner_id}/courses/{course_id}")
    public Learners assignDetails(@PathVariable int learner_id, @PathVariable int course_id){

        Courses course = coursesService.findCoursesByID(course_id);
        //System.out.println(course);
        return learnersService.assignCourse(learner_id,course);
    }


    /*------------------------------------------------------------------------------------*/

    @RequestMapping("/findByEmailAddressAndLastname")
    public List<Learners> findByEmailAddressAndLastname(@RequestBody Map<String,String> data){
        return learnersService.findByEmailAddressAndLastname(data.get("learner_email"),data.get("learner_last_name"));
    }

    @RequestMapping("/findDistinctLearnerByLastnameOrFirstname")
    public List<Learners> findDistinctLearnerByLastnameOrFirstname(@RequestBody Map<String,String> data){
        return learnersService.findDistinctLearnerByLastnameOrFirstname(data.get("learner_last_name"),data.get("learner_first_name"));
    }

    @RequestMapping("/findByLastnameIgnoreCase")
    public List<Learners> findByLastnameIgnoreCase(@RequestBody Map<String,String> data){
        return learnersService.findByLastnameIgnoreCase(data.get("learner_last_name"));
    }

    @RequestMapping("/findByLastnameOrderByFirstnameAsc")
    public List<Learners> findByLastnameOrderByFirstnameAsc(@RequestBody Map<String,String> data){
        return learnersService.findByLastnameOrderByFirstnameAsc(data.get("learner_last_name"));
    }

}
