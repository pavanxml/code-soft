import java.util.Scanner;

public class StudentGradeCaluculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of subjects
        System.out.print("Enter the number of subjects: ");
        int subjects = scanner.nextInt();

        // Input: Marks obtained in each subject
        double[] marks = new double[subjects];
        double totalMarks = 0;

        for (int i = 0; i < subjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextDouble();
            totalMarks += marks[i];
        }

        // Calculate Average Percentage
        double averagePercentage = totalMarks / subjects;

        // Grade Calculation
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        // Display Results
        System.out.println("\n--- Results ---");
        System.out.printf("Total Marks: %.2f%n", totalMarks);
        System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}

    

