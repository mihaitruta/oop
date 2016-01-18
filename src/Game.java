import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Game {
	
	public static void RandomWordGame(ArrayList<String> words) throws IOException {
		
		Random r = new Random();
		int randomInt = r.nextInt(words.size());
		
		String word = words.get(randomInt);
		
		
		play(word);
		
	}
	
	public static void SetLengthGame(ArrayList<String> words,int length) throws IOException {
		
		ArrayList<String> al = new ArrayList<String>();
		int i=0;
		int l = words.size();
		for(i=0;i<l;i++) {
			if(words.get(i).length() == length){
				al.add(words.get(i));
			}
		}
		
		Random r = new Random();
		int randomInt = r.nextInt(al.size());
		String word = al.get(randomInt);
		
		play(word);
		
	}
	
	public static void play(String word) throws IOException {
		
		int lives = 8;
		String cs = new String();
		boolean guessed = false;
		boolean badInput = false;
		int i = 0;
		char input;
		boolean running = true;
		String w = new String();
		String letters = new String();
		int l = word.length();
		lives = lives + l/4;
		int toBeGuessed = l;
		//System.out.println("tbg "+toBeGuessed);
		for(i=0;i<l;i++)
			w = w + "*";
		
		while(running) {
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(w);
			System.out.println(lives + " lives left");
			System.out.println("Letters played: " + letters);
			System.out.println("Guess a letter...");
			System.out.println(" ");
			
			input = TextIO.getInstance().getInputChar();
			cs = "" + input;
			if(input == '.' || letters.contains(cs))
				badInput = true;
			
			while(badInput) {
				badInput = false;
				if(input == '.')
					System.out.println("Invalid input. Try again.");
				else
					System.out.println("Letter already played. Try again.");
				
				input = TextIO.getInstance().getInputChar();
				cs = "" + input;
				
				if(input == '.' || letters.contains(cs))
					badInput = true;
			}
			
			letters = letters + input + " ";
			guessed = false;
			for(i=0;i<l;i++) {
				if((input == word.charAt(i)) && (w.charAt(i) == '*')) {
					guessed = true;
					toBeGuessed--;
					//System.out.println("tbg "+toBeGuessed);
					//System.out.println("replaced in " + w + " at index " + i + " with " + input);
					w = ReplaceInString(w,i,input);
				}
			}
			
			if(!guessed)
				lives--;
			
			if(lives==0) {
				System.out.println("You got hanged!");
				System.out.println("The word was " + word);
				System.out.println(" ");
				System.out.println(" ");
				running = false;
			}
			
			if(toBeGuessed == 0) {
				//System.out.println("tbg "+toBeGuessed);
				System.out.println(word);
				System.out.println("You win!");
				System.out.println(" ");
				System.out.println(" ");
				running = false;
			}
		}
		
	}
	
	private static String ReplaceInString(String w, int i, char input) {
		String x = new String();
		if(i>=1)
		x = w.substring(0, i);
		x = x + input;
		if(i+1 < w.length())
		x = x + w.substring(i+1);
		//System.out.println("x is " + x);
		return x;
	}

}
