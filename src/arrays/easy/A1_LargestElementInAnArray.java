package arrays.easy;

import java.util.Arrays;
import java.util.OptionalInt;

public class A1_LargestElementInAnArray {

    public static void main(String[] args) {

        int[] inputArray = {8, 10, 5, 7, 9};

        //brute force:
        // sort the array in ascending order and print the last element

        // using loop
        findLargest(inputArray);

        // using stream API
        findUsingStream(inputArray);

    }

    private static void findUsingStream(int[] inputArray) {

        OptionalInt max = Arrays.stream(inputArray).max();
        System.out.println("Largest by stream: " + max.getAsInt());

    }

    private static void findLargest(int[] inputArray) {

        int largest = inputArray[0];

        for (int i = 0; i < inputArray.length - 1; i++) {

            if (inputArray[i] > largest) {
                largest = inputArray[i];
            }
        }

        System.out.println("Largest element is: " + largest);

    }
}
