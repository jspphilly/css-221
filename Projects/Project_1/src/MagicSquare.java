import java.io.File;
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
	
	//private String filename
	
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
	public static void createMatrix(String filename, int size){
		
		
		
	}
	
	
	
	/*
	 *  ============================================
	 *  	 P R I V A T E      M E T H O D S 
	 *  ============================================
	 */
	private static void readMatrix(String filename){
		
		try {
			//String filename = "valid3x3.txt";
			
			//System.out.print("Enter the file name with extension :");
			File file = new File(filename);
			Scanner input = new Scanner(file);
			
			while (input.hasNextLine()){
				String line = input.nextLine();
				System.out.println(line);
			}
			
			input.close();

		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}	
	
	
	
	
	
}
