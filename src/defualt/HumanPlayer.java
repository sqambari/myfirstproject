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
 * Purpose: The reponsibility of HumanPlayer is ...
 *
 * HumanPlayer is-a ...
 * HumanPlayer is ...
 */
public class HumanPlayer
{
	// Stores the player's name.
	private String name;

	/**
	 * Creates a human player.
	 * 
	 * @param name the player's name
	 */
	public HumanPlayer(String name)
	{
		this.name = name;
	}

	/**
	 * Returns the human player's name.
	 * 
	 * @return player name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Returns a readable version of the player.
	 */
	@Override
	public String toString()
	{
		return "Human Player: " + name;
	}

}
