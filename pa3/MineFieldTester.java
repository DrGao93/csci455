
public class MineFieldTester {
	public static void main(String[] argvs) {
		 boolean[][] smallMineField = 
		      {{false, false, false, false}, 
		       {true, false, false, false}, 
		       {false, true, true, false},
		       {false, true, false, true}};
		
		MineField mine1 = new MineField(smallMineField);
		String test = mine1.toString();
		int test1 = mine1.numRows();
		int test2 = mine1.numCols(); 
//		System.out.println(test);
//		System.out.println(test1);
//		System.out.println(test2);
		
		MineField mine2 = new MineField(4,4,5);
		String test3 = mine2.toString();
		System.out.println(test3);
		mine2.populateMineField(1, 2);
		String test4 = mine2.toString();
		System.out.println(test4);
		int num = mine2.numAdjacentMines(1, 2);
		System.out.println(num);
	}
}
