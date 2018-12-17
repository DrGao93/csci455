
// Name: Jianan Gao   
// USC NetID: 7450905127
// CS 455 PA3
// Fall 2018
import java.util.Random;


/** 
   MineField
      class with locations of mines for a game.
      This class is mutable, because we sometimes need to change it once it's created.
      mutators: populateMineField, resetEmpty
      includes convenience method to tell the number of mines adjacent to a location.
 */
public class MineField {
   
   // <put instance variables here>
   boolean [][] mineData;//the mineData.
   int numMines;//number of mines.

   
   /**
      Create a minefield with same dimensions as the given array, and populate it with the mines in the array
      such that if mineData[row][col] is true, then hasMine(row,col) will be true and vice versa.  numMines() for
      this minefield will corresponds to the number of 'true' values in mineData.
    * @param mineData  the data for the mines; must have at least one row and one col.
    */
   public MineField(boolean[][] mineData) {
      //this.mineData = mineData;//problem
	   //copy the mineData by valye instead of just pass by reference.
      this.mineData = new boolean[mineData.length][];
      for(int i=0;i<mineData.length;i++) {
    	  this.mineData[i] = mineData[i].clone();
      }
      
      
      
   }
   
   
   /**
      Create an empty minefield (i.e. no mines anywhere), that may later have numMines mines (once 
      populateMineField is called on this object).  Until populateMineField is called on such a MineField, 
      numMines() will not correspond to the number of mines currently in the MineField.
      @param numRows  number of rows this minefield will have, must be positive
      @param numCols  number of columns this minefield will have, must be positive
      @param numMines   number of mines this minefield will have,  once we populate it.
      PRE: numRows > 0 and numCols > 0 and 0 <= numMines < (1/3 of total number of field locations). 
    */
   public MineField(int numRows, int numCols, int numMines) {
      this.numMines = numMines;
      mineData = new boolean[numRows][numCols];
   }
   

   /**
      Removes any current mines on the minefield, and puts numMines() mines in random locations on the minefield,
      ensuring that no mine is placed at (row, col).
      @param row the row of the location to avoid placing a mine
      @param col the column of the location to avoid placing a mine
      PRE: inRange(row, col)
    */
   public void populateMineField(int row, int col) {
	   //?
	   //this.resetEmpty();
	   
	   int mineDataRow = mineData.length;
	   int mineDataCol = mineData[0].length;
	   for(int i=0;i<mineDataRow;i++) {
		   for(int j=0;j<mineDataRow;j++) {
			   
			   mineData[i][j] = false;
		   }
	   }
	   
	   Random rand = new Random();
	   int mineRow;
	   int mineCol;
	   int numMines = 0;
	  
	   
	   while(numMines < this.numMines) {
		   mineRow = rand.nextInt(mineDataRow);
		   mineCol = rand.nextInt(mineDataCol);
		   if(!((mineRow == row) && (mineCol == col)) ) {
			   if(!mineData[mineRow][mineCol]) {
				   System.out.println(numMines);
				   mineData[mineRow][mineCol] = true;
				   numMines ++;
			   }
			   
		   }
	   }
   }
   
   
   /**
      Reset the minefield to all empty squares.  This does not affect numMines(), numRows() or numCols()
      Thus, after this call, the actual number of mines in the minefield does not match numMines().  
      Note: This is the state the minefield is in at the beginning of a game.
    */
   public void resetEmpty() {
	   int mineDataRow = mineData.length;
	   int mineDataCol = mineData[0].length;
	   for(int i=0;i<mineDataRow;i++) {
		   for(int j=0;j<mineDataRow;j++) {
			   mineData[i][j] = false;
		   }
	   }
   }

   
  /**
     Returns the number of mines adjacent to the specified mine location (not counting a possible 
     mine at (row, col) itself).
     Diagonals are also considered adjacent, so the return value will be in the range [0,8]
     @param row  row of the location to check
     @param col  column of the location to check
     @return  the number of mines adjacent to the square at (row, col)
     PRE: inRange(row, col)
   */
   public int numAdjacentMines(int row, int col) {
	   int numAjacentMines=0;
	   for(int i=row-1;i<=row+1;i++) {
		   for(int j=col-1;j<=col+1;j++) {
			   if(this.inRange(i,j)) {
				   if(mineData[i][j]) {
					   if(!(i==row && j==col)) {
						   numAjacentMines ++;
					   }
				   }
			   }
		   }
	   }
      return numAjacentMines;       
   }
   
   
   /**
      Returns true iff (row,col) is a valid field location.  Row numbers and column numbers
      start from 0.
      @param row  row of the location to consider
      @param col  column of the location to consider
      @return whether (row, col) is a valid field location
   */
   public boolean inRange(int row, int col) {
	   //System.out.println(row+" "+col+" ");
	   if(row>=0&& row<mineData.length && col>=0 && col< mineData[0].length) {
		   return true;
	   }
	   else {
		   
		//	System.out.println(row+" "+col+" ");
		   return false; 
	   }
            // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns the number of rows in the field.
      @return number of rows in the field
   */  
   public int numRows() {
	   
      return mineData.length;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns the number of rows in the field.
      @return number of rows in the field
   */    
   public int numCols() {
      return mineData[0].length;       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns whether there is a mine in this square
      @param row  row of the location to check
      @param col  column of the location to check
      @return whether there is a mine in this square
      PRE: inRange(row, col)   
   */    
   public boolean hasMine(int row, int col) {
      return mineData[row][col];       // DUMMY CODE so skeleton compiles
   }
   
   
   /**
      Returns the number of mines you can have in this minefield.  For mines created with the 3-arg constructor,
      some of the time this value does not match the actual number of mines currently on the field.  See doc for that
      constructor, resetEmpty, and populateMineField for more details.
    * @return
    */
   public int numMines() {
      return this.numMines;       // DUMMY CODE so skeleton compiles
   }
   
   // toString function to help debug the program. return the mine matrix. 
   public String toString() {
	   String ret = "";
	   for(int i=0;i<mineData.length;i++) {
		   for(int j=0;j<mineData[0].length;j++) {
			   ret += mineData[i][j] + " ";
		   }
		   ret +="\n";
	   }
	   return ret;
   }
   
   // <put private methods here>
   
         
}

