package DAO;

import model.Course;
import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    // INSERT
    public boolean addCourse(Course c) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO courses (course_name, course_semester) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, c.getCourse_name());
            ps.setInt(2, c.getCourse_semester());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // VIEW
    public List<Course> getAllCourses() {

        List<Course> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM courses";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Course c = new Course();

                c.setCourse_id(rs.getInt("course_id"));
                c.setCourse_name(rs.getString("course_name"));
                c.setCourse_semester(rs.getInt("course_semester"));

                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // UPDATE
    public boolean updateCourse(Course c) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "UPDATE courses SET course_name=?, course_semester=? WHERE course_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, c.getCourse_name());
            ps.setInt(2, c.getCourse_semester());
            ps.setInt(3, c.getCourse_id());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public boolean deleteCourse(int id) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM courses WHERE course_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}