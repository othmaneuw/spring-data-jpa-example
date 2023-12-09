package com.formation.spring.data.jpa.tutorial.repository;

import com.formation.spring.data.jpa.tutorial.entity.Course;
import com.formation.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void listAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses = "+courses);
    }

    @Test
    public void saveCourse(){

        Teacher teacher = Teacher.builder()
                .firstName("taha")
                .lastName("khemmar")
                .build();
        Course course = Course.builder()
                .title("Python")
                .credit(7)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
}