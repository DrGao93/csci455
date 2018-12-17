// Name: Jianan Gao	
// USC NetID: 7450905127
// CS 455 PA4
// Fall 2018


import java.util.Comparator;
/*Comparator by value, used for comparing two words by its score on score table
 */
public class ComparatorByScore implements Comparator<String>{
	/*compare two string by its score
	 * @param two string
	 * @return if the second string has higher score than the first one.
	 */
	public int compare(String first, String second) {
		ScoreTable scoreTable = new ScoreTable();
		return scoreTable.getScore(second) - scoreTable.getScore(first);
	}
}
