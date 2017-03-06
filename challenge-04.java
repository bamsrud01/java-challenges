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

    //  Changed file to use a method to print score
    calculateScore(gameOver, score, levelCompleted, bonus);
    //  Can enter values directly
    calculateScore(true, 800, 5, 100);
  }


  //  Methods must be defined outside of 'main' method, but inside the class
  public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {

    if (gameOver) {
      int finalScore = score + (levelCompleted * bonus);
      System.out.println("Your final score was " + finalScore);
      return finalScore;
    } else {
      return -1;
    }

  }

}
