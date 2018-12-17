// Name: Jianan Gao	
// USC NetID: 7450905127
// CS 455 PA4
// Fall 2018
import java.util.*;

/*score table class where you map every letter to a score
 */
public class ScoreTable {
	
	HashMap<Character,Integer> scoreMap;
	
	//constructor of score table, push every entry into the scoreMap.
	public ScoreTable() {
		scoreMap = new HashMap<Character,Integer>();
		//1
		scoreMap.put('a', 1);
		scoreMap.put('A', 1);
		scoreMap.put('e', 1);
		scoreMap.put('E', 1);
		scoreMap.put('i', 1);
		scoreMap.put('I', 1);
		scoreMap.put('o', 1);
		scoreMap.put('O', 1);
		scoreMap.put('u', 1);
		scoreMap.put('U', 1);
		scoreMap.put('l', 1);
		scoreMap.put('L', 1);
		scoreMap.put('n', 1);
		scoreMap.put('N', 1);
		scoreMap.put('s', 1);
		scoreMap.put('S', 1);
		scoreMap.put('t', 1);
		scoreMap.put('T', 1);
		scoreMap.put('r', 1);
		scoreMap.put('R', 1);
		
		//2
		scoreMap.put('d', 2);
		scoreMap.put('D', 2);
		scoreMap.put('g', 2);
		scoreMap.put('G', 2);
		
		//3
		scoreMap.put('b', 3);
		scoreMap.put('B', 3);
		scoreMap.put('c', 3);
		scoreMap.put('C', 3);
		scoreMap.put('m', 3);
		scoreMap.put('M', 3);
		scoreMap.put('p', 3);
		scoreMap.put('P', 3);
		
		//4
		scoreMap.put('f', 4);
		scoreMap.put('F', 4);
		scoreMap.put('h', 4);
		scoreMap.put('H', 4);
		scoreMap.put('v', 4);
		scoreMap.put('V', 4);
		scoreMap.put('w', 4);
		scoreMap.put('W', 4);
		scoreMap.put('y', 4);
		scoreMap.put('Y', 4);
		
		//5
		scoreMap.put('k', 5);
		scoreMap.put('K', 5);
		
		//8
		scoreMap.put('j', 6);
		scoreMap.put('J', 6);
		scoreMap.put('x', 6);
		scoreMap.put('X', 6);
		
		//10
		scoreMap.put('q', 10);
		scoreMap.put('Q', 10);
		scoreMap.put('z', 10);
		scoreMap.put('Z', 10);
		
		
		
		
	}
	
	/*return a score of a string
	 * @parameter a string of word
	 * @return score of the word
	 */
	public int getScore(String word) {
		int score = 0;
		for(char Char : word.toCharArray()) {
			score += scoreMap.get(new Character(Char));
		}
		return score;
	} 
}
