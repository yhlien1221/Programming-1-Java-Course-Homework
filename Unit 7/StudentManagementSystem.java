import java.util.ArrayList;


public class StudentManagementSystem {
    private ArrayList<Student> students; // List of students
    private ArrayList<Course> courses;   // List of courses


    public StudentManagementSystem() {
        students = new ArrayList<>();   // Initialize student list
        courses = new ArrayList<>();    // Initialize course list
    }


    public void addStudent(Student student) {
        students.add(student);          // Add a new student to the list
    }


    public void addCourse(Course course) {
        courses.add(course);            // Add a new course to the list
    }


    public ArrayList<Student> getStudents() {
        return students;                // Retrieve the list of students
    }


    public ArrayList<Course> getCourses() {
        return courses;                 // Retrieve the list of courses
    }


    public void updateStudent(int id, String newName, String newEmail) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(newName);
                s.setEmail(newEmail);
                break;
            }
        }
    }
}
