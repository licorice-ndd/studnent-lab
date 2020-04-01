/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Klay
 */
public class Report {
    private String studentID;
    private String studentName;
    private String courseName;
    private int courseNumb;

    public Report(String studentID, String studentName, String courseName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.courseName = courseName;
        this.courseNumb=1;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
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

    public int getCourseNumb() {
        return courseNumb;
    }

    public void setCourseNumb(int courseNumb) {
        this.courseNumb++;
    }
    
}
