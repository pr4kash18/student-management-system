package DAO;

import model.Student;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {

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
            if (rows > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
