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
 *         Version: 2026-05-19
 */
package defualt;

/**
 * Purpose: The reponsibility of AIPlayer is ...
 *
 * AIPlayer is-a ...
 * AIPlayer is ...
 */
public class AIPlayer
{
	// Stores the AI difficulty level as text.
	private String difficulty;

	/**
	 * Creates an AI player difficulty setting.
	 * 
	 * @param difficulty the AI difficulty
	 */
	public AIPlayer(String difficulty)
	{
		this.difficulty = difficulty;
	}

	/**
	 * Returns the AI difficulty.
	 * 
	 * @return difficulty text
	 */
	public String getDifficulty()
	{
		return difficulty;
	}

	/**
	 * Chooses the first open position on the board.
	 * 
	 * @param board the current board
	 * @return a move for the AI, or null if no spaces are open
	 */
	public Move chooseMove(char[][] board)
	{
		for (int row = 0; row < 3; row++)
		{
			for (int col = 0; col < 3; col++)
			{
				if (board[row][col] == ' ')
				{
					return new Move(row, col, 'O');
				}
			}
		}
		return null;
	}

}
