import java.util.HashMap;


public class Student {
    private int id;                         // Unique identifier for each student
    private String name;                    // Name of the student
    private String email;                   // Email address of the student
    private HashMap<String, String> grades; // Map of course names to assigned grades


    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.grades = new HashMap<>();      // Initialize an empty grades map
    }


    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public HashMap<String, String> getGrades() { return grades; }


    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }


    public void enrollInCourse(String course) {
        if (!grades.containsKey(course)) {
            grades.put(course, "Not Graded"); // Default grade for a new course
        }
    }


    public void assignGrade(String course, String grade) {
        grades.put(course, grade);          // Add or update the grade for a course
    }
}
