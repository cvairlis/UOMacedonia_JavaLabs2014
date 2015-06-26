package kremalajavalabs;

import java.io.*;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.*;


/**
 * MyFileReader.java implements the reading from the file function.
 * 
 * @author CHARALAMPOS VAIRLIS
 *
 */
public class MyFileReader {
	
	
	ArrayList<String> words = new ArrayList<String>();
	private String theWord;
	
	
	public MyFileReader (String string){
	}
	
	/**
	 * This method gets a text file and saves all its words in a List.
	 * All the words are being processed by a SetupWord function and finally
	 * in the list we have all words with minimum length of 4 characters uppercased.
	 *  
	 * @param file (.txt file)
	 * @return a list with words.
	 */
	public List<String> get_words (String file){
		
		final int MIN_WORD_LENGTH = 4;
		Scanner wordScan = null;
		
		
		try{
			wordScan = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			System.err.println(e);
			System.exit(1);
		}
		
		while (wordScan.hasNext()){
			
			String nextWord = wordScan.next();
			// here i have a tricky way to accept only particular words.
			// Not accepted: for example екк[]ас or екк[ас or екк]ас or екк?аас or ?ккас
			if (nextWord.length() >= MIN_WORD_LENGTH
					&& (!nextWord.contains("[")
							&& !nextWord.contains("]") 
							&& !nextWord.contains("?"))){
				// Sets up the word
				theWord = SetupWord(nextWord);
				// checks duplicates: add a particular word to List only once.
				// && checks if the word is not nothing!
				// there is no reason to add a "blank" word
				if (!words.contains(theWord) && !theWord.equals("")){
					
					words.add(theWord);
				}
			}		
		}
		wordScan.close();
		return words;
	}
	
	/**
	 * This method gets a String as word and returns the String cleaned by numbers and special character.
	 * It also turns to uppercase the word and removes the accents from greek words.
	 * 
	 * @param aWord
	 * @return cleanWord
	 */
	public String SetupWord (String aWord){
		String cleanWord;
		cleanWord = aWord.replaceAll("[_+.╚╩^:,;?(/)0123456789]", "");
		cleanWord = cleanWord.toUpperCase();
		/* This separates all of the accent marks from the characters.
		 * for example if word is екк╒да the output will be екка╢да. One character more.
		 * I found a way to do it in one line at:
		 *  http://glaforge.appspot.com/article/how-to-remove-accents-from-a-string
		 * but i did this in two lines to supervise the variable behavior in debug mode (breakpoints).
		 */
		cleanWord = Normalizer.normalize(cleanWord, Form.NFD);	
		cleanWord = cleanWord.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		return cleanWord;
	}
	
}
