package com.formation.spring.data.jpa.tutorial.repository;

import com.formation.spring.data.jpa.tutorial.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
     List<Student> findByFirstNameIgnoreCase(String firstName);
     //Find records by expression in first name
     List<Student> findByFirstNameContaining(String name);
     List<Student> findByGuardianNameIgnoreCase(String guardianName);
     Student findByFirstNameAndLastName(String firstName,String lastName);

     @Query("select s from Student s where s.emailId = ?1")
     Student getStudentByEmail(String emailId);

     @Query("select s.firstName from Student s where s.emailId = ?1")
     String getStudentFirstNameByEmail(String emailId);

     //Native Query

     @Query(
             value = "select * from tbl_student where email_address = ?1",
             nativeQuery = true
     )
     Student getStudentByEmailNative(String emailId);

     //Named Params
     @Query(
             value = "select * from tbl_student where email_address = :emailId",
             nativeQuery = true
     )
     Student getStudentByEmailNativeNamedParams(@Param("emailId") String emailId);

     @Modifying
     @Transactional
     @Query(
             value = "update tbl_student set first_name = ?1 where email_address = ?2",
             nativeQuery = true
     )
     int updateStudentFirstNameByEmailId(String firstName,String emailId);
}
