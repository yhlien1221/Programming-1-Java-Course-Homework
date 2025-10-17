import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class StudentManagementGUI {
    private StudentManagementSystem sms;  // Instance of the management system
    private JFrame frame;                 // Main window
    private JTable studentTable;          // Table to display students
    private JTable detailsTable;          // Table to display courses and grades
    private DefaultTableModel studentTableModel;
    private DefaultTableModel detailsTableModel;


    public StudentManagementGUI() {
        sms = new StudentManagementSystem(); // Initialize the system
        frame = new JFrame("Student Management System");


        // Initialize sample courses
        sms.addCourse(new Course("C101", "Mathematics"));
        sms.addCourse(new Course("C102", "Science"));
        sms.addCourse(new Course("C103", "History"));


        // GUI Components
        String[] studentColumns = {"ID", "Name", "Email"};
        studentTableModel = new DefaultTableModel(studentColumns, 0);
        studentTable = new JTable(studentTableModel);


        String[] detailsColumns = {"Course", "Grade"};
        detailsTableModel = new DefaultTableModel(detailsColumns, 0);
        detailsTable = new JTable(detailsTableModel);


        JButton addButton = new JButton("Add Student");
        JButton updateButton = new JButton("Update Student");
        JButton enrollButton = new JButton("Enroll in Course");
        JButton gradeButton = new JButton("Assign Grade");


        // Event Listeners
        addButton.addActionListener(e -> addStudentDialog());
        updateButton.addActionListener(e -> updateStudentDialog());
        enrollButton.addActionListener(e -> enrollStudentDialog());
        gradeButton.addActionListener(e -> assignGradeDialog());
        studentTable.getSelectionModel().addListSelectionListener(e -> displayStudentDetails());


        // Layout Setup
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(enrollButton);
        buttonPanel.add(gradeButton);


        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                new JScrollPane(studentTable), new JScrollPane(detailsTable));
        splitPane.setDividerLocation(200);


        frame.setLayout(new BorderLayout());
        frame.add(splitPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);


        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    private void addStudentDialog() {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();


        Object[] message = {"ID:", idField, "Name:", nameField, "Email:", emailField};


        int option = JOptionPane.showConfirmDialog(frame, message, "Add Student", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String email = emailField.getText();


                sms.addStudent(new Student(id, name, email)); // Add new student
                updateStudentTable();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "ID must be a number.");
            }
        }
    }


    private void updateStudentDialog() {
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Please select a student to update.");
            return;
        }


        int id = Integer.parseInt(studentTableModel.getValueAt(selectedRow, 0).toString());
        JTextField nameField = new JTextField(studentTableModel.getValueAt(selectedRow, 1).toString());
        JTextField emailField = new JTextField(studentTableModel.getValueAt(selectedRow, 2).toString());


        Object[] message = {"Name:", nameField, "Email:", emailField};


        int option = JOptionPane.showConfirmDialog(frame, message, "Update Student", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            sms.updateStudent(id, nameField.getText(), emailField.getText());
            updateStudentTable();
        }
    }


    private void enrollStudentDialog() {
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Please select a student to enroll.");
            return;
        }


        Student student = sms.getStudents().get(selectedRow);
        ArrayList<Course> courses = sms.getCourses();


        String[] courseOptions = courses.stream().map(Course::getName).toArray(String[]::new);
        String selectedCourse = (String) JOptionPane.showInputDialog(
                frame, "Select a course to enroll:", "Enroll in Course",
                JOptionPane.PLAIN_MESSAGE, null, courseOptions, courseOptions[0]
        );


        if (selectedCourse != null) {
            student.enrollInCourse(selectedCourse);
            updateDetailsTable(student);
            JOptionPane.showMessageDialog(frame, "Enrolled in course successfully!");
        }
    }


    private void assignGradeDialog() {
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Please select a student to assign a grade.");
            return;
        }


        Student student = sms.getStudents().get(selectedRow);
        String[] courseOptions = student.getGrades().keySet().toArray(new String[0]);
        String selectedCourse = (String) JOptionPane.showInputDialog(
                frame, "Select a course:", "Assign Grade",
                JOptionPane.PLAIN_MESSAGE, null, courseOptions, courseOptions[0]
        );


        if (selectedCourse != null) {
            JTextField gradeField = new JTextField();
            Object[] message = {"Grade:", gradeField};


            int option = JOptionPane.showConfirmDialog(frame, message, "Assign Grade", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                student.assignGrade(selectedCourse, gradeField.getText());
                updateDetailsTable(student);
                JOptionPane.showMessageDialog(frame, "Grade assigned successfully!");
            }
        }
    }


    private void displayStudentDetails() {
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow != -1) {
            Student student = sms.getStudents().get(selectedRow);
            updateDetailsTable(student);
        }
    }


    private void updateStudentTable() {
        studentTableModel.setRowCount(0);
        for (Student s : sms.getStudents()) {
            Object[] row = {s.getId(), s.getName(), s.getEmail()};
            studentTableModel.addRow(row);
        }
    }


    private void updateDetailsTable(Student student) {
        detailsTableModel.setRowCount(0);
        for (var entry : student.getGrades().entrySet()) {
            Object[] row = {entry.getKey(), entry.getValue()};
            detailsTableModel.addRow(row);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentManagementGUI::new);
    }
}
