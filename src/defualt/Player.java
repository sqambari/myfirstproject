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
 *         Version: 2026-05-19
 */
package defualt;

/**
 * Purpose: The reponsibility of Player is ...
 *
 * Player is-a ...
 * Player is ...
 */
public class Player
{
	// Stores the player's name.
	private String name;

	// Stores the player's board symbol, such as X or O.
	private char symbol;

	/**
	 * Creates a player object.
	 * 
	 * @param name   the player's name
	 * @param symbol the symbol used by the player
	 */
	public Player(String name, char symbol)
	{
		this.name = name;
		this.symbol = symbol;
	}

	/**
	 * Returns the player's name.
	 * 
	 * @return player name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Returns the player's symbol.
	 * 
	 * @return player symbol
	 */
	public char getSymbol()
	{
		return symbol;
	}

	/**
	 * Returns a readable text version of the player.
	 */
	@Override
	public String toString()
	{
		return name + " (" + symbol + ")";
	}

}
