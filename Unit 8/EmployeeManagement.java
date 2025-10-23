import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class EmployeeManagement {
    public static void main(String[] args) {
        // Step 1: Create a dataset of employees.
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 35, "HR", 60000), // Employee object with name, age, department, salary.
                new Employee("Bob", 28, "IT", 75000),
                new Employee("Charlie", 45, "Finance", 90000),
                new Employee("Diana", 32, "IT", 85000),
                new Employee("Eve", 29, "Marketing", 55000)
        );


        // Step 2: Create a Function to concatenate name and department.
        Function<Employee, String> nameAndDepartment =
                emp -> emp.getName() + " - " + emp.getDepartment(); // Lambda to combine employee's name and department.


        // Step 3: Use streams to create a new collection with concatenated strings.
        List<String> concatenatedStrings = employees.stream() // Start a stream from the employee list.
                .map(nameAndDepartment) // Apply the Function to each employee in the stream.
                .collect(Collectors.toList()); // Collect the transformed results into a List.
        System.out.println("Concatenated Strings:");
        concatenatedStrings.forEach(System.out::println); // Print each concatenated string.


        // Step 4: Calculate the average salary of all employees.
        double averageSalary = employees.stream() // Start a stream from the employee list.
                .mapToDouble(Employee::getSalary) // Extract the salary of each employee as a double.
                .average() // Calculate the average of the salaries.
                .orElse(0); // Provide a default value of 0 if the dataset is empty.
        System.out.printf("Average Salary: $%.2f%n", averageSalary); // Print the average salary.


        // Step 5: Filter employees based on age threshold.
        int ageThreshold = 30; // Define the minimum age for filtering.
        List<Employee> filteredEmployees = employees.stream() // Start a stream from the employee list.
                .filter(emp -> emp.getAge() > ageThreshold) // Keep only employees older than the threshold.
                .collect(Collectors.toList()); // Collect the filtered employees into a List.
        System.out.println("Employees above age " + ageThreshold + ":");
        filteredEmployees.forEach(System.out::println); // Print details of the filtered employees.
    }
}
