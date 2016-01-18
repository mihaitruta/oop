
import java.io.IOException;
import java.util.Scanner;

public class TextIO {
	
	private Scanner input;
	private static TextIO instance = null;
	
	private TextIO() {
		input = new Scanner(System.in);
	}
	
	public static TextIO getInstance() {
		if(instance == null)
			instance = new TextIO();
		return instance;
	}
	
	public int getInputInt(int first, int last) {
		String in = input.nextLine();
		int p = 0;
		int i = 0;
		int l = in.length();
		char k;
		for(i=0;i<l;i++) {
			k = in.charAt(i);
			if('0' <= k && k <= '9') 
				p = p*10 + (int)(k - '0');
			else
				return -1;
		}
		if(p < first || p > last)
			return -1;
		return p;
	}
	
	public char getInputChar() {
		
		String in = input.nextLine();
		if(in.length() != 1)
			return '.';
		
		char k = in.charAt(0);
		
		if('a' <= k && k <= 'z')
			return k;
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
