// Import the Scanner class to enable reading input from the user
import java.util.Scanner;


// Main class to handle the Quiz Game
public class Quiz {


    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);


        // Array of questions to be asked in the quiz
        String[] questions = {
                // Each question includes the question text and four options (A, B, C, D)
                "1. Which country is the origin of sushi?\nA) Taiwan\nB) Japan\nC) Korea\nD) Singapore",
                "2. Which country has the largest semiconductor industry?\nA) Taiwan\nB) Japan\nC) Korea\nD) Singapore",
                "3. In which country is Mandarin the primary language?\nA) China\nB) Japan\nC) Korea\nD) Singapore",
                "4. Which infectious disease caused a global outbreak in March 2020?\nA) Flu\nB) Covid19\nC) Hand-Foot-Mouth disease\nD) HIV",
                "5. What is 100 divided by 10?\nA) 8\nB) 9\nC) 10\nD) 11"
        };


        // Array of correct answers corresponding to each question
        char[] correctAnswers = {'B', 'A', 'A', 'B', 'C'};


        // Variable to keep track of the user's score
        int score = 0;


        // Display a welcome message to the user
        System.out.println("Please answer each question by typing A, B, C, or D.");


        // Loop through each question in the quiz
        for (int i = 0; i < questions.length; i++) {
            // Display the current question
            System.out.println(questions[i]);


            // Prompt the user for their answer
            System.out.print("Your answer: ");
            // Read the user's input, take the first character, and convert it to uppercase
            char userAnswer = Character.toUpperCase(input.next().charAt(0));


            // Validate the user's input
            // Ensure the input is one of the valid options: A, B, C, or D
            while (userAnswer != 'A' && userAnswer != 'B' && userAnswer != 'C' && userAnswer != 'D') {
                System.out.println("Invalid input. Please enter A, B, C, or D.");
                System.out.print("Your answer: ");
                userAnswer = Character.toUpperCase(input.next().charAt(0));
            }


            // Check if the user's answer matches the correct answer
            if (userAnswer == correctAnswers[i]) {
                // Increment the score if the answer is correct
                score++;
                // Provide positive feedback
                System.out.println("Correct");
            } else {
                // Provide feedback for an incorrect answer and show the correct answer
                System.out.println("Wrong. The correct answer was " + correctAnswers[i]);
            }


            // Print a blank line for better readability between questions
            System.out.println();
        }


        // Calculate the total number of questions
        int totalQuestions = questions.length;


        // Calculate the user's score as a percentage
        double percentage = ((double) score / totalQuestions) * 100;


        // Display the user's final score and percentage
        System.out.println("You got " + score + " out of " + totalQuestions + " correct.");
        System.out.printf("Your score: %.2f%%\n", percentage);


        // Close the Scanner to release resources
        input.close();
    }
}
