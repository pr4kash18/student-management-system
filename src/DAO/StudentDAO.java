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
            String query = "INSERT INTO students VALUES (?, ?, ?, ?, ?, ?, ?)";

            // PreparedStatement
            PreparedStatement ps = con.prepareStatement(query);

            // SET Values
            ps.setInt(1, s.getStudent_ID());
            ps.setString(2, s.getStudent_Name());
            ps.setString(3, s.getEmail_ID());
            ps.setString(4, s.getContact_no());
            ps.setString(5, s.getBranch());
            ps.setInt(6, s.getSemester());
            ps.setDouble(7, s.getCgpa());

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
