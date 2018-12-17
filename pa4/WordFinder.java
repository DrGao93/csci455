// Name: Jianan Gao	
// USC NetID: 7450905127
// CS 455 PA4
// Fall 2018

import java.io.FileNotFoundException;
import java.util.*;

/*his class will have a main that's responsible for processing the command-line argument,
 *and handling any error processing. It will probably also have the main command loop. 
 *Most of the other functionality will be delegated to other object(s) created in main
 *and their methods.
 * */
public class WordFinder {
	public static void main(String[] argvs) {
		String fileName = "sowpods.txt";
		if(argvs.length != 0) {
			fileName = argvs[0];
		}
		AnagramDictionary anagramDict = null;
		
		//try to read the file
		try {
			anagramDict = new AnagramDictionary(fileName);
		}catch(FileNotFoundException e){
			System.out.println(e);
			return;
		}
		System.out.println("Type . to quit.");
		Scanner in =new  Scanner(System.in);
		while(true) {
			System.out.print("Rack? ");			
			String input = in.next();
			
			//terminate the program
			if(input.equals(".")) {
				break;
			}
			Rack rack = new Rack(input);
			ArrayList<String> allMatches = new ArrayList<String>();
			//merge all the match words to one arraylist
			for(String subset : rack.Subsets()) {
				ArrayList<String> matchWords = anagramDict.getAnagramsOf(subset);
				if(matchWords != null) {
					allMatches.addAll(matchWords);					
				}				
			}
			ScoreTable table = new ScoreTable();
			//sort it first by alphabets and then by score
			Collections.sort(allMatches);
			Collections.sort(allMatches, new ComparatorByScore());
			System.out.println("We can make "+ allMatches.size() +" words from \""+input +"\"");
			if(allMatches.size() != 0) {
				System.out.println("All of the words with their scores (sorted by score):");
			}
			for(String word : allMatches) {
				System.out.println(table.getScore(word)+": "+ word);
			}	
		}	
	}
	/*this private method cleans up the entered word so that it only contains 
	 * letters.
	 * @parameter : a string entered by user.
	 * @return: a string only consisting letters.
	 */
//	private static String clean(String toClean) {
//		String ret = "";
//		for(char Char : toClean.toCharArray()) {
//			if((Char<='z' && Char>='a')||(Char<='Z' && Char>='A')) {
//				ret += Char;
//			}
//		}
//		return ret;
//	}
	
}
