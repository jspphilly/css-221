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
			System.out.println("Try again, and only pass in one option, please");
			System.exit(0);
		}
		
		
		//Check for -check
		if(options.get(0).equals("-check")){
			
			//Check to make sure there isn't more than one additional arg
			if(otherInputs.size() > 1){
				System.out.println("Sorry, you can only check one file at a time.");
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
				System.out.println("Sorry, you can only check one file at a time.");
				System.exit(0);
			}
			
			int sizeIndex = MagicSquareTester.checkNum(otherInputs);
			
			
			size = Integer.parseInt(otherInputs.remove(sizeIndex));
			
			filename = otherInputs.get(0);
			
			//create a new magic square
			MagicSquare.createMatrix(filename, size);
		}
		
		
		
		
		for(int j = 0; j < options.size(); j++){
			
			System.out.println(options.get(j));
			System.out.println(options.size());
		}
		
//		//Loop through the command line arguments
//		for(int i = 0; i < args.length; i++){
//			System.out.print("Argument number:" + i);
//			System.out.print(args[i] + "\n");
//			
//		}
//		
		
		
		//MagicSquare ms = new MagicSquare();
		
		
		
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
