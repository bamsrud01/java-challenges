public class Main {
  public static void main(String[] args) {
    //  1.  Set starting values
    double firstValue = 20d;
    double secondValue = 80d;
    //  2.  Find the remainder of the outcome
    double outcome = (firstValue + secondValue) * 50;
    double remainder = outcome % 40;
    //  3.  Determine if it is over the limit or not
    double limit = 20;
    if (remainder >= limit)
      System.out.println("Total was over the limit!");
  }
}
