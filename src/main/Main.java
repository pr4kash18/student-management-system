package main;

import model.Student;
import DAO.StudentDAO;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // buffer clear

            switch (choice) {

                case 1:
                    // INSERT
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email ID: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String contact = sc.nextLine();

                    System.out.print("Enter Branch: ");
                    String branch = sc.nextLine();

                    System.out.print("Enter Semester: ");
                    int sem = sc.nextInt();

                    System.out.print("Enter CGPA: ");
                    double cgpa = sc.nextDouble();

                    Student s = new Student();
                    s.setStudent_Name(name);
                    s.setEmail_ID(email);
                    s.setContact_no(contact);
                    s.setBranch(branch);
                    s.setSemester(sem);
                    s.setCgpa(cgpa);

                    if (dao.addStudent(s)) {
                        System.out.println("Student added successfully ✅");
                    } else {
                        System.out.println("Failed ❌");
                    }
                    break;

                case 2:
                    // VIEW
                    List<Student> students = dao.getAllStudents();

                    if (students.isEmpty()) {
                        System.out.println("No students found ❌");
                    } else {
                        for (Student stu : students) {
                            System.out.println(stu);
                        }
                    }
                    break;

                case 3:
                    // UPDATE
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

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

                    Student updated = new Student();
                    updated.setStudent_ID(updateId);
                    updated.setStudent_Name(newName);
                    updated.setEmail_ID(newEmail);
                    updated.setContact_no(newContact);
                    updated.setBranch(newBranch);
                    updated.setSemester(newSem);
                    updated.setCgpa(newCgpa);

                    if (dao.updateStudent(updated)) {
                        System.out.println("Updated successfully ✅");
                    } else {
                        System.out.println("Update failed ❌");
                    }
                    break;

                case 4:
                    // DELETE
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();

                    if (dao.deleteStudent(deleteId)) {
                        System.out.println("Deleted successfully ✅");
                    } else {
                        System.out.println("Delete failed ❌");
                    }
                    break;

                case 5:
                    // EXIT
                    System.out.println("Exiting... 👋");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice ❌");
            }
        }
    }
}