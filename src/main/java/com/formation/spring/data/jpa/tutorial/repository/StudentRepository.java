package com.formation.spring.data.jpa.tutorial.repository;

import com.formation.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
     List<Student> findByFirstNameIgnoreCase(String firstName);

     //Find records by expression in first name
     List<Student> findByFirstNameContaining(String name);
     List<Student> findByGuardianNameIgnoreCase(String guardianName);
     Student findByFirstNameAndLastName(String firstName,String lastName);
}
