package com.formation.spring.data.jpa.tutorial.repository;

import com.formation.spring.data.jpa.tutorial.entity.Guardian;
import com.formation.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .firstName("Othmane")
                .lastName("Khemmar")
                .emailId("othmane@gmail.com")
                //.guardianName("Said")
                //.guardianMobile("9999999999")
                //.guardianEmail("said@gmail.com")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Said")
                .email("said2@gmail.com")
                .mobile("88888888888")
                .build();
        Student student = Student.builder()
                .firstName("Taha")
                .lastName("Khemmar")
                .emailId("taha@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void listAllStudents(){
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    public void findByFirstName(){
        List<Student> students = studentRepository.findByFirstNameIgnoreCase("taha");
        System.out.println("students = "+students);
    }

    @Test
    public void findByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("a");
        System.out.println("students = "+students);
    }

    @Test
    public void findByGuardianName(){
        List<Student> students = studentRepository.findByGuardianNameIgnoreCase("said");
        System.out.println("students = "+students);
    }

    @Test
    public void findByFirstNameAndLastName(){
         Student students = studentRepository.findByFirstNameAndLastName("Taha","Khemmar");
        System.out.println("students = "+students);
    }

    @Test
    public void printGetStudentByEmail(){
        Student student = studentRepository.getStudentByEmail("taha@gmail.com");
        System.out.println("student = "+student);
    }

    @Test
    public void printGetStudentFirstNameByEmail(){
        String student = studentRepository.getStudentFirstNameByEmail("taha@gmail.com");
        System.out.println("student = "+student);
    }

    @Test
    public void printGetStudentByEmailNative(){
        Student student = studentRepository.getStudentByEmailNative("taha@gmail.com");
        System.out.println("student : "+student);
    }

    @Test
    public void printGetStudentByEmailNamedParams(){
        Student student = studentRepository.getStudentByEmailNativeNamedParams("taha@gmail.com");
        System.out.println("student : "+student);
    }

    @Test
    public void updateStudentFirstNameByEmailId(){
        studentRepository.updateStudentFirstNameByEmailId("oth","othmane@gmail.com");
    }
}