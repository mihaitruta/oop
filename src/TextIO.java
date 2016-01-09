
import java.io.IOException;

public class TextIO {
	
	public static int getInputInt(int first, int last) throws IOException {
		
		int userResponsea, userResponseb, input = 0;
		
		userResponsea = System.in.read();
		
		if(userResponsea != 13)
			 input = input * 10 + userResponsea-48;
		
		while(userResponsea != 13){
			userResponsea = System.in.read();
			if(userResponsea != 13)
				 input = input * 10 + userResponsea-48;
		}
		 
		 userResponseb = System.in.read();
		 
		 if(input>=first && input<=last)
			 return input;
		 else {
			 System.out.println("Invalid input");
			 input = getInputInt(first,last);			 
		 }

		 
		 return 0;
	}
	
	
	public static char getInputChar() throws IOException {
		
		int userResponsea, userResponseb;
		boolean bad = true;
		
		char input = ' ';
		
		userResponsea = System.in.read();
		
		if(userResponsea != 13) {
			 input = (char)userResponsea;
			 bad = false;
		}
		
		while(userResponsea != 13){
			userResponsea = System.in.read();
			if(userResponsea != 13)
				bad = true;
		}
		 
		 userResponseb = System.in.read();
		 
		 if( bad ) {
			 System.out.println("Invalid input");
			 input = getInputChar();			 
		 } else {
			 if((input - 'a' >=0) && ('z' - input >= 0))
			 return input;
		 }

		 
		 return '.';
	}
	
	
	public static void showMenu() {
		
		System.out.println("1. Play Hangman");
		System.out.println("2. Quit");
		
	}
	
	public static void showMenu2() {
		
		System.out.println("1. Play random word");
		System.out.println("2. Play a word of chosen length");
		System.out.println("3. Back");		
	}

}
