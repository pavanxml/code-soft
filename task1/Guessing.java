import java.util.Scanner;

public class Guessing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the minimum value: ");
        int min = scanner.nextInt();

        System.out.print("Enter the maximum value: ");
        int max = scanner.nextInt();

        int secretNumber = (int) (Math.random() * (max - min + 1) + min); 
        int guess;

        System.out.println("I'm thinking of a number between " + min + " and " + max + ".");

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();

            if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > secretNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number!");
            }
        } while (guess != secretNumber);
    }
}