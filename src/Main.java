import java.util.Random;
import java.util.Scanner;

public class Main {
    static final String[] OPTIONS = {"rock", "paper", "scissors"};

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Random rnd = new Random(System.currentTimeMillis()); // seed changes each run
            int userScore = 0, compScore = 0, ties = 0;
            System.out.println("Welcome to Rock-Paper-Scissors!");
            System.out.println("Type 'exit' anytime to quit.");
            while (true) {
                System.out.print("\nEnter your choice (Rock / Paper / Scissors): ");
                String user = sc.nextLine().trim().toLowerCase();
                
                if (user.equals("exit")) break;
                if (!isValid(user)) {
                    System.out.println("Invalid choice. Try again.");
                    continue;
                }
                
                String comp = OPTIONS[rnd.nextInt(OPTIONS.length)];
                System.out.println("Computer chose: " + capitalize(comp));
                
                int result = compare(user, comp);
                
                switch (result) {
                    case 1:
                        System.out.println("You win!");
                        userScore++;
                        break;
                    case -1:
                        System.out.println("Computer wins!");
                        compScore++;
                        break;
                    default:
                        System.out.println("It's a tie.");
                        ties++;
                        break;
                }
                
                System.out.println("Score → You: " + userScore + " | Computer: " + compScore + " | Ties: " + ties);
            }   System.out.println("\nFinal Results:");
            System.out.println("You: " + userScore);
            System.out.println("Computer: " + compScore);
            System.out.println("Ties: " + ties);
        } // seed changes each run
    }

    static boolean isValid(String s) {
        return s.equals("rock") || s.equals("paper") || s.equals("scissors");
    }

    static int compare(String user, String comp) {
        if (user.equals(comp)) return 0;
        if (user.equals("rock") && comp.equals("scissors")) return 1;
        if (user.equals("scissors") && comp.equals("paper")) return 1;
        if (user.equals("paper") && comp.equals("rock")) return 1;
        return -1;
    }

    static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
