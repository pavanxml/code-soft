import java.util.Scanner;

public class UserScore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int totalRounds = 0;
        int roundsWon = 0;
        int totalAttempts = 0; 

        while (playAgain) {
            totalRounds++;

            System.out.print("Enter the minimum value: ");
            int min = scanner.nextInt();

            System.out.print("Enter the maximum value: ");
            int max = scanner.nextInt();

            System.out.print("Enter the number of attempts: ");
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
                    roundsWon++;
                    totalAttempts += attempts; 
                    break; 
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The number was: " + secretNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        scanner.close();

        System.out.println("\nGame Summary:");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Total Attempts: " + totalAttempts); 

        if (roundsWon > 0) {
            double averageAttempts = (double) totalAttempts / roundsWon;
            System.out.printf("Average Attempts per Round: %.2f\n", averageAttempts);
        }

        if (totalRounds > 0) {
            double winPercentage = (double) roundsWon / totalRounds * 100;
            System.out.printf("Win Percentage: %.2f%%\n", winPercentage);
        } 
    }
}