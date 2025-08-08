package arrays.easy;

import java.util.Arrays;

public class RemoveDuplicatesInPlaceFromSortedArray {

    public static void main(String[] args) {

        int[] inputArray = {1, 1, 2, 2, 2, 3, 3};

        int uniqueElement = removeDuplicateAndGetNumberOfUniqueElements(inputArray);

        System.out.println("Unique elements: " + uniqueElement);
        System.out.println("Result array: " + Arrays.toString(inputArray));
    }

    private static int removeDuplicateAndGetNumberOfUniqueElements(int[] inputArray) {

        int i = 0;
        for (int j = 1; j < inputArray.length; j++) {

            if (inputArray[i] != inputArray[j]) {
                i++;
                inputArray[i] = inputArray[j];
            }
        }

        return i + 1;
    }
}
