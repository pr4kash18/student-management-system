package main;

import DAO.StudentDAO;
import DAO.CourseDAO;
import model.Student;
import model.Course;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();

        while (true) {

            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Courses");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // ================= STUDENT =================
                case 1:
                    while (true) {

                        System.out.println("\n--- Student Menu ---");
                        System.out.println("1. Add Student");
                        System.out.println("2. View Students");
                        System.out.println("3. Update Student");
                        System.out.println("4. Delete Student");
                        System.out.println("5. Back");

                        int ch = sc.nextInt();
                        sc.nextLine();

                        if (ch == 5) break;

                        switch (ch) {

                            case 1:
                                Student s = new Student();

                                System.out.print("Name: ");
                                s.setStudent_Name(sc.nextLine());

                                System.out.print("Email: ");
                                s.setEmail_ID(sc.nextLine());

                                System.out.print("Contact: ");
                                s.setContact_no(sc.nextLine());

                                System.out.print("Branch: ");
                                s.setBranch(sc.nextLine());

                                System.out.print("Semester: ");
                                s.setSemester(sc.nextInt());

                                System.out.print("CGPA: ");
                                s.setCgpa(sc.nextDouble());

                                if (studentDAO.addStudent(s))
                                    System.out.println("Added ✅");
                                break;

                            case 2:
                                List<Student> students = studentDAO.getAllStudents();
                                students.forEach(System.out::println);
                                break;

                            case 3:
                                Student us = new Student();

                                System.out.print("ID: ");
                                us.setStudent_ID(sc.nextInt());
                                sc.nextLine();

                                System.out.print("New Name: ");
                                us.setStudent_Name(sc.nextLine());

                                System.out.print("New Email: ");
                                us.setEmail_ID(sc.nextLine());

                                System.out.print("New Contact: ");
                                us.setContact_no(sc.nextLine());

                                System.out.print("New Branch: ");
                                us.setBranch(sc.nextLine());

                                System.out.print("New Semester: ");
                                us.setSemester(sc.nextInt());

                                System.out.print("New CGPA: ");
                                us.setCgpa(sc.nextDouble());

                                studentDAO.updateStudent(us);
                                break;

                            case 4:
                                System.out.print("ID to delete: ");
                                studentDAO.deleteStudent(sc.nextInt());
                                break;
                        }
                    }
                    break;

                // ================= COURSE =================
                case 2:
                    while (true) {

                        System.out.println("\n--- Course Menu ---");
                        System.out.println("1. Add Course");
                        System.out.println("2. View Courses");
                        System.out.println("3. Update Course");
                        System.out.println("4. Delete Course");
                        System.out.println("5. Back");

                        int ch = sc.nextInt();
                        sc.nextLine();

                        if (ch == 5) break;

                        switch (ch) {

                            case 1:
                                Course c = new Course();

                                System.out.print("Course Name: ");
                                c.setCourse_name(sc.nextLine());

                                System.out.print("Semester: ");
                                c.setCourse_semester(sc.nextInt());

                                courseDAO.addCourse(c);
                                break;

                            case 2:
                                List<Course> courses = courseDAO.getAllCourses();
                                courses.forEach(System.out::println);
                                break;

                            case 3:
                                Course uc = new Course();

                                System.out.print("ID: ");
                                uc.setCourse_id(sc.nextInt());
                                sc.nextLine();

                                System.out.print("New Name: ");
                                uc.setCourse_name(sc.nextLine());

                                System.out.print("New Semester: ");
                                uc.setCourse_semester(sc.nextInt());

                                courseDAO.updateCourse(uc);
                                break;

                            case 4:
                                System.out.print("ID to delete: ");
                                courseDAO.deleteCourse(sc.nextInt());
                                break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}