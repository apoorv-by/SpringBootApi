package com.Spring.boot.api.SpringBootApi.repository;

import com.Spring.boot.api.SpringBootApi.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {
}
