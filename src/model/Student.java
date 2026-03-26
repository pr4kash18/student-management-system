package model;

public class Student {

    private int student_ID;
    private String student_Name;
    private String Email_ID;
    private String contact_no;
    private String branch;
    private int semester;
    private double cgpa;

    // Default Constructor
    public Student() {
    }

    // Parameterized Constructor
    public Student(int student_ID, String student_Name, String Email_ID, String contact_no, String branch, int semester, double cgpa) {
        this.student_ID = student_ID;
        this.student_Name = student_Name;
        this.Email_ID = Email_ID;
        this.contact_no = contact_no;
        this.branch = branch;
        this.semester = semester;
        this.cgpa = cgpa;
    }

    // Getters and Setters

    public int getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(int student_ID) {
        this.student_ID = student_ID;
    }

    public String getStudent_Name() {
        return student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
    }

    public String getEmail_ID() {
        return Email_ID;
    }

    public void setEmail_ID(String email_ID) {
        Email_ID = email_ID;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}