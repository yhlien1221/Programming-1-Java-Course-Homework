import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains the static CourseManagement logic and the main method for demonstrating the system.
 */
public class StudentManagementDemo {

    /**
     * Static class that handles centralized course and student management operations.
     */
    private static class CourseManagement {
        // Central repository for all courses
        private static List<Course> courses = new ArrayList<>();

        // Central repository for all grades (Student -> (Course -> Grade))
        private static Map<Student, Map<Course, Integer>> studentGrades = new HashMap<>();

        /**
         * Adds a course to the list of available courses.
         * @param course The Course object to add.
         */
        public static void addCourse(Course course) {
            if (course == null) return;
            if (!courses.contains(course)) {
                courses.add(course);
                System.out.println(course.getCourseName() + " has been added to the course list.");
            } else {
                System.out.println(course.getCourseName() + " is already in the course list.");
            }
        }

        /**
         * Overloaded method to create and add a course from parameters.
         */
        public static void addCourse(String courseCode, String courseName, int maximum) {
            Course course = new new Course(courseCode, courseName, maximum);
            addCourse(course);
        }

        /**
         * Enrolls a student in a course, checking course capacity.
         * @param student The student to enroll.
         * @param course The course for enrollment.
         */
        public static void enrollStudent(Student student, Course course) {
            if (student == null || course == null) {
                System.out.println("Error: Student or Course cannot be null.");
                return;
            }
            // Enroll student in Course object and simultaneously update Student's list
            if (course.enrollStudent(student)) {
                student.enrollInCourse(course);
            } else {
                System.out.println("Enrollment failed for " + student.getName() + " in " + course.getCourseName());
            }
        }

        /**
         * Assigns a grade to a student for a specific course and records it in the central map.
         * @param student The student receiving the grade.
         * @param course The course.
         * @param grade The score.
         */
        public static void assignGrade(Student student, Course course, int grade) {
            // Ensure the student has an entry in the central grade map
            studentGrades.putIfAbsent(student, new HashMap<>());

            // Assign the grade in the Student's internal map (for encapsulation)
            student.assignGrade(course, grade);
        }

        /**
         * Retrieves the grades for a specific student from the central system.
         * @param student The student whose grades are needed.
         * @return A map of Course to Integer grade.
         */
        public static Map<Course, Integer> getGradesForStudent(Student student) {
            return studentGrades.getOrDefault(student, new HashMap<>());
        }

        /**
         * Retrieves all courses currently in the system.
         * @return A list of all available Course objects.
         */
        public static List<Course> getAllCourses() {
            return courses;
        }

        /**
         * Calculates the simple overall average grade for a student based on all assigned grades.
         * @param student The student object.
         * @return The overall average grade as a double, or 0.0 if no grades are available.
         */
        public static double calculateOverallGrade(Student student) {
            // Use the student's internal grade map
            Map<Course, Integer> grades = student.getAllGrades();
            if (grades.isEmpty()) return 0.0;

            int totalGrades = 0;
            for (int grade : grades.values()) {
                totalGrades += grade;
            }
            return totalGrades / (double) grades.size();
        }
    }

    /**
     * Main method to demonstrate the usage of the Student, Course, and CourseManagement classes.
     */
    public static void main(String[] args) {
        // Create some courses
        Course math = new Course("MATH101", "Mathematics", 50);
        Course science = new Course("SCI201", "Science", 40);

        // Add courses to the system
        CourseManagement.addCourse(math);
        CourseManagement.addCourse(science);

        // Create students
        Student alice = new Student("Alice", "S001");
        Student bob = new Student("Bob", "S002");

        // Enroll students in courses
        System.out.println("\n--- Enrollment Process ---");
        CourseManagement.enrollStudent(alice, math);
        CourseManagement.enrollStudent(bob, math);
        CourseManagement.enrollStudent(alice, science);

        // Assign grades to students (using the CourseManagement system which delegates to Student)
        System.out.println("\n--- Grade Assignment Process ---");
        CourseManagement.assignGrade(alice, math, 95);
        CourseManagement.assignGrade(bob, math, 85);
        CourseManagement.assignGrade(alice, science, 90);

        // Calculate and display overall grades
        double aliceOverall = CourseManagement.calculateOverallGrade(alice);
        double bobOverall = CourseManagement.calculateOverallGrade(bob);

        System.out.println("\n--- Student Performance Summary ---");
        System.out.println("Alice's overall grade: " + aliceOverall);
        System.out.println("Bob's overall grade: " + bobOverall);
        System.out.println("Total Student Objects Created: " + Student.getTotalEnrolledStudentsTrack());

        // Display all courses and enrolled students
        System.out.println("\n--- Course Catalog ---");
        for (Course course : CourseManagement.getAllCourses()) {
            System.out.println(course);
        }
    }
}
