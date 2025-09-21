// Student.java
// This class defines the blueprint for a Student object, encapsulating attributes like name, ID, age, and grade.
public class Student {
    private String name; // Stores the student's name
    private String ID;   // Stores the student's ID
    private int age;     // Stores the student's age
    private double grade; // Stores the student's grade


    // Constructor: Initializes the student's attributes when an object is created
    public Student(String name, String ID, int age, double grade) {
        this.name = name;
        this.ID = ID;
        this.age = age;
        this.grade = grade;
    }


    // Getter for name: Allows retrieval of the name attribute
    public String getName() {
        return name;
    }


    // Setter for name: Allows updating the name attribute
    public void setName(String name) {
        this.name = name;
    }


    // Getter for ID: Allows retrieval of the ID attribute
    public String getID() {
        return ID;
    }


    // Setter for ID: Allows updating the ID attribute
    public void setID(String ID) {
        this.ID = ID;
    }


    // Getter for age: Allows retrieval of the age attribute
    public int getAge() {
        return age;
    }


    // Setter for age: Allows updating the age attribute
    public void setAge(int age) {
        this.age = age;
    }


    // Getter for grade: Allows retrieval of the grade attribute
    public double getGrade() {
        return grade;
    }


    // Setter for grade: Allows updating the grade attribute
    public void setGrade(double grade) {
        this.grade = grade;
    }


    // Overrides the default toString method to provide a meaningful string representation of the Student object
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}
