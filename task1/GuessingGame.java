import java.util.Random;
import java.util.Scanner;

public class GuessingGame{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lowerBound;
        int upperBound;

        
        System.out.print("Enter the lower bound: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); 
        }
        lowerBound = scanner.nextInt();

        
        System.out.print("Enter the upper bound: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next();
        }
        upperBound = scanner.nextInt();

        
        if (lowerBound > upperBound) {
            System.out.println("Invalid input. Lower bound must be less than or equal to the upper bound.");
            scanner.close();
            return; 
        }

        Random random = new Random();
        int range = upperBound - lowerBound + 1;
        int randomNumber = random.nextInt(range) + lowerBound;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I've chosen a number between " + lowerBound + " and " + upperBound + ". Try to guess it.");

        int guess;
        int numGuesses = 0;

        do {
            System.out.print("Enter your guess: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
            guess = scanner.nextInt();
            numGuesses++;

            if (guess < randomNumber) {
                System.out.println("Too low!");
            } else if (guess > randomNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the number in " + numGuesses + " tries.");
            }
        } while (guess != randomNumber);

        scanner.close();
    }
}