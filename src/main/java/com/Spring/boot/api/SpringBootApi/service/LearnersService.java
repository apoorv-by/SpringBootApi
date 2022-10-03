package com.Spring.boot.api.SpringBootApi.service;

import com.Spring.boot.api.SpringBootApi.Entity.Courses;
import com.Spring.boot.api.SpringBootApi.Entity.Learners;
import com.Spring.boot.api.SpringBootApi.repository.LearnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LearnersService {

    @Autowired
    LearnersRepository learnersRepository;

    //1. Saves the given entity.
    public Learners addLearners(Learners learners){
        return learnersRepository.save(learners);
    }

    //2. Return the entity identified by the given ID.
    public Learners findLearnerByID(int id)
    {
        Optional<Learners> tempLearner = learnersRepository.findById(id);

        Learners p = null;

        if(tempLearner.isPresent()) p = tempLearner.get();
        else{
            throw new RuntimeException("Learner with id : "+id+" not found ");
        }
        return p;
    }

    //3.Returns all entities
    public List<Learners> getAllLearners(){
        return learnersRepository.findAll();
    }

    //4. Returns the number of entities.
    public int countLearners() {
        return (int) learnersRepository.count();
    }

    //5. Deletes the given entity by ID
    public void deleteLearner(int id)
    {
        Optional<Learners> tempLearner = learnersRepository.findById(id);

        if(tempLearner.isEmpty()) throw new RuntimeException("Learner with id : "+id+" not found ");

        learnersRepository.delete(tempLearner.get());
    }

    //6. Indicate whether an entity with the given ID exists.
    public boolean checkLearnerExists(int learner_id){

        Optional<Learners> tempLearner = learnersRepository.findById(learner_id);

        if(tempLearner.isEmpty()) return false;
        return true;
    }

    //7. Put Mapping for grabbing course object into Learner
    public Learners assignCourse(int learner_id, Courses courses)
    {
        Learners learners = learnersRepository.findById(learner_id).get();
        learners.setCourse(courses);
        return learnersRepository.save(learners);
    }


    /* -----------------------------------------------------------------*/


    @Transactional
    public List<Learners> findByEmailAddressAndLastname(String learner_email, String learner_last_name)
    {
        return  learnersRepository.findByLearner_emailAndLearner_last_name(learner_email, learner_last_name);
    }

    @Transactional
    public List<Learners> findDistinctLearnerByLastnameOrFirstname(String learner_last_name, String learner_first_name){
        return learnersRepository.findDistinctByLearner_last_nameOrLearner_first_name(learner_last_name, learner_first_name);
    }

    @Transactional
    public List<Learners> findByLastnameIgnoreCase(String learner_last_name){
        return learnersRepository.findByLearner_last_nameIgnoreCase(learner_last_name);
    }

    @Transactional
    public List<Learners> findByLastnameOrderByFirstnameAsc(String learner_last_name){
        return learnersRepository.findByLearner_last_nameOrderByLearners_first_nameAsc(learner_last_name);
    }

}
