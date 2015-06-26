package kremalajavalabs;

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 * Well, it took me more than i was expecting.
 * 
 * Hangman, finally, has been finished.
 * 
 * Basics:
 * The game takes a word from a given text file and leave the player
 * to guess every character of this word. It has 3 levels easy with 8, medium with 6 and hard with 4 allowable wrong guesses,
 * The game is consecutive. This means that a player plays loses, again and again and the score is modulated.
 * This score automatically is being saved and continues when the player opens the game back.
 * He can continue the game with this score or he can clear the score and start again from 0-0.
 * 
 * 
 * Program:
 * The program starts and constructs the basic components.
 * When GUI and Game are ready user is prompted to press New Game button.
 * Like this the game starts and uses all the classes for the best result.
 * 
 * Enjoy!!!
 * Have fun!!!
 * 
 * 30/12/2014
 * @author CHARALAMPOS VAIRLIS
 *
 */
public class Main {


    /**
	 * Everything starts from here.
	 * 
	 * @param args
	 * BorderLayout Demo Project oracle.com
	 * more at: http://docs.oracle.com/javase/tutorial/displayCode.html?code=http://docs.oracle.com/javase/tutorial/uiswing/examples/layout/BorderLayoutDemoProject/src/layout/BorderLayoutDemo.java
	 */
	public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CreateTopLevelFrame();
            }

			private void CreateTopLevelFrame() {
				
				JFrame frame = new JFrame("йяелака");
		        frame.setSize(1200, 250);
		      	       
		        HangmanGUI hangApp = new HangmanGUI();
		        
		        Component contents = hangApp.createComponents();

		        frame.getContentPane().add(contents);

		        //Finish setting up the frame, and show it.
		        frame.addWindowListener(new WindowAdapter() {
		            public void windowClosing(WindowEvent e) {
		            	hangApp.saveGame();
		                System.exit(0);
		            }
		        });
		        // frame.pack() causes problems here so we don't use it
		        
		        frame.setVisible(true);
		        //frame.setResizable(false); optional
			}
        });
    }
	
}
