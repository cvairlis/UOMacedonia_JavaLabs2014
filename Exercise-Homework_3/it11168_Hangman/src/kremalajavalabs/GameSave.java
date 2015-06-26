package kremalajavalabs;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * GameSave.java implements the save game functions.
 * 
 * Every game begins checking if there is score.ser file.
 * If it does't exists, GameSave creates it with the 0-0 score.
 * 
 * @author CHARALAMPOS VAIRLIS
 *
 */
public class GameSave {
	Score serialScore;
	Score score;
	
	public GameSave() {
		if (!saveFileExists()){
			save(new Score(0, 0), "score.ser");
		}	
	}
		
	/**
	 * This method loads the score of the game.
	 * 
	 * @param fileName
	 * @return score
	 */
	@SuppressWarnings("finally")
	public Score load(String fileName) {
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			serialScore = (Score) in.readObject();
			in.close();
			fileIn.close();	
			
		} catch (IOException io){
			io.printStackTrace();
		} catch (ClassNotFoundException c){
			c.printStackTrace();
		} finally {
			return serialScore;
		}
	}	
	
	
	/**
	 * This method saves the score of the game.
	 * 
	 * @param score
	 * @param fileName
	 */
	public void save(Score score, String fileName) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(score);
			out.close();
			fileOut.close();
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			System.out.println("Game Saved");
		}			
	}	
	
	/**
	 * This method is checking if there is a score.ser file in the destination folder
	 * to load up. It's being used for the initial moment in the begging of every game. 
	 * 
	 * @return
	 */
	public boolean saveFileExists(){
		File f = new File("score.ser");
		return f.exists();
	}	
}
