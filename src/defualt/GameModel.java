/**
 * Lead Author(s):
 * 
 * @author simaqambari; student ID
 * @author Full name; student ID
 *         <<Add additional lead authors here>>
 *
 *         Other Contributors:
 *         Full name; student ID or contact information if not in class
 *         <<Add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 *
 *         References:
 *         Morelli, R., & Walde, R. (2016).
 *         Java, Java, Java: Object-Oriented Problem Solving
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 *         <<Add more references here>>
 *
 *         Version: 2026-05-04
 */
package defualt;

/**
 * Purpose: This class stores the board and handles the main Tic-Tac-Toe rules,
 * such as placing marks, switching turns, checking for a winner, and checking
 * for a draw.
 *
 * GameModel represents the game data.
 */
public class GameModel
{
	// This 3x3 array stores the board.
	private char[][] board;

	// This keeps track of whose turn it is.
	private char currentPlayer;

	public GameModel()
	{
		// Set up a new board and let X take the first turn.
		board = new char[3][3];
		currentPlayer = 'X';
		resetBoard();

	}

	/**
	 * Fills the board with blank spaces for a new round.
	 */
	public void resetBoard()
	{
		// Go through every square and clear it.
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				board[i][j] = ' ';

			}
		}
	}

	public char getCurrentPlayer()
	{
		// Return the symbol of the player whose turn it is.
		return currentPlayer;
	}

	public Boolean placeMark(int row, int col)
	{
		// Reject any move that is outside the board.
		if (row < 0 || row > 2 || col < 0 || col > 2)
		{
			return false;
		}

		// Only place the mark if the square is still empty.
		if (board[row][col] == ' ')
		{
			board[row][col] = currentPlayer;

			return true;
		}
		return false;

	}

	public void switchTurn()
	{
		// Change the turn from X to O or from O to X.
		currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	}

	public char checkWinner()
	{
		// Check rows to see if any row has three matching marks.
		for (int i = 0; i < 3; i++)
		{
			if (board[i][0] != ' ' && board[i][0] == board[i][1]
					&& board[i][1] == board[i][2])
			{
				return board[i][0];
			}
		}

		// Check columns to see if any column has three matching marks.
		for (int j = 0; j < 3; j++)
		{
			if (board[0][j] != ' ' && board[0][j] == board[1][j]
					&& board[1][j] == board[2][j])
			{
				return board[0][j];
			}
		}

		// Check the diagonal from top-left to bottom-right.
		if (board[0][0] != ' ' && board[0][0] == board[1][1]
				&& board[1][1] == board[2][2])
		{
			return board[0][0];
		}

		// Check the diagonal from top-right to bottom-left.
		if (board[0][2] != ' ' && board[0][2] == board[1][1]
				&& board[1][1] == board[2][0])
		{
			return board[0][2];
		}

		return ' ';
	}

	public char[][] getBoard()
	{
		// Return a copy so other classes do not change the real board by mistake.
		char[][] boardCopy = new char[3][3];

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				boardCopy[i][j] = board[i][j];
			}
		}

		return boardCopy;
	}

	public boolean isBoardFull()
	{
		// If one blank space is found, the board is not full yet.
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (board[i][j] == ' ')
				{
					return false;
				}
			}
		}
		return true;
	}

}
