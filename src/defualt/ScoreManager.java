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
 *         Version: 2026-05-19
 */
package defualt;

/**
 * Purpose: The reponsibility of ScoreManager is ...
 *
 * ScoreManager is-a ...
 * ScoreManager is ...
 */
public class ScoreManager
{
	// Stores how many times player X has won.
	private int xWins;

	// Stores how many times player O has won.
	private int oWins;

	// Stores how many games ended in a draw.
	private int draws;

	/**
	 * Adds one win to the correct player.
	 * 
	 * @param winner the winner symbol
	 */
	public void recordWin(char winner)
	{
		if (winner == 'X')
		{
			xWins++;
		}
		else if (winner == 'O')
		{
			oWins++;
		}
	}

	/**
	 * Adds one draw to the draw count.
	 */
	public void recordDraw()
	{
		draws++;
	}

	/**
	 * Resets every score back to zero.
	 */
	public void resetScores()
	{
		xWins = 0;
		oWins = 0;
		draws = 0;
	}

	/**
	 * Sets all score values at once. This is useful when loading scores from a
	 * file.
	 * 
	 * @param xWins the loaded X win total
	 * @param oWins the loaded O win total
	 * @param draws the loaded draw total
	 */
	public void setScores(int xWins, int oWins, int draws)
	{
		this.xWins = xWins;
		this.oWins = oWins;
		this.draws = draws;
	}

	/**
	 * Returns the X win total.
	 * 
	 * @return X wins
	 */
	public int getXWins()
	{
		return xWins;
	}

	/**
	 * Returns the O win total.
	 * 
	 * @return O wins
	 */
	public int getOWins()
	{
		return oWins;
	}

	/**
	 * Returns the draw total.
	 * 
	 * @return draw count
	 */
	public int getDraws()
	{
		return draws;
	}

	/**
	 * Returns a score message that can be shown in the console or GUI.
	 * 
	 * @return score text
	 */
	public String getScoreText()
	{
		return "X Wins: " + xWins + " | O Wins: " + oWins + " | Draws: "
				+ draws;
	}

}
