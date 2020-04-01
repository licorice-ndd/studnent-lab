import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Klay
 */
public class Student implements Comparable<Student>{

    private String id;
    private String studentName;
    private String courseName;
    private String semester;

    public Student() {
    }

    public Student(String id, String studentName, String courseName, String semester) {
        this.id = id;
        this.studentName = studentName;
        this.courseName = courseName;
        this.semester = semester;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return studentName.trim() + "|" + courseName+"|"+semester;
    }
    @Override
    public int compareTo(Student s) {
        String[]a;
        String[]b;
        a=this.studentName.split("\\s");
        b=s.getStudentName().split("\\s");
        return (a[a.length-1].compareToIgnoreCase(b[b.length-1]));
    }

         
    
}
            
           
               
         
            
        
