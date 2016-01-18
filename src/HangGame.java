
import java.io.IOException;
import java.util.ArrayList;

public class HangGame {
	
	public static void main(String args[]) throws IOException {
		
		String url = "https://raw.githubusercontent.com/sacummins/OOPIncompleteWordGame/master/src/main/resources/words.txt";
		
		System.out.println("Loading words\n");
		
		ArrayList<String> words = Word.loadFromURL(url);
		//length between 2 and 45

		play(words);
	}
	
	public static void play(ArrayList<String> words) throws IOException {
		
		boolean running = true;
		boolean menu = true;
		int input = -1;
		
		while(running) {
			
			if(menu)
				TextIO.showMenu();
			else
				TextIO.showMenu2();
			
			if(menu) {
				input = TextIO.getInstance().getInputInt(1, 2);
				while(input == -1) {
					System.out.println("Invalid input. Must be 1 or 2. Try again.");
					input = TextIO.getInstance().getInputInt(1, 2);
				}
			}
			else {
				input = TextIO.getInstance().getInputInt(1, 3);
				while(input == -1) {
					System.out.println("Invalid input. Must be 1, 2 or 3. Try again.");
					input = TextIO.getInstance().getInputInt(1, 3);
				}
			}
			
			
			if(menu) {
				if(input == 2) 
					running = false;
				else 
				if(input == 1)
					menu = false;
			} else {
				if(input == 3)
					menu = true;
				else
				if(input == 1)
					Game.RandomWordGame(words);
				else
				if(input == 2) {
					System.out.println(" ");
					System.out.println("Choose length(between 2 and 45): ");
					int k = TextIO.getInstance().getInputInt(2, 45);
					Game.SetLengthGame(words,k);
				}
			}
			
			
			
		}
		
	}

}
