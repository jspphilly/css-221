import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/* C L A S S   D E F I N I T I O N
 * PURPOSE:
 * Read, check, or create a magic square		
 * 
 * METHODS:
 * 	=========PUBLIC============
 * 	checkMatrix() - Checks to ensure the matrix is a magic square
 * 	by checking the following conditions:
 * 
 * 		-Do each of the integers 1, 2, 3, ..., n2 occur in the matrix?
 * 		-Are the sums of each of the rows, columns, and the two diagonals 
 * 		the same value, which is equal to the Magic Number?
 * 
 * 	=========PRIVATE============
 * 	readMatrix() - Reads the contents of a file based on the following 
 * 	format:
 * 
 * 		- Size of matrix is first line
 * 		- Rest of the file contains values of the matrix
 * 		using the size of the matrix for the number of rows 
 * 		and columns.
 * 		
 */
public class MagicSquare {
	

	/*
	 *  ============================================
	 *    		    V A R I A B L E S 
	 *  ============================================
	 */
	
	static int[][] newMagicSquare;
	static int squareSize;
	static int magicNumber;
	static String filename;

	
	
	/*
	 *  ============================================
	 *    		C O N S T R U C T O R S  
	 *  ============================================
	 */
	public MagicSquare(){
		
	}
	

	/*
	 *  ============================================
	 *  	  P U B L I C     M E T H O D S 
	 *  ============================================
	 */
	/*
	 * checkMatrix() 
	 * This method checks to ensure that a given matrix is
	 * actually a magic square by performing a series of checks
	 * 
	 * PARAMS:
	 * 	@String filename - name of the file you want to check
	 */
	public static void checkMatrix(String filename){
		
		
		System.out.println("\n=============READING MATRIX===============\n");
		
		MagicSquare.readMatrix(filename);
		
	}
	
	
	/*
	 * createMatrix() 
	 * This method checks to ensure that a given matrix is
	 * actually a magic square by performing a series of checks
	 * 
	 * PARAMS:
	 * 	@String filename - name of the file where you want to 
	 * 	create a new magic square
	 * 
	 * 	@int size - size of the new magic square
	 * 
	 */
	public static void createMatrix(String filenameInput, int size){
		System.out.println("\n============CREATING MATRIX==============\n");
//		Create an integer value n = size of the Magic Square.
//			Create a two-dimensional array of size n.
//			Create two integer values, row and col.
//			Set row = n - 1.
//			Set col = n / 2.
//			Create two integer values, old-row and old-col.
//			Loop through the array from index i = 1 to i = n2
//				Place the value of i in the array at the location [row][col].
//				Set old-row = row and old-col = col.
//				Increment row and col.
//				If row == n, then replace it with 0.
//				If col == n, then replace it with 0.
//				Check the value stored at the location [row][col].
//					If the element at [row][col] has already been filled,
//						Then set row = old-row and col = old-col,
//						And decrement row.
		
		//Attach values to global variables
		filename = filenameInput;
		squareSize = size;
		magicNumber = (squareSize * ((squareSize * squareSize) + 1 )) / 2;
		
		System.out.println("Filename: " + filename);
		System.out.println("Size : " + size);	
		
		int n = size;
		
		newMagicSquare = new int[n][n];
		
		int row;
		int col;
		int oldRow;
		int oldCol;
		
		row = n - 1;
		col = n / 2;
		
		for(int i = 1; i <= n * n; i++)
		{
			newMagicSquare[row][col] = i;	
			oldRow = row;
			oldCol = col;
			row++;
			col++;
			
			if(row == n){
				row = 0;
			}
			if(col == n){
				col = 0;
			}
			
			if(newMagicSquare[row][col] > 0){
				row = oldRow;
				col = oldCol;
				row--;
			}
		}
		
		
		System.out.println(Arrays.deepToString(newMagicSquare));
		
		//PERFORM ALL CHECKS
		if(checkSeries()){
			if(checkRowColumnDiag()){
				isMagicSquareAlert();
					try {
						writeMatrix();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}else{
				isNotMagicSquareAlert();
			}
		}else
		{
			isNotMagicSquareAlert();
		}
	}
	
	
	/*
	 *  ============================================
	 *  	 P R I V A T E      M E T H O D S 
	 *  ============================================
	 */
	private static void readMatrix(String filenameInput){
		filename = filenameInput;
		
		try {
			//String filename = "valid3x3.txt";
			
			//System.out.print("Enter the file name with extension :");
			File file = new File(filename);
			Scanner input = new Scanner(file);
			
			squareSize =  Integer.parseInt(input.nextLine());
			
			magicNumber = (squareSize * ((squareSize * squareSize) + 1 )) / 2;
			
			System.out.println("Magic number is: " + magicNumber + "\n");

			newMagicSquare = new int[squareSize][squareSize];
			
			int iteratorIndex = 0;
			
			while (input.hasNextLine()){
				String line = input.nextLine();
				String[] strArr = line.split(" ");
		
				for(int i = 0; i < strArr.length; i++)
				{
					if(strArr[i].length() > 0){			
						newMagicSquare[iteratorIndex][i] = Integer.parseInt(strArr[i]);							
						//System.out.println(Integer.parseInt(strArr[i]));
					}
				}
				
				iteratorIndex++;
			}
			
			System.out.println(Arrays.deepToString(newMagicSquare));
			input.close();

		}
		catch (Exception ex){
			ex.printStackTrace();
		}		
		
		//PERFORM ALL CHECKS
		if(checkSeries()){
			if(checkRowColumnDiag()){
				isMagicSquareAlert();
			}else{
				isNotMagicSquareAlert();
			}
		}else
		{
			isNotMagicSquareAlert();
		}	
	}	
	
	
	
	
	/*
	 *  ============================================
	 *  	   C R E A T E    M E T H O D S 
	 *  ============================================
	 */	
	
	private static void writeMatrix() throws IOException{
		
		File file = new File(filename);
		PrintWriter outfile = new PrintWriter(new FileWriter(file));
		
		outfile.println(squareSize);
		
		for (int i = 0; i < squareSize; i++) {
			
			String line = new String(); 
			
			for(int j = 0; j < squareSize; j++){
				line += (newMagicSquare[i][j] + " ");
			}
			
			outfile.println(line);
		  }
		
		outfile.close();
		
	}
	
	
	/*
	 *  ============================================
	 *  	   C H E C K   M E T H O D S 
	 *  ============================================
	 */	
	
	private static boolean checkSeries(){
		
		boolean returnValue = true;
		
		int[] seriesArray = new int[squareSize * squareSize];
		int seriesArrayCounter = 0;
		
		for(int i = 0; i < squareSize;i++){
			for(int j = 0; j < squareSize;j++){
				seriesArray[seriesArrayCounter] = newMagicSquare[i][j];
				//System.out.println(newMagicSquare[i][j]);
				seriesArrayCounter++;
			}
		}
			
		Arrays.sort(seriesArray);
		for(int x = 0; x < seriesArray.length; x++){
			if(x + 1 != seriesArray[x]){
				returnValue = false;
				break;
			}
		}
		
		return returnValue;
	}
	
	
	private static boolean checkRowColumnDiag(){
		
		System.out.println("Checking against magic number: " + magicNumber );
		
		boolean returnValue = true;
		
		//CHECK ROW
		for(int i = 0; i < squareSize; i++)
		{
			int sum = 0;
			
			for(int j = 0; j < squareSize; j++){
				sum += newMagicSquare[i][j];	
			}
			
			if(sum != magicNumber){
				returnValue = false;
				System.out.println("Failed at: \n\t * row");
			}
		}
		
		//CHECK COLUMN
		for(int i = 0; i < squareSize; i++)
		{
			int sum = 0;
			
			for(int j = 0; j < squareSize; j++){
				sum += newMagicSquare[j][i];	
			}
			
			if(sum != magicNumber){
				returnValue = false;
				System.out.println("Failed at: \n\t * column");
			}
				
		}
		
		//CHECK RIGHT DIAGNOAL
		int rightSum = 0;
		for(int i = 0; i < squareSize; i++)
		{
			rightSum += newMagicSquare[i][squareSize - i -1];			
		}
		if(rightSum != magicNumber){
			returnValue = false;
			System.out.println("Failed at: \n\t * right diagonal");
		}
		
		
		//CHECK LEFT DIAGNOAL
		int leftSum = 0;
		for(int i = 0; i < squareSize; i++)
		{
			leftSum += newMagicSquare[i][i];			
		}
		if(leftSum != magicNumber){
			returnValue = false;
			System.out.println("Failed at: \n\t * right diagonal");
		}
		
		
		return returnValue;
	}
	
	
	
	/*
	 *  ============================================
	 *  	   U S E R    A L E R T S 
	 *  ============================================
	 */	
	
	static void isMagicSquareAlert(){
		System.out.println("\n==========================================\n\n");
		System.out.println("******************************************");
		System.out.println("NOTE: We've got a Magic Square here!");
		System.out.println("******************************************");
	}
	
	static void isNotMagicSquareAlert(){
		System.out.println("\n==========================================\n\n");
		System.out.println("******************************************");
		System.out.println("ALERT: This matrix is NOT a Magic Square!");
		System.out.println("******************************************");
	}
}
