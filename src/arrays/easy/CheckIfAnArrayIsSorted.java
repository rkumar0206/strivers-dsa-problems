package arrays.easy;

import java.util.stream.IntStream;

public class CheckIfAnArrayIsSorted {

    public static void main(String[] args) {

        //int[] inputArray =  {1,2,3,4,5};
        int[] inputArray = {5, 4, 6, 7, 8};

        //checkIfArrayIsSorted(inputArray);

        checkUsingStream(inputArray);
    }

    private static void checkUsingStream(int[] inputArray) {

        boolean isSortedAscending = IntStream.range(0, inputArray.length - 1) // in range end is exclusive therefore range created will be 0, 1, 2, 3 for 5 elements
                .allMatch(i -> inputArray[i] <= inputArray[i + 1]);

        if (isSortedAscending) {
            System.out.println("Array is sorted");
        } else {
            System.out.println("Array is NOT sorted.");
        }
    }

    private static void checkIfArrayIsSorted(int[] inputArray) {

        boolean isSorted = true;

        for (int i = 0; i < inputArray.length; i++) {

            if ((i + 1) != inputArray.length) {

                if (inputArray[i] > inputArray[i + 1]) {

                    isSorted = false;
                    break;
                }
            }
        }

        if (isSorted) {
            System.out.println("Array is sorted");
        } else {
            System.out.println("Array is NOT sorted.");
        }

    }
}
