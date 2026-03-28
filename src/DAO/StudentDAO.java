package DAO;

import model.Student;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {


    // Create
    public boolean addStudent(Student s) {
        try {
            // Create connection
            Connection con = DBConnection.getConnection();

            // SQL query
            String query = "INSERT INTO students (student_Name, Email_ID, contact_no, branch, semester, cgpa) VALUES (?, ?, ?, ?, ?, ?)";

            // PreparedStatement
            PreparedStatement ps = con.prepareStatement(query);

            // SET Values
            ps.setString(1, s.getStudent_Name());
            ps.setString(2, s.getEmail_ID());
            ps.setString(3, s.getContact_no());
            ps.setString(4, s.getBranch());
            ps.setInt(5, s.getSemester());
            ps.setDouble(6, s.getCgpa());

            // Execute
            int rows = ps.executeUpdate();

            // confirmation
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


        //View Student / Select all
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM students";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Student s = new Student();

                s.setStudent_ID(rs.getInt("student_id"));
                s.setStudent_Name(rs.getString("student_Name"));
                s.setEmail_ID(rs.getString("Email_ID"));
                s.setContact_no(rs.getString("contact_no"));
                s.setBranch(rs.getString("branch"));
                s.setSemester(rs.getInt("semester"));
                s.setCgpa(rs.getDouble("cgpa"));

                students.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }



    //  UPDATE METHOD
    public boolean updateStudent(Student s) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "UPDATE students SET student_Name=?, Email_ID=?, contact_no=?, branch=?, semester=?, cgpa=? WHERE student_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, s.getStudent_Name());
            ps.setString(2, s.getEmail_ID());
            ps.setString(3, s.getContact_no());
            ps.setString(4, s.getBranch());
            ps.setInt(5, s.getSemester());
            ps.setDouble(6, s.getCgpa());
            ps.setInt(7, s.getStudent_ID());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}