package in.srikar;

import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
	public static void main(String[] args) {
		playGame();
	}

	public static void playGame() {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int totalScore = 0;
		final int MAX_ROUNDS = 3;
		final int MAX_ATTEMPTS = 5;

		for (int round = 0; round < MAX_ROUNDS; round++) {
			System.out.println("Round " + (round + 1) + ":");
			int randomNumber = random.nextInt(100) + 1;
			int roundScore = guessNumber(randomNumber, scanner, MAX_ATTEMPTS);
			totalScore += roundScore;
		}

		System.out.println("Game over!\nYour total score: " + totalScore);
		scanner.close();
	}

	public static int guessNumber(int randomNumber, Scanner scanner, int maxAttempts) {
		int attempts = 0;
		while (attempts < maxAttempts) {
			System.out.print("Guess the number (between 1 and 100): ");
			int userGuess = scanner.nextInt();
			attempts++;

			if (userGuess == randomNumber) {
				System.out.println("Congratulations! You guessed the number!");
				return (maxAttempts - attempts + 1); // giving points based on the number of attempts
			} else if (userGuess < randomNumber) {
				System.out.println("Too low! Try again.");
			} else {
				System.out.println("Too high! Try again.");
			}
		}
		System.out.println("Sorry, you couldn't guess the number. The correct number was: " + randomNumber);
		return 0; // no points if user couldn't guess the number
	}
}
