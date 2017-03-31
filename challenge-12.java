//  Import scanner utility
import java.util.Scanner;

public class Main {
    //  Create scanner instance
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //  Get integers from user
        int[] myIntegers = getIntegers(5);
        //  Sort integers
        int[] sorted = sortIntegers(myIntegers);
        //  Print sorted values
        printArray(sorted);

    }

    //  Method to get integers from user
    public static int[] getIntegers(int capacity) {
        int[] array = new int[capacity];
        System.out.println("Enter " + capacity + " integers!\r");
        //  Accept integers from scanner for length of array
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    //  Method to print array
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + ": " + array[i]);
        }
    }

    //  Method to sort array of integers
    public static int[] sortIntegers(int[] array) {
        //  Create a copy of the accepted array which will hold sorted values
        int[] sortedArray = Arrays.copyOf(array, array.length);

        //  Helper variables for sorting
        boolean flag = true;
        int temp;
        //  While loop for sorting array
        while(flag) {
            flag = false;   //  Ends loop unless following conditional is true
            for (int i = 0; i < sortedArray.length - 1; i++) {
                //  Compares element with the next element, swapping values if conditions are met
                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];      //  Hold value of that element
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }
}
