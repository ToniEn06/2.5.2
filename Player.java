/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  private String name = "";
  private int points;

  /* your code here - constructor(s) */ 
  public Player() {
    System.out.print("Please enter a name: ");
    Scanner sc = new Scanner(System.in);
    name = sc.nextLine();
    System.out.println("Welcome to the game, " + name + ".");
    points = 0;
  }

  public Player(String inputName) {
    name = inputName;
    points = 0;
  }
  /* your code here - accessor(s) */ 
  public String getName() {
    return name;
  }

  public int getPoints() {
    return points;
  }
  /* your code here - mutator(s) */ 

  public int setPoints(int points) {
    return this.points += points;
  }
}