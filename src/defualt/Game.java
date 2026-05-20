/**
 * Lead Author(s):
 * 
 * @author simaqambari
 * @author
 * 
 *
 * 
 *         References:
 *         Morelli, R., & Walde, R. (2016).
 *         Java, Java, Java: Object-Oriented Problem Solving
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 * 
 *
 *         Version: 2026-05-11
 */
package defualt;

import java.util.Scanner;

/**
 * Purpose: This class starts the Tic-Tac-Toe program and lets the user choose
 * whether to play in console mode or GUI mode.
 *
 * Game is the main starting point of the program.
 */
public class Game
{
	public static void main(String[] args)
	{
		// The controller handles the game logic after the program starts.
		GameController controller = new GameController();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to Tic-Tac-Toe!");
		System.out.println("Enter 1 for console mode or 2 for GUI mode:");

		// Read the user's choice from the keyboard.
		int choice = scanner.nextInt();

		if (choice == 1)
		{
			// If the user enters 1, run the text version of the game.
			controller.playConsoleGame(scanner);
			scanner.close();
		}
		else
		{
			// Ask whether the GUI should be two-player or play against the AI.
			System.out.println("Enter 1 for two-player GUI or 2 for AI GUI:");
			int guiChoice = scanner.nextInt();
			scanner.close();
			controller.startGuiGame(guiChoice == 2);
		}
	}
}
