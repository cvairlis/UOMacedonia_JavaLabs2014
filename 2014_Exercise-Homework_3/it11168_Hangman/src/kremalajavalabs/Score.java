package kremalajavalabs;

import java.io.Serializable;

/**
 * Score.java implements the score functions.
 * A score is an object. It holds 2 variables:
 * playerScore and computerScore (parameter)
 * 
 * Score score = new Score(0,0); for example constructs 
 * a new score 0-0
 * 
 * @author CHARALAMPOS VAIRLIS
 *
 */
public class Score implements Serializable {	
	private static final long serialVersionUID = 1L;	
	private int playerScore;
	private int computerScore;
	StringBuilder ScoreBuilder;
	String ScoreText;
		
	public Score(int playerScore, int computerScore) {
		super();
		this.playerScore = playerScore;
		this.computerScore = computerScore;
	}
	
	public int addComputerWin(){
		return computerScore++;
	}
	
	public int addPlayerWin(){
		return playerScore++;
	}

	/**
	 * Method returns a string that shows the current score like this: 0 - 0
	 * 
	 */
	public String toString(){
		ScoreBuilder = new StringBuilder();
		ScoreBuilder.append(playerScore);
		ScoreBuilder.append(" - ");
		ScoreBuilder.append(computerScore);
		// to string shows score like this: 0 - 0
		ScoreText = ScoreBuilder.toString();
		
		return ScoreText;
	}

	/**
	 * Method to set player and computer score to 0.
	 * 
	 */
	public void clearScore(){
		this.playerScore=0;
		this.computerScore=0;
	}
}
