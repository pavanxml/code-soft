import java.util.Random;
import java.util.Scanner;

public class UserGuess {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound;
        int upperBound;

        
        while (true) {
            System.out.print("Enter the lower bound: ");
            if (scanner.hasNextInt()) {
                lowerBound = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }

        
        while (true) {
            System.out.print("Enter the upper bound: ");
            if (scanner.hasNextInt()) {
                upperBound = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }

        
        if (lowerBound > upperBound) {
            System.out.println("Invalid input. Lower bound must be less than or equal to the upper bound.");
            scanner.close();
            return;
        }

        
        int range = upperBound - lowerBound + 1;
        int randomNumber = random.nextInt(range) + lowerBound;

        System.out.println("I've chosen a number between " + lowerBound + " and " + upperBound + ".");


        
        int guess;
        while (true) {
            System.out.print("Enter your guess: ");
            if (scanner.hasNextInt()) {
                guess = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }

        System.out.println("You guessed: " + guess);
        System.out.println("The number was: " + randomNumber); 

        scanner.close();
    }
}
