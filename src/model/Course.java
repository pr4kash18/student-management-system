package model;

public class Course {

    private int course_id;
    private String course_name;
    private int course_semester;

    public Course() {}

    public Course(int course_id, String course_name, int course_semester) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_semester = course_semester;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCourse_semester() {
        return course_semester;
    }

    public void setCourse_semester(int course_semester) {
        this.course_semester = course_semester;
    }

    @Override
    public String toString() {
        return course_id + " | " + course_name + " | Sem: " + course_semester;
    }
}