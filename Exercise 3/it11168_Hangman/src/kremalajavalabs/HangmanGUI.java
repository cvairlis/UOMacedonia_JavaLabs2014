package kremalajavalabs;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

/**
 * HangmanGUI contains all the graphics and the gameplay too.
 * 
 * @author CHARALAMPOS VAIRLIS
 *
 */


public class HangmanGUI {
	
	/*
	 * GUI Variables area	
	 */
	
    /* Buttons */
    JButton resetButton		= null;
    JButton exitButton   	= null;
    JButton newGameButton 	= null;
    JButton confirmReset	= null;
    
    JRadioButton easy		= null;
    JRadioButton medium		= null;
    JRadioButton hard		= null;
    
    ButtonGroup level;
    
    /* Labels */
    JLabel SelectLevel 		= null;

    JLabel wordArea    		= null;
    JLabel wordToGuessArea	= null;
    JLabel messageArea 		= null;
    JLabel currentScore		= null;
    
    JTextPane scoreText		= null;
    
    JLabel wrongCharacterGuessesArea		= null;
    
    java.util.List<JButton> alphaButtonList = new ArrayList<JButton>();
    
    Iterator<JButton> alphaIterator 	= null;

    /* Enable - disable for true or false Show buttons - hide buttons */ 
    boolean enable			= true;
    boolean disable      	= false;
    
    /*
	 * Game Variables area	
	 */
        
    /* Objects */
    Word guessWords = new Word();
    GameSave gameSerialized;
    Score newScore;
    
    String wrong = "";
    String maskedWord;
    String targetWord;

    int tempWrong;
    int numberOfWrongAnswers 	= 8;
    int next              		= 0;
    
    
    /**
     * Hangman Constructor
     * It loads the score and createComponents.
     */
    public HangmanGUI(){
    	gameSerialized = new GameSave();
    	newScore = gameSerialized.load("score.ser");
    	createComponents();
    }
    
    /**
     * This method saves the game. 
     */
    public void saveGame(){
    	gameSerialized.save(newScore, "score.ser");
    }
    
