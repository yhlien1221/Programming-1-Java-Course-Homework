import java.util.ArrayList;
import java.util.List;

/**
 * Represents a course offered by the institution, managing its capacity and roster.
 */
public class Course {
    private String courseCode;
    private String courseName;
    private int maximum;
    private List<Student> enrolledStudents;

    // Static variable to track the total number of enrolled students across all courses
    private static int totalEnrolledStudents = 0;

    /**
     * Constructor for the Course class.
     * @param courseCode The unique course identifier.
     * @param courseName The full name of the course.
     * @param maximum The maximum number of students allowed.
     */
    public Course(String courseCode, String courseName, int maximum) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maximum = maximum;
        this.enrolledStudents = new ArrayList<>();
    }

    // --- Setter Methods ---
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    // --- Getter Methods ---
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaximum() {
        return maximum;
    }

    /**
     * Overrides toString to provide a meaningful string representation of the course.
     */
    @Override
    public String toString() {
        return courseCode + ": " + courseName + " (Max students: " + maximum + ")";
    }

    /**
     * Attempts to enroll a student in this course.
     * @param student The student object to enroll.
     * @return true if enrollment was successful, false otherwise (course is full).
     */
    public boolean enrollStudent(Student student) {
        if (enrolledStudents.size() < maximum) {
            enrolledStudents.add(student);
            totalEnrolledStudents++;
            // Enrollment confirmation is handled by the CourseManagement class to prevent duplicate messages
            return true;
        } else {
            System.out.println("Enrollment failed: Course is full.");
            return false;
        }
    }

    /**
     * Removes a student from the course roster.
     * @param student The student object to drop.
     * @return true if the student was successfully dropped, false otherwise.
     */
    public boolean dropStudent(Student student) {
        if (enrolledStudents.contains(student)) {
            enrolledStudents.remove(student);
            totalEnrolledStudents--;
            System.out.println(student.getName() + " has been removed from " + courseName);
            return true;
        } else {
            System.out.println(student.getName() + " is not enrolled in " + courseName);
            return false;
        }
    }

    /**
     * Static method to retrieve the total number of enrolled students across all courses.
     * @return The cumulative total student count.
     */
    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }
}
