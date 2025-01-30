package task4;

    import java.util.*;

class Quiz {
    private static class Question {
        String question;
        String[] options;
        int correctOption;

        Question(String question, String[] options, int correctOption) {
            this.question = question;
            this.options = options;
            this.correctOption = correctOption;
        }
    }

    private static List<Question> questions = new ArrayList<>();
    private static int score = 0;
    private static final int TIME_LIMIT = 10; // 10 seconds per question

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loadQuestions();
        System.out.println("Welcome to the Quiz!");
        
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + q.question);
            
            for (int j = 0; j < q.options.length; j++) {
                System.out.println((j + 1) + ". " + q.options[j]);
            }

            System.out.print("Enter your choice (1-4) within " + TIME_LIMIT + " seconds: ");
            int userChoice = getUserInput(scanner, TIME_LIMIT);

            if (userChoice == q.correctOption) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + q.correctOption);
            }
        }

        System.out.println("\nQuiz Over! Your final score: " + score + "/" + questions.size());
        scanner.close();
    }

    private static void loadQuestions() {
        questions.add(new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 3));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Venus"}, 2));
        questions.add(new Question("Who wrote 'To Kill a Mockingbird'?", new String[]{"Harper Lee", "J.K. Rowling", "Mark Twain", "Jane Austen"}, 1));
    }

    private static int getUserInput(Scanner scanner, int timeLimit) {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < timeLimit * 1000) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
        }
        System.out.println("\nTime's up! Moving to the next question.");
        return -1; // Indicating no valid answer was given
    }
}


