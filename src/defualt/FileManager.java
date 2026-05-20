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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Purpose: The reponsibility of FileManager is ...
 *
 * FileManager is-a ...
 * FileManager is ...
 */
public class FileManager
{
	/**
	 * Saves score information to a text file.
	 * 
	 * @param scoreManager the score object to save
	 * @param fileName     the name of the file
	 * @throws FileNotFoundException if the file cannot be created
	 */
	public void saveScores(ScoreManager scoreManager, String fileName)
			throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter(fileName);
		writer.println(scoreManager.getXWins());
		writer.println(scoreManager.getOWins());
		writer.println(scoreManager.getDraws());
		writer.close();
	}

	/**
	 * Loads score information from a text file and returns the values.
	 * 
	 * @param fileName the file to read
	 * @return an array containing X wins, O wins, and draws
	 * @throws FileNotFoundException if the file cannot be found
	 */
	public int[] loadScores(String fileName) throws FileNotFoundException
	{
		Scanner fileScanner = new Scanner(new File(fileName));
		int[] scores = new int[3];

		scores[0] = fileScanner.nextInt();
		scores[1] = fileScanner.nextInt();
		scores[2] = fileScanner.nextInt();

		fileScanner.close();
		return scores;
	}

}
