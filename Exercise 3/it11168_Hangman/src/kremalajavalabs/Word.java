package kremalajavalabs;

import java.util.List;
import java.util.Random;

/**
 * Word.java implements the Word functions.
 * A Word is an object. It holds 2 variables:
 * words and computerScore (parameter)
 * 
 * A word contains and handles the file reader.
 * For a word. automatically is being created also a List with words.
 * FileReader creates this list by its owns method GetWords. See my JavaDocs.
 *
 * @author CHARALAMPOS VAIRLIS
 *
 */
public class Word {
	
	private int					randomInt;
	
	private List<String> 		words;
	
	private Random 				rand;
	
	private String				word;
	
	String DICTIONARY_FILE = 	"wikipedia.txt";
	
	MyFileReader fr 	   =   	new MyFileReader(DICTIONARY_FILE);;
  
	
	public Word(){
		rand = new Random();
	 	words = fr.get_words(DICTIONARY_FILE);
	}
	
	/**
	 * This method uses a random number inside of list bounds
	 * and returns a randomly selected word to be used by the game.
	 * 
	 * @return
	 */
	public String get_word(){
		randomInt = rand.nextInt(words.size());
		word = words.get(randomInt);
		return word;
	}
}