    /**
	 * Create the components for the game GUI.
	 * The returned JPanel will have all the elements of the GUI
	 * arranged in a BorderLayout.
	 *
	 * @return JPanel with GUI elements arranged in a BorderLayout.
	 */
	public Component createComponents() {
		JPanel pane = new JPanel();
		pane.setBorder(BorderFactory.createLoweredBevelBorder());
		
		pane.setLayout(new BorderLayout() );
		pane.add(createWestPane(), BorderLayout.WEST);
		pane.add(createSouthPane(), BorderLayout.SOUTH);
		pane.add(createEastPane(), BorderLayout.EAST);
		pane.add(createCenterPane(), BorderLayout.CENTER);
		pane.add(createNorthPane(), BorderLayout.NORTH);
        return pane;
 	 }
	
	
	/**
	 * Create the North Pane of the BorderLayout used by the game.
	 * The returned JPanel contains New Game, Continue last game, Level Selection,
	 * Score Clear and Exit buttons arranged horizontally in a BoxLayout form.
	 * 
	 * @return JPanel with control buttons set in a BoxLayout
	 */
	public Component createNorthPane() {
		
        ActionListener controlButtonListener = new ActionListener() {
        	@Override
        	public void actionPerformed( ActionEvent e ) {
                JButton buttonPushed = (JButton)e.getSource();
                if(buttonPushed.getText().equals("Παίξε")) {
                	resetButton.setEnabled(enable);                	
                	// disables level buttons when starts an game
                    controlLevelButtons(disable);                    
                	setUpNewGame();        
                	messageArea.setText("Καλή τύχη :P");
                	// view current score
                    scoreText.setText(newScore.toString());                    
                    wrong = "";
                    wrongCharacterGuessesArea.setText(wrong);
                    // else if clear button
                } else if (buttonPushed.getText().equals("Καθαρισμός")){
                	// message for clearing the score
                    messageArea.setText("Επαναφορά σκορ?");
                    // enables the score clear confirmation button
                	confirmReset.setVisible(enable);
                } else { // else here is exit
                	saveGame();
                	System.exit(0);
                } 
            }
        };
        
        ActionListener levelButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				JRadioButton levelButtonPushed = (JRadioButton)ev.getSource();
				// level buttons act as a common button
				if(levelButtonPushed.getText().equals("Εύκολο")){
					Level lev = new Level(0);
					numberOfWrongAnswers = lev.getMisses();
				}else if(levelButtonPushed.getText().equals("Μεσαίο")){
					Level lev = new Level(1);
					numberOfWrongAnswers = lev.getMisses();
				}else if (levelButtonPushed.getText().equals("Δύσκολο")){
					Level lev = new Level(2);
					numberOfWrongAnswers = lev.getMisses();
				}
			}
		};

        JPanel pane = new JPanel();
        pane.setPreferredSize(new Dimension(8, 40));
        pane.setBorder(BorderFactory.createRaisedBevelBorder());
        pane.setLayout(new BoxLayout(pane,BoxLayout.X_AXIS));
        
        // BUttons FONT
        Font foPlain = new Font("Verdana", Font.PLAIN, 22);
        Font foBold = new Font("Verdana", Font.BOLD, 22);

        SelectLevel = new JLabel("Διάλεξε επίπεδο: ");
        SelectLevel.setFont(foBold);
        //SelectLevel.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(SelectLevel);     
        
        easy = new JRadioButton("Εύκολο", enable);  
        easy.setFont(foPlain);
        easy.addActionListener(levelButtonListener);
        
        
        medium = new JRadioButton("Μεσαίο", disable);
        medium.setFont(foPlain);
        medium.addActionListener(levelButtonListener);
        
        hard = new JRadioButton("Δύσκολο", disable);
        hard.setFont(foPlain);
        hard.addActionListener(levelButtonListener);
        
        level = new ButtonGroup();
        level.add(easy);
        level.add(medium);
        level.add(hard);
        pane.add(easy);
        pane.add(medium);
        pane.add(hard);
        
        newGameButton = new JButton("Παίξε");
        newGameButton.setFont(foBold);
        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        newGameButton.addActionListener(controlButtonListener);
        pane.add(newGameButton);

        pane.add(Box.createVerticalGlue());
       
        exitButton = new JButton("Έξοδος");
        exitButton.setFont(foBold);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.addActionListener(controlButtonListener);
        pane.add(exitButton);
        
        resetButton = new JButton("Καθαρισμός");
        resetButton.setFont(foBold);
        resetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        resetButton.addActionListener(controlButtonListener);
        pane.add(resetButton);
        
        resetButton.setEnabled(disable);
        
        return pane;
    } 
	

	/**
	 * Create the West pane of the BorderLayout used by the game.
	 * The returned component is a JPanel with 2 JLabels used for
	 * word to guess area and wrong guessed characters area.
	 * 
	 * @return JPanel for use displaying game word and wrong guesses.
	 */
	public Component createWestPane() {
		
		JPanel pane = new JPanel();
		pane.setPreferredSize(new Dimension(350,20));
	    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
	    pane.setBorder(BorderFactory.createTitledBorder("Μάντεψε τη κρυμμένη λέξη."));
	    pane.add(Box.createHorizontalGlue() );
	    
	    wordArea = new JLabel("Πατήστε Παίξε !");
	    wordArea.setFont(new Font("Verdana", Font.PLAIN, 22));
	    
	    wrongCharacterGuessesArea = new JLabel();
	    wrongCharacterGuessesArea.setPreferredSize(new Dimension(27,20));
	    //wrongArea.setBackground(Color.blue);
	    wrongCharacterGuessesArea.setFont(new Font("Verdana", Font.PLAIN, 22));
	  
	    // guessWord area
	    pane.add(wordArea);
	    // wrong selected characters area
	    pane.add(wrongCharacterGuessesArea);
	    
	    //pane.add(Box.createHorizontalGlue() );
	    return pane;
	}
	
	

	/**
	 * Create the South pane of the BorderLayout used by the game.
	 * The returned JPanel has 2 rows and 12 columns consisting of
	 * buttons for each letter of the GREEK alphabet.
	 * Also creates the ActionListener for these buttons and process answer.
	 * 
	 * @return JPanel with alphabet buttons in it.
	 */
	public Component createSouthPane() {
		
		// when user press a button ActionListener listens this action and performs an event
		ActionListener alphabetButtonAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton buttonPushed = (JButton)e.getSource();
				buttonPushed.setEnabled(disable);
				// the event performed from ActionListener is this: passes the character that user guessed to processAnswer
				processAnswer(buttonPushed.getText());
			}
		};

		JPanel pane = new JPanel();
		pane.setBorder(BorderFactory.createLoweredBevelBorder());
	    
		Font buttonFontt = new Font("Verdana", Font.PLAIN, 20);
		// GridBag gives 
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c  = new GridBagConstraints();
		// apply GridBagLayout gridbag to JPanel
		pane.setLayout(gridbag);
		c.fill = GridBagConstraints.HORIZONTAL;

		JButton button = new JButton( "Α" );
		c.weightx = 0.5;
		// 1 line 1 column
		c.gridx = 0;
	    c.gridy = 0;
	    // apply GridBagConstraints c to JPanel
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
	    pane.add(button);
	    alphaButtonList.add(button);

	    button = new JButton( "Β" );
	    // 1 line 2 column
	    c.gridx = 1;
	    c.gridy = 0;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
	    pane.add(button);
	    alphaButtonList.add(button);

	    button = new JButton( "Γ" );
	    // 1 line 3 column
	    c.gridx = 2;
	    c.gridy = 0;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
	    pane.add(button);
	    alphaButtonList.add(button);

	    button = new JButton( "Δ" );
	    c.gridx = 3;
	    c.gridy = 0;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
	    pane.add(button);
	    alphaButtonList.add(button);

	    button = new JButton( "Ε" );
	    c.gridx = 4;
	    c.gridy = 0;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
	    pane.add(button);
	    alphaButtonList.add(button);
	    
	    button = new JButton( "Ζ" );
	    c.gridx = 5;
	    c.gridy = 0;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
	    pane.add(button);
	    alphaButtonList.add(button);


	    button = new JButton( "Η" );
	    c.gridx = 6;
	    c.gridy = 0;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
	    pane.add(button);
	    alphaButtonList.add(button);

	    button = new JButton( "Θ" );
	    c.gridx = 7;
	    c.gridy = 0;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
	    pane.add(button);
	    alphaButtonList.add(button);

	    button = new JButton( "Ι" );
	    c.gridx = 8;
	    c.gridy = 0;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
	    pane.add(button);
	    alphaButtonList.add(button);

	    button = new JButton( "Κ" );
	    c.gridx = 9;
	    c.gridy = 0;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
	    pane.add(button);
	    alphaButtonList.add(button);

	    button = new JButton( "Λ" );
	    c.gridx = 10;
	    c.gridy = 0;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
	    pane.add(button);
	    alphaButtonList.add(button);

	    button = new JButton( "Μ" );
	    c.gridx = 11;
	    c.gridy = 0;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
	    pane.add(button);
	    alphaButtonList.add(button);

	    button = new JButton( "Ν" );
	    // 2 line 1 column
	    c.gridx = 0;
	    c.gridy = 1;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
	    pane.add(button);
	    alphaButtonList.add(button);

	    button = new JButton( "Ξ" );
	    // 2 line 2 column
	    c.gridx = 1;
	    c.gridy = 1;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
	    pane.add(button);
	    alphaButtonList.add(button);

	    button = new JButton( "Ο" );
	    c.gridx      = 2;
	    c.gridy      = 1;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
		pane.add(button);
		alphaButtonList.add(button);

	    button = new JButton( "Π" );
	    c.gridx      = 3;
	    c.gridy      = 1;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
		pane.add(button);
		alphaButtonList.add(button);

	    button = new JButton( "Ρ" );
	    c.gridx      = 4;
	    c.gridy      = 1;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
		pane.add(button);
		alphaButtonList.add(button);

	    button = new JButton( "Σ" );
	    c.gridx      = 5;
	    c.gridy      = 1;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
		pane.add(button);
		alphaButtonList.add(button);
		
		button = new JButton( "Τ" );
	    c.gridx      = 6;
	    c.gridy      = 1;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
		pane.add(button);
		alphaButtonList.add(button);

		button = new JButton( "Υ" );
	    c.gridx      = 7;
	    c.gridy      = 1;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
		pane.add(button);
		alphaButtonList.add(button);

	    button = new JButton( "Φ" );
	    c.gridx      = 8;
	    c.gridy      = 1;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
		pane.add(button);
		alphaButtonList.add(button);

	    button = new JButton( "Χ" );
	    c.gridx      = 9;
	    c.gridy      = 1;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
		pane.add(button);
		alphaButtonList.add(button);

	    button = new JButton( "Ψ" );
	    c.gridx      = 10;
	    c.gridy      = 1;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
		pane.add(button);
		alphaButtonList.add(button);
	        
		button = new JButton( "Ω" );
	    c.gridx      = 11;
	    c.gridy      = 1;
	    gridbag.setConstraints(button, c);
	    button.setFont(buttonFontt);
	    button.addActionListener(alphabetButtonAction);
		pane.add(button);
		alphaButtonList.add(button);

		// disable pressed button
	    alphaIterator = alphaButtonList.iterator();
	    while(alphaIterator.hasNext()) {
	    	((JButton)alphaIterator.next()).setEnabled(disable);
	    }
	        
	    return pane;
	}
	    
	/**
	 * Create the East pane of the BorderLayout used by the game.
	 * The returned component is a JPanel with a JLabel
	 * where the winning and losing messages will be displayed.
	 * JPanel contains also a JButton. This button is not always visible.
	 * It gets visible if the user push Clear button and it used for confirmation purposes.
	 * 
	 * @return JPanel for use displaying winning and losing messages.
	 */
	public Component createEastPane() {
		
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout());
		// yes button 
		// catches confirmation button push
		ActionListener resetButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JButton resetButtonListener = (JButton)ev.getSource();
				
				if(resetButtonListener.getText().equals("ΝΑΙ")){
					
					// clears, saves and show the score (0-0)
                    newScore.clearScore();
                    saveGame();
                    scoreText.setText(newScore.toString());
                    
                    // enables level buttons when resets a game
					controlLevelButtons(enable);
                    
					confirmReset.setVisible(disable);
					
                    // enables the buttons
                	newGameButton.setEnabled(enable);
                	// enables level buttons when resets a game
					controlLevelButtons(enable);
                	// clears, and show again wrong guessed characters area
                    wrong = "";
                    wrongCharacterGuessesArea.setText(wrong);
                    
                    // disables all alphabet buttons until play button will be pushed
                    controlAlphaButtons(disable);
                    
                    // give messages
					messageArea.setText("Καθαρισμός ολοκληρώθηκε.");
					wordArea.setText("Πατήστε Παίξε !");
				}
			}
		};
		
	    // continues building the panel
	    messageArea = new JLabel("Βρες τη λέξη!");
	    messageArea.setFont( new Font("Verdana", Font.PLAIN, 20) );
	   
	    pane.add(messageArea);
	    pane.add(Box.createHorizontalGlue());
	    
	    confirmReset = new JButton("ΝΑΙ");
	    confirmReset.setFont(new Font("Verdana", Font.PLAIN, 18));
	    
	    confirmReset.setAlignmentX(Component.CENTER_ALIGNMENT);
	    confirmReset.addActionListener(resetButtonListener);
        pane.add(confirmReset);

        confirmReset.setVisible(disable);
        wordToGuessArea = new JLabel();
        wordToGuessArea.setFont( new Font("Verdana", Font.PLAIN, 20) );
	    
	    pane.add(wordToGuessArea);
	    
	    return pane;
	}
	
	/**
	 * Create the Center pane of the BorderLayout used by the game.
	 * The returned component is a JPanel used to show the current score.
	 * 0-2 means that the computer is winning
	 * 4-2 means that the player is winning
	 * 
	 * @return JPanel to show the current score.
	 */
	public Component createCenterPane() {
	        
		JPanel pane = new JPanel(new GridBagLayout());
		pane.setBorder(BorderFactory.createLoweredBevelBorder());
		
		GridBagConstraints con = new GridBagConstraints();
		
		con.fill = GridBagConstraints.CENTER;
		
		scoreText = new JTextPane();
		//con.weightx = 1;
		con.gridx = 1;
		con.gridy = 3;
		scoreText.setEditable(disable);
		scoreText.setFont(new Font("Verdana", Font.PLAIN, 25));
		//pane.setConstraints(scoreText, con);
		
		pane.add(scoreText, con);
		
		return pane;
	 }
	
	
	/**
     * This method controls the JRadioButtons level buttons.
     * Helps us enable or disable all buttons for our purposes. 
     * 
     * @param func : true or false / enable or disable
     */
	public void controlLevelButtons(Boolean func){
    	
        JRadioButton[] buttons = new JRadioButton[]{easy, medium, hard};
        for (JRadioButton btn : buttons){
        	btn.setEnabled(func);
        }
    	
    }

    /**
     * This method controls the Alphabet buttons.
     * Helps us enable or disable all buttons for our purposes. 
     * 
     * @param func : true or false / enable or disable
     */
    public void controlAlphaButtons (Boolean func){
    	// when a clear game all alphabet buttons have to be disabled
        Iterator<JButton> alphaIterator = alphaButtonList.iterator();
        while(alphaIterator.hasNext()) {
            ((JButton)alphaIterator.next()).setEnabled(func);
        }    	
    }

	
	
	
    
    /**
     * Sets up a new game of "Hangman".
     */
    public void setUpNewGame() {
    	
    	// a new game starts when play button is being pressed.
    	tempWrong = 0;
        // when a new game starts all alphabet buttons have to be enabled
        controlAlphaButtons(enable);        
        // disables button new game
        newGameButton.setEnabled(disable);        
        // takes a word to play from word object !!
        targetWord = guessWords.get_word();
        
        maskedWord = "_";
        // mask the word with ___
        for( int i=0; i<targetWord.length()-1; i++) {
            maskedWord = maskedWord.concat("_");
        }        
        // show masked word / hidden word
        wordArea.setText(maskedWord);       
    }





    /**
     * Process every click on an alphabet button.
     * 
     * @param answer Will be "Α", "Β", "Γ", etc.
     */
 	public void processAnswer(String answer) {
 		// newCharacter takes the character player guessed
 	 	char newCharacter = answer.charAt(0);

 	    // Look thru the target word.
 	    // If the character matches the target, concatenate the new character.
 	    // If the character doesn't match the target, concatenate the character from the current guess.
 	    String nextGuess = "";
 	    // finds a match we have a correct char guess with true // for every alphabet button pressed
 	    boolean foundAMatch = false;
 	    // checks if the target word contains the character pressed by player
 	    for(int i=0; i<targetWord.length(); i++) {
 	       // puts the i character in a local char variable to use later
 	       char characterToMatch = targetWord.charAt(i);
 	       // finds a char Match
 	       if(characterToMatch == newCharacter) {
 	    	   nextGuess = nextGuess.concat(String.valueOf(newCharacter));
 	    	   foundAMatch = true;
 	       } else {
 	           nextGuess = nextGuess.concat(String.valueOf(maskedWord.charAt(i)));
 	       }
 	    }//for each character
        
        maskedWord = nextGuess;
        wordArea.setText(maskedWord);

        // We have a winner?
        if(maskedWord.equals(targetWord)) {
        	messageArea.setText("Συγχαρητήρια βρήκατε τη λέξη!");
        	// concatenate a player win
            newScore.addPlayerWin();        	
        	// when a game takes over show current score
            // view current score
            scoreText.setText(newScore.toString());
            
            // Disable the alphabet buttons until a new game start
            controlAlphaButtons(disable);
         
            // enables new game, level and exit buttons to start a new game
            controlLevelButtons(enable);
            newGameButton.setEnabled(enable);
            exitButton.setEnabled(enable);

        } else {
            if(!foundAMatch) {
                tempWrong++;
                wrong = wrong.concat(String.valueOf(newCharacter));
            }
            // Is the game over?
            if( tempWrong >= numberOfWrongAnswers ) {
            	
            	messageArea.setText("Λάθος! Η απάντηση ήταν " + targetWord);
            	// concatenate a computer win
                newScore.addComputerWin();
                
                // when a game takes over show current score
                // view current score
                scoreText.setText(newScore.toString());
            	
                //Disable the alphabet buttons
                controlAlphaButtons(disable);
                // enables level buttons when starts an game
                // enables new game, level and exit buttons to start a new game
                controlLevelButtons(enable);
                newGameButton.setEnabled(enable);
                exitButton.setEnabled(enable);
            }
        }
        // when a game takes over show current score
        // view current score
        scoreText.setText(newScore.toString());
        wrongCharacterGuessesArea.setText(wrong);
    }

}
