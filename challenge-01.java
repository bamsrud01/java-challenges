public class Main {
  public static void main(String[] args) {

    //  1. Create a variable to store the number of pounds
    double numPounds = 225d;

    //  2. Calculate the number of kilograms for the number and store in a variable
      //  1 pound = 0.45359237
    double convertedKilograms = numPounds * 0.45359237;
    
    //  3. Print the result
    System.out.println(numPounds + " pounds = " + convertedKilograms + " kilograms");
  }
}
