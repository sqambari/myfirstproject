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

import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Purpose: This class manages the flow of the game. It takes input from the
 * player, updates the model, and tells the view what to display.
 *
 * GameController connects the model and the view.
 */
public class GameController
{
	// This object stores the board and the main game rules.
	private GameModel game;

	// This object creates and updates the game window.
	private GameView view;

	// This keeps track of wins and draws across rounds.
	private ScoreManager scoreManager;

	// This handles saving and loading score data.
	private FileManager fileManager;

	// These objects store information about the human and computer players.
	private Player playerX;
	private Player playerO;

	// This object chooses moves for the computer player.
	private AIPlayer aiPlayer;

	// This decides whether the GUI uses the computer player.
	private boolean playAgainstAi;

	// This is the file name used when scores are saved.
	private static final String SCORE_FILE = "scores.txt";

	// The constructor creates the objects the controller needs.
	public GameController()
	{
		game = new GameModel();
		scoreManager = new ScoreManager();
		fileManager = new FileManager();
		playerX = new Player("Player X", 'X');
		playerO = new Player("Player O", 'O');
		aiPlayer = new AIPlayer("Easy");
		playAgainstAi = false;
	}

	public void playConsoleGame(Scanner scanner)
	{
		// A blank space means nobody has won yet.
		char winner = ' ';

		// Keep asking for moves until there is a winner or the board fills up.
		while (winner == ' ' && !game.isBoardFull())
		{
			displayBoard();
			System.out.println("Player " + game.getCurrentPlayer()
					+ ", enter row (0-2): ");

			// Read the row chosen by the current player.
			int row = scanner.nextInt();

			System.out.println("Player " + game.getCurrentPlayer()
					+ ", enter column (0-2): ");

			// Read the column chosen by the current player.
			int col = scanner.nextInt();

			if (game.placeMark(row, col))
			{
				// After the move is placed, check if it ended the game.
				winner = game.checkWinner();

				if (winner == ' ' && !game.isBoardFull())
				{
					// Only switch turns if the game is still continuing.
					game.switchTurn();
				}
			}
			else
			{
				// Show a message if the selected move could not be used.
				System.out.println("That move is not valid. Try again.");
			}
		}

		// Print the board one last time after the round is over.
		displayBoard();

		if (winner != ' ')
		{
			scoreManager.recordWin(winner);
			System.out.println("Winner is: " + winner);
		}
		else
		{
			scoreManager.recordDraw();
			System.out.println("It's a draw.");
		}

		System.out.println(scoreManager.getScoreText());
	}

	public void startGuiGame(boolean playAgainstAi)
	{
		// Remember whether this GUI round is two-player or against the
		// computer.
		this.playAgainstAi = playAgainstAi;

		if (playAgainstAi)
		{
			playerO = new Player("Computer O", 'O');
		}
		else
		{
			playerO = new Player("Player O", 'O');
		}

		// Create the GUI window.
		view = new GameView();

		// Connect each square on the board to its row and column position.
		for (int row = 0; row < 3; row++)
		{
			for (int col = 0; col < 3; col++)
			{
				final int currentRow = row;
				final int currentCol = col;
				view.getButtons()[row][col].addActionListener(
						event -> handleGuiMove(currentRow, currentCol));
			}
		}

		// Connect the buttons at the bottom of the window.
		view.getResetButton().addActionListener(event -> resetGuiGame());
		view.getSaveButton().addActionListener(event -> saveScores());
		view.getLoadButton().addActionListener(event -> loadScores());

		// Show the beginning board, turn message, and current score.
		view.updateBoard(game.getBoard());
		view.updateStatus(getCurrentPlayerName() + "'s turn");
		view.updateScore(scoreManager.getScoreText());
	}

