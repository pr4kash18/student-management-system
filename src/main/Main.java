package main;

import model.Student;
import DAO.StudentDAO;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String student_Name = sc.nextLine();

        System.out.print("Enter Email ID: ");
        String Email_ID = sc.nextLine();

        System.out.print("Enter Contact Number: ");
        String contact_no = sc.nextLine();

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();

        System.out.print("Enter Current Semester: ");
        int semester = sc.nextInt();

        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();

        // Create Student object
        Student s = new Student();
        s.setStudent_Name(student_Name);
        s.setEmail_ID(Email_ID);
        s.setContact_no(contact_no);
        s.setBranch(branch);
        s.setSemester(semester);
        s.setCgpa(cgpa);

        // DAO call
        StudentDAO dao = new StudentDAO();
        boolean result = dao.addStudent(s);

        // Output
        if (result) {
            System.out.println("Student added successfully ✅");
        } else {
            System.out.println("Failed to add student ❌");
        }

        sc.close();
    }
}