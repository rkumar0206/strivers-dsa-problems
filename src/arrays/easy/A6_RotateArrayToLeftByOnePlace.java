package arrays.easy;

import util.Util;

public class A6_RotateArrayToLeftByOnePlace {

    public static void main(String[] args) {

        int[] inputArray = {1, 2, 3, 4, 5};

        rotateArrayByOnePlace(inputArray);
        Util.printArray(inputArray, "Result array: ");
    }

    private static void rotateArrayByOnePlace(int[] inputArray) {

        int temp = inputArray[0];

        for (int i = 1; i < inputArray.length; i++) {

            inputArray[i - 1] = inputArray[i];
        }
        inputArray[inputArray.length - 1] = temp;

    }
}
