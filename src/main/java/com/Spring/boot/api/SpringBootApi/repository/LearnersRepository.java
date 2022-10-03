package com.Spring.boot.api.SpringBootApi.repository;

import com.Spring.boot.api.SpringBootApi.Entity.Learners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface LearnersRepository extends JpaRepository<Learners, Integer> {

/*

    @Modifying
    List<Learners> findByLearner_emailAndLearner_last_name(@Param("learner_email")  String learner_email, @Param("learner_last_name") String learner_last_name);

    @Modifying
    List<Learners> findDistinctByLearner_last_nameOrLearner_first_name(@Param("learner_last_name") String learner_last_name, @Param("learner_first_name") String learner_first_name);

    @Modifying
    List<Learners> findByLearner_last_nameIgnoreCase(@Param("learner_last_name") String learner_last_name);

    @Modifying
    List<Learners> findByLearner_last_nameOrderByLearners_first_nameAsc(@Param("learner_last_name") String learner_last_name);
*/


    @Modifying
    @Query("SELECT l " +
            "FROM Learners l " +
            "WHERE l.learner_email = :learner_email AND l.learner_last_name = :learner_last_name")
    List<Learners> findByLearner_emailAndLearner_last_name(@Param("learner_email")  String learner_email, @Param("learner_last_name") String learner_last_name);

    @Modifying
    @Query("SELECT DISTINCT l " +
            "FROM Learners l " +
            "WHERE l.learner_last_name = :learner_last_name OR " +
            " l.learner_first_name = :learner_first_name")
    List<Learners> findDistinctByLearner_last_nameOrLearner_first_name(@Param("learner_last_name") String learner_last_name, @Param("learner_first_name") String learner_first_name);

    @Modifying
    @Query("SELECT l " +
            "FROM Learners l " +
            "WHERE UPPER(l.learner_last_name) = UPPER(:learner_last_name)")
    List<Learners> findByLearner_last_nameIgnoreCase(@Param("learner_last_name") String learner_last_name);

    @Modifying
    @Query("SELECT l " +
            "FROM Learners l " +
            "WHERE l.learner_last_name = :learner_last_name " +
            "ORDER BY l.learner_first_name ASC")
    List<Learners> findByLearner_last_nameOrderByLearners_first_nameAsc(@Param("learner_last_name") String learner_last_name);

}