	private void handleGuiMove(int row, int col)
	{
		// Stop here if the player clicked a square that is already taken.
		if (!game.placeMark(row, col))
		{
			JOptionPane.showMessageDialog(view,
					"That square is not available.");
			return;
		}

		// Refresh the board after the human move is placed.
		view.updateBoard(game.getBoard());
		char winner = game.checkWinner();

		if (winner != ' ')
		{
			scoreManager.recordWin(winner);
			// If the human wins here, update the score and stop the turn.
			view.updateStatus(getPlayerNameFromSymbol(winner) + " wins!");
			view.updateScore(scoreManager.getScoreText());
			JOptionPane.showMessageDialog(view,
					getPlayerNameFromSymbol(winner) + " wins!");
			return;
		}

		if (game.isBoardFull())
		{
			scoreManager.recordDraw();
			// If the board filled up with no winner, the round is a draw.
			view.updateStatus("It's a draw!");
			view.updateScore(scoreManager.getScoreText());
			JOptionPane.showMessageDialog(view, "It's a draw!");
			return;
		}

		// Switch to the next turn.
		game.switchTurn();
		view.updateStatus(getCurrentPlayerName() + "'s turn");

		if (playAgainstAi)
		{
			makeAiMove();
		}
	}

	private void resetGuiGame()
	{
		// Start a fresh round and update everything shown in the window.
		game.resetBoard();
		view.updateBoard(game.getBoard());
		view.updateStatus(getCurrentPlayerName() + "'s turn");
		view.updateScore(scoreManager.getScoreText());
	}

	private String getCurrentPlayerName()
	{
		// Match the current symbol in the model to the correct player's name.
		if (game.getCurrentPlayer() == playerX.getSymbol())
		{
			return playerX.getName();
		}
		return playerO.getName();
	}

	private void saveScores()
	{
		try
		{
			// Save the current score numbers to the text file.
			fileManager.saveScores(scoreManager, SCORE_FILE);
			JOptionPane.showMessageDialog(view,
					"Scores saved to " + SCORE_FILE);
		}
		catch (FileNotFoundException exception)
		{
			// Show a message if the file could not be written.
			JOptionPane.showMessageDialog(view,
					"Could not save the score file.");
		}
	}

	private void makeAiMove()
	{
		// Let the computer pick an open square.
		Move aiMove = aiPlayer.chooseMove(game.getBoard());

		if (aiMove == null)
		{
			return;
		}

		// Put the computer's move onto the board and refresh the GUI.
		game.placeMark(aiMove.getRow(), aiMove.getCol());
		view.updateBoard(game.getBoard());

		char winner = game.checkWinner();

		if (winner != ' ')
		{
			scoreManager.recordWin(winner);
			view.updateStatus(getPlayerNameFromSymbol(winner) + " wins!");
			view.updateScore(scoreManager.getScoreText());
			JOptionPane.showMessageDialog(view,
					getPlayerNameFromSymbol(winner) + " wins!");
			return;
		}

		if (game.isBoardFull())
		{
			scoreManager.recordDraw();
			view.updateStatus("It's a draw!");
			view.updateScore(scoreManager.getScoreText());
			JOptionPane.showMessageDialog(view, "It's a draw!");
			return;
		}

		// If the round continues, switch the turn back to the human.
		game.switchTurn();
		view.updateStatus(getCurrentPlayerName() + "'s turn");
	}

	private void loadScores()
	{
		try
		{
			// Read the saved score values from the text file.
			int[] loadedScores = fileManager.loadScores(SCORE_FILE);
			scoreManager.setScores(loadedScores[0], loadedScores[1],
					loadedScores[2]);
			view.updateScore(scoreManager.getScoreText());
			JOptionPane.showMessageDialog(view,
					"Scores loaded from " + SCORE_FILE);
		}
		catch (FileNotFoundException exception)
		{
			// Show a message if the score file cannot be found.
			JOptionPane.showMessageDialog(view, "Could not find " + SCORE_FILE);
		}
	}

	private String getPlayerNameFromSymbol(char symbol)
	{
		// Return the correct name based on whether the symbol is X or O.
		if (symbol == playerX.getSymbol())
		{
			return playerX.getName();
		}
		return playerO.getName();
	}

	public void displayBoard()
	{
		// Get the current board and print it in a simple text layout.
		char[][] board = game.getBoard();

		for (int i = 0; i < 3; i++)
		{
			System.out.println(
					board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
			if (i < 2)
			{
				System.out.println("--+---+--");
			}
		}

		// Leave a blank line after the board so the console is easier to read.
		System.out.println();
	}
}
