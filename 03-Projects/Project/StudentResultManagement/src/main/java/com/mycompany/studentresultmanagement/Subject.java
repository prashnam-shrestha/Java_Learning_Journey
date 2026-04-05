/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentresultmanagement;

import java.io.Serializable;

/**
 *
 * @author prashnamshrestha
 */
public class Subject implements Serializable{
    
    private String subjectName;
    private String subjectCode;
    private int totalMarks;
    private int obtainedMarks;
    
    public Subject(String subjectName, String subjectCode, int totalMarks, int obtainedMarks) {
        
        setSubjectName(subjectName);
        setSubjectCode(subjectCode);
        setTotalMarks(totalMarks);
        setObtainedMarks(obtainedMarks);
    }
    
    public Subject(Subject template) {
        this( 
               template.getSubjectName(),
               template.getSubjectCode(),
               template.getTotalMarks(),
               template.getObtainedMarks()
        );
    }
    
    
    // GETTERS AND SETTERS
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public int getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(int obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }
    
    
    
}
