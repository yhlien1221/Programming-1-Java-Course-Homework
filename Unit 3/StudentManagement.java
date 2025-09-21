// StudentManagement.java
// This class provides the functionality to manage student records, including adding, updating, and viewing student details.
import java.util.ArrayList;
import java.util.Scanner;


public class StudentManagement {
    private static ArrayList<Student> students = new ArrayList<>(); // Stores the list of all students


    // Method to add a new student
    public static void addStudent(String name, String ID, int age, double grade) {
        students.add(new Student(name, ID, age, grade)); // Creates and adds a Student object to the list
        System.out.println("Student added successfully!");
    }


    // Method to update existing student information
    public static void updateStudent(String ID) {
        for (Student student : students) { // Loops through the list of students
            if (student.getID().equals(ID)) { // Finds the student with the matching ID
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter new name: ");
                student.setName(scanner.nextLine()); // Updates the name
                System.out.print("Enter new age: ");
                while (!scanner.hasNextInt()) { // Validates the age input
                    System.out.println("Invalid input. Please enter a valid age.");
                    scanner.next();
                }
                student.setAge(scanner.nextInt()); // Updates the age
                System.out.print("Enter new grade: ");
                while (!scanner.hasNextDouble()) { // Validates the grade input
                    System.out.println("Invalid input. Please enter a valid grade.");
                    scanner.next();
                }
                student.setGrade(scanner.nextDouble()); // Updates the grade
                System.out.println("Student information updated successfully!");
                return;
            }
        }
        System.out.println("Error: Student ID not found."); // Displays an error if no matching ID is found
    }


    // Method to view student details by ID
    public static void viewStudent(String ID) {
        for (Student student : students) { // Loops through the list of students
            if (student.getID().equals(ID)) { // Finds the student with the matching ID
                System.out.println(student); // Prints the student's details
                return;
            }
        }
        System.out.println("Error: Student ID not found."); // Displays an error if no matching ID is found
    }


    // Main method: Entry point for the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) { // Infinite loop for the menu-driven interface
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");


            int choice = scanner.nextInt(); // Reads the user's choice
            scanner.nextLine(); // Consumes the newline character


            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    String ID = scanner.nextLine();
                    System.out.print("Enter age: ");
                    while (!scanner.hasNextInt()) { // Validates the age input
                        System.out.println("Invalid input. Please enter a valid age.");
                        scanner.next();
                    }
                    int age = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    while (!scanner.hasNextDouble()) { // Validates the grade input
                        System.out.println("Invalid input. Please enter a valid grade.");
                        scanner.next();
                    }
                    double grade = scanner.nextDouble();
                    addStudent(name, ID, age, grade); // Calls the method to add the student
                    break;


                case 2:
                    System.out.print("Enter the ID of the student to update: ");
                    String updateID = scanner.nextLine();
                    updateStudent(updateID); // Calls the method to update the student
                    break;


                case 3:
                    System.out.print("Enter the ID of the student to view: ");
                    String viewID = scanner.nextLine();
                    viewStudent(viewID); // Calls the method to view the student's details
                    break;


                case 4:
                    System.out.println("Exiting the system. Goodbye!"); // Exits the program
                    return;


                default:
                    System.out.println("Invalid choice. Please try again."); // Handles invalid menu options
            }
        }
    }
}
