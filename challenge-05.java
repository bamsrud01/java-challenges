public class main {

  public static void main(String[] args) {
    double centimeters = calculateCentimeters(5, 11);
    double moreCentimeters(100);
  }

  //  calculateCentimeters() is overloaded
  public static double calculateCentimeters(double feet, double inches) {
    //  Make sure feet and inches are valid values
    if ((feet < 0 || inches < 0) || inches > 12) {
      System.out.println("Invalid values given");
      return -1;
    }
    double centimeters = (feet * 12) * 2.54;
    centimeters += inches * 2.54;
    System.out.println(feet + " feet, " + inches + " inches = " centimeters + "cm");
    return centimeters;
  }

  //  Note that this version of the function calls the one with two arguments
  public static double calculateCentimeters(double inches) {
    if (inches < 0) {
      System.out.println("Invalid value given");
      return -1;
    }
    double feet = (int) inches / 12;
    double remainingInches = (int) inches % 12;
    System.out.println(inches + " inches is equal to " + feet " feet and " + remainingInches + " inches");
    return calculateCentimeters(feet, remainingInches);
  }

}
