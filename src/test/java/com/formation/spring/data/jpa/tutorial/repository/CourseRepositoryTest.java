package com.formation.spring.data.jpa.tutorial.repository;

import com.formation.spring.data.jpa.tutorial.entity.Course;
import com.formation.spring.data.jpa.tutorial.entity.Student;
import com.formation.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void listAllCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses = " + courses);
    }

    @Test
    public void saveCourse() {

        Teacher teacher = Teacher.builder()
                .firstName("adam")
                .lastName("khemmar")
                .build();
        Course course = Course.builder()
                .title("JEE")
                .credit(7)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    /*@Test
    public void findAllPagination(){
        Pageable pageThreeRecords = PageRequest.of(0,3);
       long courses = courseRepository.findAll(pageThreeRecords).getTotalElements();
        System.out.println("courses = " + courses);
    }

    @Test
    public void printFindByTitleContaining(){
        Pageable pageThreeRecords = PageRequest.of(0,2);
        List<Course> courses = courseRepository.findByTitleContaining("A",(Pageable) pageThreeRecords).getContent();
    }*/

    @Test
    public void saveCourseWithTeacherAndStudents(){
        Teacher teacher = Teacher.builder()
                .firstName("said")
                .lastName("khemar")
                .build();
        Student student = Student.builder()
                .firstName("kenza")
                .lastName("mehlil")
                .emailId("kenza@gmail.com")
                .build();
        Course course = Course.builder()
                .title("JPA")
                .credit(10)
                .teacher(teacher)
                .build();
        course.addStudent(student);
        courseRepository.save(course);
    }

}