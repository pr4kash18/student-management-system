package main;

import model.Student;
import DAO.StudentDAO;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Insert student part start

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

        // INSERT STUDENT PART END


        // VIEW STUDENTS PART START

        System.out.println("\n===== ALL STUDENTS =====");

        List<Student> students = dao.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found ❌");
        } else {
            for (Student stu : students) {
                System.out.println(stu);
            }
        }

        // VIEW STUDENTS PART END


        // 🔄 UPDATE STUDENT PART START

        System.out.print("\nEnter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // ⚠️ important (buffer clear)

        System.out.print("Enter New Name: ");
        String newName = sc.nextLine();

        System.out.print("Enter New Email: ");
        String newEmail = sc.nextLine();

        System.out.print("Enter New Contact: ");
        String newContact = sc.nextLine();

        System.out.print("Enter New Branch: ");
        String newBranch = sc.nextLine();

        System.out.print("Enter New Semester: ");
        int newSem = sc.nextInt();

        System.out.print("Enter New CGPA: ");
        double newCgpa = sc.nextDouble();

        Student updatedStudent = new Student();
        updatedStudent.setStudent_ID(id); // 🔥 most important
        updatedStudent.setStudent_Name(newName);
        updatedStudent.setEmail_ID(newEmail);
        updatedStudent.setContact_no(newContact);
        updatedStudent.setBranch(newBranch);
        updatedStudent.setSemester(newSem);
        updatedStudent.setCgpa(newCgpa);

        boolean updateResult = dao.updateStudent(updatedStudent);

        if (updateResult) {
            System.out.println("Student updated successfully ✅");
        } else {
            System.out.println("Update failed ❌");
        }

        // 🔄 UPDATE STUDENT PART END


        sc.close();
    }
}