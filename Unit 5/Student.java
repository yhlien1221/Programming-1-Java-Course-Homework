import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a student in the system, managing their enrollment and grades.
 */
public class Student {

    private String name;
    private String id;
    private List<Course> enrolledCourses;
    private Map<Course, Integer> courseGrades;

    // Static counter to track total number of student objects created
    private static int totalEnrolledStudentsTrack = 0;

    /**
     * Constructor for the Student class.
     * @param name The name of the student.
     * @param id The unique ID of the student.
     */
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new ArrayList<>();
        this.courseGrades = new HashMap<>();
        totalEnrolledStudentsTrack++;
    }

    // --- Getter Methods ---
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public Map<Course, Integer> getGrade() {
        // Returns the map used to store grades, though typically getGrade(Course) is used.
        return courseGrades;
    }

    public static int getTotalEnrolledStudentsTrack() {
        return totalEnrolledStudentsTrack;
    }

    // --- Setter Methods ---
    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public void setGrade(Map<Course, Integer> courseGrades) {
        this.courseGrades = courseGrades;
    }

    // --- Core Enrollment and Grade Methods ---

    /**
     * Enrolls the student in a specified course.
     * Note: This method is typically called by the CourseManagement system.
     * @param course The course to enroll in.
     */
    public void enrollInCourse(Course course) {
        if (course == null) {
            System.out.println("Cannot enroll in a null course.");
            return;
        }
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            System.out.println(name + " has been enrolled in " + course.getCourseName());
        } else {
            System.out.println(name + " is already enrolled in " + course.getCourseName());
        }
    }

    /**
     * Assigns a grade to the student for a specific course.
     * @param course The course for which the grade is assigned.
     * @param grade The score (integer).
     */
    public void assignGrade(Course course, int grade) {
        if (!enrolledCourses.contains(course)) {
            System.out.println(name + " is not enrolled in " + course);
            return;
        }

        courseGrades.put(course, grade);
        System.out.println("Grade " + grade + " has been assigned to " + name + " for " + course.getCourseName());
    }

    /**
     * Retrieves the grade for a specific course.
     * @param course The course to check the grade for.
     * @return The integer grade, or null if no grade is assigned.
     */
    public Integer getGrade(Course course) {
        return courseGrades.get(course);
    }

    /**
     * Retrieves the entire map of course grades.
     * @return A map of Course to Integer grade.
     */
    public Map<Course, Integer> getAllGrades() {
        return courseGrades;
    }
}
