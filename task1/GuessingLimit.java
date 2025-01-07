import java.util.Scanner;

public class GuessingLimit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the minimum value: ");
        int min = scanner.nextInt();

        System.out.print("Enter the maximum value: ");
        int max = scanner.nextInt();

        System.out.print("Enter the number of limited attempts: ");
        int maxAttempts = scanner.nextInt();

        int secretNumber = (int) (Math.random() * (max - min + 1) + min); 
        int guess;
        int attempts = 0;

        System.out.println("I'm thinking of a number between " + min + " and " + max + ".");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < secretNumber) {
                System.out.println("Too low! " + (maxAttempts - attempts) + " attempts remaining.");
            } else if (guess > secretNumber) {
                System.out.println("Too high! " + (maxAttempts - attempts) + " attempts remaining.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break; // Exit the loop if the guess is correct
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've run out of attempts. The number was: " + secretNumber);
        }

        scanner.close(); 
    }
}