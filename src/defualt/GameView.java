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

/**
 * Purpose: This class creates the graphical window for the game. It displays
 * the board, the turn message, the score, and the buttons used by the player.
 *
 * GameView represents the GUI part of the program.
 */

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameView extends JFrame
{
	// These buttons make up the 3x3 Tic-Tac-Toe board.
	private JButton[][] buttons;

	// This label shows whose turn it is or how the round ended.
	private JLabel statusLabel;

	// This label shows the current score totals.
	private JLabel scoreLabel;

	// This button resets the current round.
	private JButton resetButton;

	// This button saves the score to a text file.
	private JButton saveButton;

	// This button loads the score from a text file.
	private JButton loadButton;

	public GameView()
	{
		// Set the title shown at the top of the window.
		setTitle("Tic Tac Toe");
		
		// Set the size of the window.
		setSize(400, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Create the label that shows the current turn or result.
		statusLabel = new JLabel("Player X's turn", SwingConstants.CENTER);
		statusLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(statusLabel, BorderLayout.NORTH);

		scoreLabel = new JLabel("X Wins: 0 | O Wins: 0 | Draws: 0",
				SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Arial", Font.PLAIN, 16));

		// Create the panel that will hold the game board.
		JPanel boardPanel = new JPanel(new GridLayout(3, 3));
		buttons = new JButton[3][3];

		for (int row = 0; row < 3; row++)
		{
			for (int col = 0; col < 3; col++)
			{
				// Create one button for each board square.
				buttons[row][col] = new JButton("");
				buttons[row][col].setFont(new Font("Arial", Font.BOLD, 40));
				boardPanel.add(buttons[row][col]);
			}
		}

		// Use one middle panel to keep the score and board together.
		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.add(scoreLabel, BorderLayout.NORTH);
		centerPanel.add(boardPanel, BorderLayout.CENTER);

		// Place that panel in the center of the window.
		add(centerPanel, BorderLayout.CENTER);

		// Create the buttons shown at the bottom of the window.
		resetButton = new JButton("Reset Game");
		saveButton = new JButton("Save Score");
		loadButton = new JButton("Load Score");

		JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
		bottomPanel.add(resetButton);
		bottomPanel.add(saveButton);
		bottomPanel.add(loadButton);
		add(bottomPanel, BorderLayout.SOUTH);

		// Make the finished window visible to the user.
		setVisible(true);
	}

	public JButton[][] getButtons()
	{
		// Let the controller work with the board buttons.
		return buttons;
	}

	public JButton getResetButton()
	{
		// Let the controller use the reset button.
		return resetButton;
	}

	public JButton getSaveButton()
	{
		// Let the controller use the save button.
		return saveButton;
	}

	public JButton getLoadButton()
	{
		// Let the controller use the load button.
		return loadButton;
	}

	public void updateBoard(char[][] board)
	{
		// Update each button so the screen matches the board in the model.
		for (int row = 0; row < 3; row++)
		{
			for (int col = 0; col < 3; col++)
			{
				if (board[row][col] == ' ')
				{
					// Empty squares should show no text.
					buttons[row][col].setText("");
				}
				else
				{
					// Filled squares should show X or O.
					buttons[row][col]
							.setText(String.valueOf(board[row][col]));
				}
			}
		}
	}

	public void updateStatus(String message)
	{
		// Update the message at the top of the window.
		statusLabel.setText(message);
	}

	public void updateScore(String message)
	{
		// Update the score label in the window.
		scoreLabel.setText(message);
	}
}
