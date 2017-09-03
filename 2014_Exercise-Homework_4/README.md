# UOMacedonia_JavaLabs2014

"Hangman" - "Kremala" was the third program that we developed and it implements the classic HangMan Game.
Player chooses between 3 levels of dificulty to play the game.
  - Easy level : Player loses after 8 wrong answers.
  - Medium level : Player loses after 6 wrong answers.
  - Hard level : Player loses after 4 wrong answers.

Player plays against the machine and he wins when he finds the hidden word. 
The program keeps a Score. When player wins, the score becomes 1-0. If player looses, the score becomes 1-1 and so forth.
The game is consecutive. This means that a player plays loses, again and again and the score is modulated.
This score automatically is being saved and continues when the player opens the game back.
He can continue the game with this score or he can clear the score and start again from 0-0.


In simple words we had to:
- Parse a text file (with Greek text) and get words 
  - Keep only words with more than 3 characters without containing symbols or numbers 
  - Keep word once at a time (erase duplicates)
- Make a GUI that will contain:
  - All Greek characters
  - New-Game button  
  - Hidden Word TextField
  - TextField with wrong characters that was selected
  - Lifes
  - Score
- Keep the score serialized.


Third exercise:
classes:
  Main, HangManGUI, MyFileReader, Score, GameSave, Word, Level
Collections used: ArrayList<String>,
No Inheritance, NO Polymorphism,
GUI creation
Implements Serialization


Java code is full of comments and JavaDocs.
Exercise pronunciation is included in Greek.
Some screenshots are included.

Full java code explanation (in Greek) at the following link:
http://greekitedu.blogspot.gr/2015/03/uom-java-ex4-election-simulator-photos.html

