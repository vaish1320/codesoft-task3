import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class third {
    private static int score = 0;
    private static Timer timer = new Timer();
    private static boolean isAnswered = false;

    public static void main(String[] args) {
        System.out.println("Welcome to the Simple Quiz!");

        // timer for 10 seconds
        timer.schedule(new TimerTask() {
           
            public void run() {
                if (!isAnswered) {
                    System.out.println("\nTime's up! Quiz over.");
                    displayResult();
                    System.exit(0);
                }
            }
        }, 10000);

        // Question 1
        presentQuestion("What is the capital of Italy?", "A. Paris", "B. Madrid", "C. Rome", "C");

        // Question 2
        presentQuestion("Which planet is known as the Red Planet?", "A. Earth", "B. Mars", "C. Venus", "B");

        // Question 3
        presentQuestion("Who wrote 'Romeo and Juliet'?", "A. William Shakespeare", "B. Jane Austen", "C. Charles Dickens", "A");

        //  result
        displayResult();
    }

    private static void presentQuestion(String question, String optionA, String optionB, String optionC, String correctAnswer) {
        
        System.out.println("\nQuestion: " + question);
        System.out.println(optionA);
        System.out.println(optionB);
        System.out.println(optionC);
        System.out.print("Your choice (A, B, or C): ");

        // user input
        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine().toUpperCase();

        // Check the answer
        checkAnswer(userChoice, correctAnswer);
        scanner.close();
    }

    private static void checkAnswer(String userChoice, String correctAnswer) {
        isAnswered = true;
        if (userChoice.equals(correctAnswer)) {
            System.out.println("Correct! +1 point");
            score++;
        } else {
            System.out.println("Incorrect! The correct answer is " + correctAnswer);
        }
    }

    private static void displayResult() {
        System.out.println("\nYour final score: " + score);
    }
}
