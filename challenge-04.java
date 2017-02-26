public class main {

  public static void main(String[] args) {
    //  Print out a score to the screen with the following:
      //  Score of 10000
      //  Completed level 8
      //  Bonus set to 200
    boolean gameOver = true;
    int score = 10000;
    int levelCompleted = 8;
    int bonus = 200;

    if (gameOver) {
      int finalScore = score + (levelCompleted * bonus);
      System.out.println("Your final score was " + finalScore);
    }
  }
}
