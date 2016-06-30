
public class MagicSquareTester {

	public static void main(String[] args){
		
		
		
		for(int i = 0; i < args.length; i++){
			System.out.println("Argument number:" + i);
			System.out.print(args[i]);
		}
		
		//MagicSquare ms = new MagicSquare();
		
		MagicSquare.checkMatrix();
		
	}
}
