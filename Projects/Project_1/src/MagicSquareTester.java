import java.util.ArrayList;

public class MagicSquareTester {

	public static void main(String[] args){
			
		//store all the arguments in different lists
		ArrayList<String> options = new ArrayList<String>();
		ArrayList<String> otherInputs = new ArrayList<String>();
		String filename;
		int size;
		
		
		
		//Loop through the arguments and separate them into separate lists
		for(int i = 0; i < args.length; i++){
			//Separate all the options from the other arguments their own list
			if(args[i].charAt(0) == '-'){
				options.add(new String(args[i]));
			}
			else{
				otherInputs.add(new String(args[i]));
			}
		}
			
		
		//if there were more than two options, throw an error 
		//and request they only enter in one option
		if(options.size() > 1){
			MagicSquareTester.tooManyOptionsAlert();
			
			//EXIT PROGRAM
			System.exit(0);
		}
		
		
		//Check for -check
		if(options.get(0).equals("-check")){
			
			//Check to make sure there isn't more than one additional arg
			if(otherInputs.size() > 1){
				MagicSquareTester.checkSquareAlert();
				System.exit(0);
			}
			
			filename = otherInputs.get(0);
			
			
			//Check the file to ensure it's a magic square
			MagicSquare.checkMatrix(filename);
		}
		
		// Check for -create
		if(options.get(0).equals("-create")){
			
			//Check to make sure there isn't more than one additional arg
			if(otherInputs.size() != 2){
				
				MagicSquareTester.createSquareAlert();
				
				//EXIT PROGRAM
				System.exit(0);
			}
			
			
			int sizeIndex = MagicSquareTester.checkNum(otherInputs);
			size = Integer.parseInt(otherInputs.remove(sizeIndex));
			//Check to make sure the size is odd
			if(size % 2 == 0){
				System.out.println("Hold up! That\'s an even number. Enter an odd number please");
				System.exit(0);
			}
			
			filename = otherInputs.get(0);
			
			//create a new magic square
			MagicSquare.createMatrix(filename, size);
		}
		
	}
	
	
	/*	==============================================
	 * 			H E L P E R    M E T H O D S 
	 *  ==============================================
	 */
	
	//	Checks to make sure that there is a number in the other options, 
	//  and then returns the index of the number
	private static int checkNum( ArrayList<String> otherOptions ){
		
		int index = 0;
		
		for(int i = 0; i < otherOptions.size(); i++)
		{
			if(MagicSquareTester.isParsable(otherOptions.get(i))){
				index =  i;
			}
		}
		
		
		return index;
	};
	
	private static void createSquareAlert(){
		
		System.out.println("Something's wrong with your input for creating a Magic Square.");
		System.out.println("======I N S T R U C T I O N S======");
		System.out.println("Please include: ");
		System.out.println("\t1. ONE filename");
		System.out.println("\t1. ONE odd integer");
	};
	
	private static void checkSquareAlert(){
		
		System.out.println("Something's wrong with your input for checking a square.");
		System.out.println("======I N S T R U C T I O N S======");
		System.out.println("Please include: ");
		System.out.println("\t1. ONE filename");
	};
	
	private static void tooManyOptionsAlert(){
		
		System.out.println("Something's wrong with your input.");
		System.out.println("=====I N S T R U C T I O N S=====");
		//Check square
		System.out.println("\nTO CHECK A SQUARE ENTER: ");
		System.out.println("\t1. -check");
		System.out.println("\t2. ONE filename (e.g. \"newSquare\")");
		//Create square
		System.out.println("\nTO CREATE A SQUARE ENTER: ");
		System.out.println("\t1. -create ");
		System.out.println("\t2. ONE filename (e.g. \"newSquare\")");
		System.out.println("\t3. ONE odd integer (e.g. 5)");
		
	};
	
	
	//Check to see if a number is parsable
	public static boolean isParsable(String input){
	    boolean parsable = true;
	    try{
	        Integer.parseInt(input);
	    }catch(NumberFormatException e){
	        parsable = false;
	    }
	    return parsable;
	}
	
}
