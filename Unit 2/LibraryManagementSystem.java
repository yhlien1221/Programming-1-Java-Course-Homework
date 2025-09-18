import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;


public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Initialize book titles, authors, and quantities using ArrayLists
        ArrayList<String> books = new ArrayList<>(Arrays.asList(
                "A TALE OF TWO CITIES",
                "THE LITTLE PRINCE",
                "THE ALCHEMIST",
                "HARRY POTTER AND THE PHILOSOPHER'S STONE",
                "AND THEN THERE WERE NONE"
        ));


        ArrayList<String> authors = new ArrayList<>(Arrays.asList(
                "AUTHOR A",
                "AUTHOR B",
                "AUTHOR C",
                "AUTHOR D",
                "AUTHOR E"
        ));


        ArrayList<Integer> NumberOfBooks = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));


        Scanner input = new Scanner(System.in);
        boolean running = true; // A flag to keep the program running


        while (running) { // Loop until the user chooses to exit
            // Display the main menu options
            System.out.println("\nWhich service would you like to use today? Please enter \"A\", \"B\", \"R\", \"E\"");
            System.out.println("A: Add books, B: Borrow books, R: Return books, E: Exit");
            System.out.print("Your answer: ");
            char userAnswer = Character.toUpperCase(input.next().charAt(0)); // Read and normalize user input


            switch (userAnswer) {
                case 'A': // Add Books
                    System.out.println("Please enter the book title:");
                    input.nextLine(); // Clear the input buffer
                    String title = input.nextLine().toUpperCase(); // Convert title to uppercase for consistency


                    if (books.contains(title)) { // Check if the book already exists
                        int index = books.indexOf(title); // Find the index of the book
                        NumberOfBooks.set(index, NumberOfBooks.get(index) + 1); // Update the quantity
                        System.out.println("The book already exists in the library.");
                        System.out.println("Updated quantity of the book: " + NumberOfBooks.get(index));
                    } else { // Add a new book to the library
                        books.add(title); // Add the book title
                        System.out.println("Please enter the author of the book:");
                        String author = input.nextLine().toUpperCase(); // Convert author to uppercase
                        authors.add(author); // Add the author
                        System.out.println("Please enter the quantity of the book:");
                        try {
                            int quantity = input.nextInt(); // Read the quantity
                            NumberOfBooks.add(quantity); // Add the quantity
                            System.out.println("New book added to the library.");
                        } catch (InputMismatchException e) { // Handle invalid quantity input
                            System.out.println("Invalid quantity. The book was not added.");
                            input.nextLine(); // Clear invalid input
                        }
                    }
                    break;


                case 'B': // Borrow Books
                    System.out.println("Please enter the book title you would like to borrow:");
                    input.nextLine(); // Clear the input buffer
                    String borrowTitle = input.nextLine().toUpperCase(); // Convert title to uppercase


                    if (!books.contains(borrowTitle)) { // Check if the book exists
                        System.out.println("The book \"" + borrowTitle + "\" is not available in the library.");
                    } else {
                        int index = books.indexOf(borrowTitle); // Find the index of the book
                        System.out.println("Please enter the quantity of the book you would like to borrow:");
                        try {
                            int borrowQuantity = input.nextInt(); // Read the borrow quantity
                            if (borrowQuantity > NumberOfBooks.get(index)) { // Check availability
                                System.out.println("Sorry, not enough copies are available. Only " + NumberOfBooks.get(index) + " copies left.");
                            } else {
                                NumberOfBooks.set(index, NumberOfBooks.get(index) - borrowQuantity); // Update the quantity
                                System.out.println("Borrowing successful! Updated quantity of \"" + borrowTitle + "\": " + NumberOfBooks.get(index));
                            }
                        } catch (InputMismatchException e) { // Handle invalid input
                            System.out.println("Invalid input. Please enter a numeric value.");
                            input.nextLine(); // Clear invalid input
                        }
                    }
                    break;


                case 'R': // Return Books
                    System.out.println("Please enter the book title you would like to return:");
                    input.nextLine(); // Clear the input buffer
                    String returnTitle = input.nextLine().toUpperCase(); // Convert title to uppercase


                    if (!books.contains(returnTitle)) { // Check if the book belongs to the library
                        System.out.println("The book \"" + returnTitle + "\" does not belong to our library.");
                    } else {
                        int index = books.indexOf(returnTitle); // Find the index of the book
                        System.out.println("Please enter the quantity of the book you would like to return:");
                        try {
                            int returnQuantity = input.nextInt(); // Read the return quantity
                            System.out.println("Would you like to return the book? Please answer Y or N:");
                            char returnBook = Character.toUpperCase(input.next().charAt(0)); // Confirm return


                            if (returnBook == 'Y') { // If user confirms
                                NumberOfBooks.set(index, NumberOfBooks.get(index) + returnQuantity); // Update the quantity
                                System.out.println("Return successful! Updated quantity of \"" + returnTitle + "\": " + NumberOfBooks.get(index));
                            } else {
                                System.out.println("Return cancelled.");
                            }
                        } catch (InputMismatchException e) { // Handle invalid input
                            System.out.println("Invalid input. Please enter a numeric value.");
                            input.nextLine(); // Clear invalid input
                        }
                    }
                    break;


                case 'E': // Exit
                    System.out.println("Exiting the library system. Have a great day!");
                    running = false; // Stop the loop
                    break;


                default: // Invalid Option
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }


        input.close(); // Close the scanner to release resources
    }
}
