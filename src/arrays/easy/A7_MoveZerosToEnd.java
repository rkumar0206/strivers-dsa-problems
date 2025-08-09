package arrays.easy;

import util.Util;

public class A7_MoveZerosToEnd {

    public static void main(String[] args) {

        int[] inputArray = {1, 0, 4, 3, 0, 2, 0, 1};

        moveZeroToEndInitialThinking(inputArray, inputArray.length);
        moveZeroToEndOptimal(inputArray, inputArray.length);
    }

    private static void moveZeroToEndOptimal(int[] inputArray, int n) {

        int j = -1;

        for (int i = 0; i < n; i++) {

            if (inputArray[i] == 0) {
                j = i;
                break;
            }
        }

        if (j == -1) {
            return;
        }

        for (int i = j + 1; i < n; i++) {

            if (inputArray[i] != 0) {

                int temp = inputArray[j];
                inputArray[j] = inputArray[i];
                inputArray[i] = temp;

                j++;
            }
        }

        Util.printArray(inputArray, "Result array (optimal): ");
    }

    private static void moveZeroToEndInitialThinking(int[] inputArray, int n) {

        int[] temp = new int[n];
        int k = -1;
        int numberOfZerosCount = 0;

        for (int i = 0; i < n; i++) {

            if (inputArray[i] != 0) {
                temp[++k] = inputArray[i];
            } else {
                ++numberOfZerosCount;
            }
        }

        for (int i = n - numberOfZerosCount; i < n; i++) {

            temp[i] = 0;
        }

        Util.printArray(temp, "Result array: ");

    }
}
