package com.formation.spring.data.jpa.tutorial.repository;

import com.formation.spring.data.jpa.tutorial.entity.Course;
import com.formation.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseJava = Course.builder()
                .title("JAVA")
                .credit(5)
                .build();
        Course courseHTML = Course.builder()
                .title("HTML")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Othmane")
                .lastName("Khemmar")
                //.courses(List.of(courseJava,courseHTML))
                .build();

        teacherRepository.save(teacher);

    }

}