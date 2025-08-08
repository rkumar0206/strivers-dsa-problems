package arrays.easy;

import java.util.Arrays;

public class A2_SecondLargestElementInAnArray {

    public static void main(String[] args) {

        int[] inputArray = {8, 10, 5, 7, 9};

        //brute force:
        // sort the array in ascending order and print the second last element

        // using loop
        findSecondLargest(inputArray);
        findSecondSmallest(inputArray);

        // using stream API
        findUsingStream(inputArray);

    }

    private static void findSecondSmallest(int[] inputArray) {

        int smallest = inputArray[0];
        int secondSmallest = smallest;

        for (int j : inputArray) {

            if (j < smallest) {
                secondSmallest = smallest;
                smallest = j;
            } else if (j < secondSmallest) {
                secondSmallest = j;
            }
        }

        System.out.println("Second smallest element is: " + secondSmallest);

    }

    private static void findUsingStream(int[] inputArray) {

        // first way
        Integer secondLargestElement = Arrays.stream(inputArray)
                .boxed()
                .distinct()
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst().get();


        Integer secondLargestElementOtherStreamMethods = Arrays.stream(inputArray)
                .boxed()
                .distinct()
                .sorted((a, b) -> b - a)
                .limit(2)
                .min(Integer::compareTo).get();

        System.out.println("Second largest using stream: " + secondLargestElementOtherStreamMethods);
    }

    private static void findSecondLargest(int[] inputArray) {

        int largest = inputArray[0];
        int secondLargest = largest;

        for (int j : inputArray) {

            if (j > largest) {
                secondLargest = largest;
                largest = j;
            } else if (j > secondLargest) {
                secondLargest = j;
            }
        }

        System.out.println("Second Largest element is: " + secondLargest);

    }
}
