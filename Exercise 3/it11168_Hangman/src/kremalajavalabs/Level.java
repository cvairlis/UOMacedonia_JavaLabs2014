package kremalajavalabs;


/**
 * Level.java implements the level functions.
 * A level is an object. It holds 2 variables:
 * selectedLevel (parameter) and misses
 * Level level = new Level(0); for example constructs 
 * the first level and gives the permitted misses for this (first) level.
 * 
 * @author CHARALAMPOS VAIRLIS
 *
 */
public class Level {
	
	private int selectedLevel;
	private int misses;

	
	public Level (int selectedLevel) {
		this.selectedLevel = selectedLevel;
		if (selectedLevel==0){
			misses = 8;
		} else if (selectedLevel == 1){
			misses = 6;
		} else if (selectedLevel == 2){
			misses = 4;
		}
	}

	public int getSelectedLevel() {
		return selectedLevel;
	}

	public int getMisses() {
		return misses;
	}

}
