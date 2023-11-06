/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;

public class PhraseSolver
{
  /* your code here - attributes */
  Player player1;
  Player player2;
  Board board;
  Boolean solved;


  /* your code here - constructor(s) */ 
  public PhraseSolver() {
    player1 = new Player();
    player2 = new Player();
    board = new Board();
    solved = false;

  }
  /* your code here - accessor(s) */
  public Player getPlayer(int i) {
    if (i == 1) {
      return player1;
    } else if (i == 2) {
      return player2;
    }
    return player2;
  }

  /* your code here - mutator(s)  */

  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;
    Scanner input = new Scanner(System.in);
    String guessedLetters = " ";

    //boolean correct = true;
    while (!solved) 
    {  
      
      board.setLetterValue();
      System.out.println("");
      System.out.println(".・゜゜・　.　・゜゜・．.・゜゜・　.　・゜゜・．");
      System.out.println("Next letter amount: " + board.getCurrentLetterVal());
      
      // Shows which player's turn it is
      System.out.println("Current Player: " + getPlayer(currentPlayer).getName());

      // Asks player to guess a letter
      System.out.print("Guess a letter or the phrase: ");
      String guess = input.nextLine(); 
      solved = board.isSolved(guess);
      System.out.println("");
      
      // Checks if player guessed correctly
      if (board.guessLetter(guess) && guess.length() == 1 && !(guessedLetters.contains(guess))){

        System.out.println("Correct!");
        getPlayer(currentPlayer).setPoints(board.getCurrentLetterVal()); // adds points to current player's score
      
      }
      // checks if they guessed entire phrase
      else if (board.isSolved(guess)) {
        System.out.println(getPlayer(currentPlayer).getName() + " wins!");
        getPlayer(currentPlayer).setPoints(1500); // adds points to current player's score
        solved = true;
        
      } else if (guessedLetters.contains(guess)) {
        System.out.println("That letter has been guessed already.");
      }
      
      else {
        System.out.println("Incorrect guess.");
      }
      guessedLetters += guess;
      
      System.out.println("");
      System.out.println("Points: " + getPlayer(currentPlayer).getPoints());

      String phraseProgress = "";
      String[] phrase = board.getPhrase().split("");
      
      for (String letter : phrase) {
        if (guessedLetters.contains(letter)) {
          phraseProgress += letter; 
        } 
        else if (letter.equals(" ")) {
          phraseProgress += " ";
        } 
        else {
          phraseProgress += "_";
        }
      }
      
      System.out.println("");
      System.out.println(phraseProgress);

      if (!phraseProgress.contains("_")) {
        System.out.println("");
        System.out.println(getPlayer(currentPlayer).getName() + " wins!");
        solved = true;
      }

      // Switches players
      if (currentPlayer == 1) {
        currentPlayer = 2;
      } else {
        currentPlayer = 1;
      }
  
    } 

  }

}