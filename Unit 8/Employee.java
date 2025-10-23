import java.util.*; // Import Java utility classes, such as List and Arrays, used for collections.
import java.util.function.Function; // Import the Function interface for defining transformation logic.
import java.util.stream.Collectors; // Import Collectors to process and collect stream results.


class Employee {
    private String name; // The employee's name.
    private int age; // The employee's age.
    private String department; // The employee's department.
    private double salary; // The employee's salary.


    // Constructor to initialize employee attributes.
    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }


    // Getter for the employee's name.
    public String getName() {
        return name;
    }


    // Getter for the employee's age.
    public int getAge() {
        return age;
    }


    // Getter for the employee's department.
    public String getDepartment() {
        return department;
    }


    // Getter for the employee's salary.
    public double getSalary() {
        return salary;
    }


    // Override the toString method to display employee details.
    @Override
    public String toString() {
        return String.format("%s (%s): $%.2f", name, department, salary);
    }
}
