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
 * Purpose: The reponsibility of Move is ...
 *
 * Move is-a ...
 * Move is ...
 */
public class Move
{
	// Stores the row where the move was made.
	private int row;

	// Stores the column where the move was made.
	private int col;

	// Stores the symbol used for the move.
	private char symbol;

	/**
	 * Creates one move object.
	 * 
	 * @param row    the row of the move
	 * @param col    the column of the move
	 * @param symbol the player's symbol
	 */
	public Move(int row, int col, char symbol)
	{
		this.row = row;
		this.col = col;
		this.symbol = symbol;
	}

	/**
	 * Returns the row of the move.
	 * 
	 * @return row number
	 */
	public int getRow()
	{
		return row;
	}

	/**
	 * Returns the column of the move.
	 * 
	 * @return column number
	 */
	public int getCol()
	{
		return col;
	}

	/**
	 * Returns the symbol used in the move.
	 * 
	 * @return player symbol
	 */
	public char getSymbol()
	{
		return symbol;
	}

	/**
	 * Returns a readable version of the move.
	 */
	@Override
	public String toString()
	{
		return symbol + " moved to (" + row + ", " + col + ")";
	}

}
