package com.Spring.boot.api.SpringBootApi.repository;

import com.Spring.boot.api.SpringBootApi.Entity.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // READING TABLE DATA
    public List<Courses> getAllCourses(){
        String getAllCoursesQuery = "SELECT * FROM Courses";
        return jdbcTemplate.query(getAllCoursesQuery, new BeanPropertyRowMapper<>(Courses.class));
    }

    // GET BY course ID
    public Courses getCourserById(int course_id){
        String getCourseQuery = "SELECT * FROM Courses WHERE course_id = ?";
        return jdbcTemplate.queryForObject(getCourseQuery,new BeanPropertyRowMapper<>(Courses.class),new Object[]{course_id});
    }

    // insert operation
    public int insertCourse(Courses course){
        String insertCourseQuery = "INSERT INTO Courses VALUES(?,?,)";
        return jdbcTemplate.update(insertCourseQuery, new Object[]{
                course.getCourse_name(),
                course.getCourse_description()
        });
    }

    // Update a certain ROW (via Courses id)
    public int updateCourse(Courses course){
        String updateQuery = "UPDATE Courses "+" SET course_name = ?," +
                " course_description = ?" + " WHERE course_id = ?";


        return jdbcTemplate.update(updateQuery, new Object[]{
                course.getCourse_name(),
                course.getCourse_description(),
                course.getCourse_Id()
        });
    }

    // Delete operation (by id)
    public int deleteCourse(int course_id){
        String deleteQuery = "DELETE FROM Courses "+" WHERE course_id = ?";

        return jdbcTemplate.update(deleteQuery, new Object[]{course_id});
    }
}
