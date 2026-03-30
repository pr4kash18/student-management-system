package DAO;

import model.Course;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    // ================= INSERT =================
    public boolean addCourse(Course c) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO courses (course_name, course_duration, course_fee) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, c.getCourse_name());
            ps.setString(2, c.getCourse_duration());
            ps.setDouble(3, c.getCourse_fee());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ================= VIEW =================
    public List<Course> getAllCourses() {

        List<Course> courses = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM courses";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Course c = new Course();

                c.setCourse_id(rs.getInt("course_id"));
                c.setCourse_name(rs.getString("course_name"));
                c.setCourse_duration(rs.getString("course_duration"));
                c.setCourse_fee(rs.getDouble("course_fee"));

                courses.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return courses;
    }

    // ================= UPDATE =================
    public boolean updateCourse(Course c) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "UPDATE courses SET course_name=?, course_duration=?, course_fee=? WHERE course_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, c.getCourse_name());
            ps.setString(2, c.getCourse_duration());
            ps.setDouble(3, c.getCourse_fee());
            ps.setInt(4, c.getCourse_id());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ================= DELETE =================
    public boolean deleteCourse(int course_id) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM courses WHERE course_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, course_id);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}