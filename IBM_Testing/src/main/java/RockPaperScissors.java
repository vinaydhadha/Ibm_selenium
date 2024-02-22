import java.io.Console;

public class RockPaperScissors {

    public static void main(String[] args) {
        // Display welcome message
        System.out.println("Welcome to Secure Two-Player Rock, Paper, Scissors game!");

        // Use Console for player input
        Console console = System.console();
        if (console == null) {
            System.out.println("Console not available. Exiting...");
            return;
        }

        // Play the game in a loop
        while (true) {
            playGame(console);

            // Ask if players want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = console.readLine();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break; // Exit the loop if the players don't want to play again
            }
        }
    }

    private static void playGame(Console console) {
        // Prompt player 1 for their choice (secure input)
        char[] player1Password = console.readPassword("Player 1, enter your choice (Rock, Paper, or Scissors): ");
        String player1Choice = new String(player1Password);

        // Validate player 1 input
        if (!isValidChoice(player1Choice)) {
            System.out.println("Invalid choice. Please enter Rock, Paper, or Scissors.");
            return;
        }

        // Prompt player 2 for their choice (secure input)
        char[] player2Password = console.readPassword("Player 2, enter your choice (Rock, Paper, or Scissors): ");
        String player2Choice = new String(player2Password);

        // Validate player 2 input
        if (!isValidChoice(player2Choice)) {
            System.out.println("Invalid choice. Please enter Rock, Paper, or Scissors.");
            return;
        }

        // Display choices
        System.out.println("Player 1's choice: " + player1Choice);
        System.out.println("Player 2's choice: " + player2Choice);

        // Determine the winner
        determineWinner(player1Choice, player2Choice);
    }

    private static boolean isValidChoice(String choice) {
        return choice.equalsIgnoreCase("Rock") || choice.equalsIgnoreCase("Paper") || choice.equalsIgnoreCase("Scissors");
    }

    private static void determineWinner(String player1Choice, String player2Choice) {
        if (player1Choice.equalsIgnoreCase(player2Choice)) {
            System.out.println("It's a tie!");
        } else if (
                (player1Choice.equalsIgnoreCase("Rock") && player2Choice.equalsIgnoreCase("Scissors")) ||
                        (player1Choice.equalsIgnoreCase("Paper") && player2Choice.equalsIgnoreCase("Rock")) ||
                        (player1Choice.equalsIgnoreCase("Scissors") && player2Choice.equalsIgnoreCase("Paper"))
        ) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }
}
