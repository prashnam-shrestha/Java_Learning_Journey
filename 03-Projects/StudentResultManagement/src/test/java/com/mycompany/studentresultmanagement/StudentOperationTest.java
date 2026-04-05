/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.studentresultmanagement;

import static com.mycompany.studentresultmanagement.StudentOperation.getGradeGpa;
import static com.mycompany.studentresultmanagement.StudentOperation.getGradeLetter;
import static com.mycompany.studentresultmanagement.StudentOperation.getGradeStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author prashnamshrestha
 */
public class StudentOperationTest {

    @Test
    void calculateGrade_90_returnsAPlus() {
        Subject subject = new Subject("TestSubject", "CODE01",100, 90);
        String gradeLetter = getGradeLetter(subject);
        
        assertEquals("A+", gradeLetter);
    }
    
    @Test
    void calculateGrase_85_returnsA() {
        Subject subject = new Subject("TestSubject", "CODE02", 100, 85);
        String gradeLetter = getGradeLetter(subject);
        
        assertEquals("A", gradeLetter);
    }
    
    @Test
    void calculateGrade_70_returnsBPlus() {
        Subject subject = new Subject("TestSubject", "CODE01",100, 70);
        String gradeLetter = getGradeLetter(subject);
        
        assertEquals("B+", gradeLetter);
    }
    
    @Test
    void calculateGrase_65_returnsB() {
        Subject subject = new Subject("Python", "CODE02", 100, 65);
        String gradeLetter = getGradeLetter(subject);
        
        assertEquals("B", gradeLetter);
    };
    
    @Test
    void calculateGrade_50_returnsCPlus() {
        Subject subject = new Subject("TestSubject", "CODE01",100, 50);
        String gradeLetter = getGradeLetter(subject);
        
        assertEquals("C+", gradeLetter);
    };
    
    @Test
    void calculateGrase_45_returnsC() {
        Subject subject = new Subject("Python", "CODE02", 100, 45);
        String gradeLetter = getGradeLetter(subject);
        
        assertEquals("C", gradeLetter);
    };
    
    @Test
    void calculateGrade_0_returnsF() {
        Subject subject = new Subject("Data S", "CODE01",100, 0);
        String gradeLetter = getGradeLetter(subject);
        
        assertEquals("F", gradeLetter);
    };
  
    @Test
    void CalculateGpa_90Percent_return4Point0() {
        Student student = new Student("Prashnam Shrestha", "Pass", "STD0001");
        Subject subject = new Subject("Data S", "CODE01",100, 90);
        Subject subjectTwo = new Subject("Data S", "CODE01",100, 90);
        student.enrollSubject(subject);
        student.enrollSubject(subjectTwo);
        
        double gpa = getGradeGpa(student);
        
        assertEquals(4.0, gpa);
    }
    
    @Test
    void CalculateGpa_50Percent_return2Point7() {
        Student student = new Student("Prashnam Shrestha", "Pass", "STD0001");
        Subject subject = new Subject("Data S", "CODE01",100, 50);
        Subject subjectTwo = new Subject("Data S", "CODE01",100, 50);
        student.enrollSubject(subject);
        student.enrollSubject(subjectTwo);
        
        double gpa = getGradeGpa(student);
        
        assertEquals(2.7, gpa);
    }
    
    @Test
    void CalculateGpa_20Percent_return0Point0() {
        Student student = new Student("Prashnam Shrestha", "Pass", "STD0001");
        Subject subject = new Subject("Data S", "CODE01",100, 10);
        Subject subjectTwo = new Subject("Data S", "CODE01",100, 10);
        student.enrollSubject(subject);
        student.enrollSubject(subjectTwo);
        
        double gpa = getGradeGpa(student);
        
        assertEquals(0.0, gpa);
    }
    
    @Test
    void enrollStudent_firstEnrollment_returnsTrue() {
        Student student = new Student("Prashnam Shrestha", "Pass", "STD0001");
        Subject subject = new Subject("Data S", "CODE01",100, 0);
        assertTrue(student.enrollSubject(subject));
    }
          
    @Test
    void enrollStudent_DuplicateEnrollment_returnsFalse() {
        Student student = new Student("Prashnam Shrestha", "Pass", "STD0001");
        Subject subject = new Subject("Data S", "CODE01",100, 0);
        student.enrollSubject(subject);
        assertFalse(student.enrollSubject(subject));
    }
    
    @Test
    void getStatus_whenGpaIs2_0_returnsPass() {
       assertEquals("Result Status: PASS", getGradeStatus(2.0));
    }
    
    @Test
    void getStatus_whenGpaIs1_9_returnsFail() {
       assertEquals("Result Status: FAIL", getGradeStatus(1.9));
    }
}
