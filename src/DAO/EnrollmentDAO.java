package DAO;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EnrollmentDAO {

    // ✅ ENROLL
    public boolean enrollStudent(int studentId, int courseId) {
        String query = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }

    // ✅ VIEW ALL ENROLLMENTS (JOIN 🔥)
    public void viewEnrollments() {
        String query = "SELECT e.enroll_id, s.student_name, c.course_name " +
                "FROM enrollments e " +
                "JOIN students s ON e.student_id = s.student_id " +
                "JOIN courses c ON e.course_id = c.course_id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- Enrollments ---");

            while (rs.next()) {
                System.out.println(
                        "Enroll ID: " + rs.getInt("enroll_id") +
                                ", Student: " + rs.getString("student_name") +
                                ", Course: " + rs.getString("course_name")
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ✅ UNENROLL
    public boolean deleteEnrollment(int enrollId) {
        String query = "DELETE FROM enrollments WHERE enroll_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, enrollId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }
}