package arrays.easy;

import util.Util;

public class A6_RotateArrayToLeftBy_D_Place {

    public static void main(String[] args) {

        int[] inputArray = {1, 2, 3, 4, 5};
        int[] inputArray2 = {1, 2, 3, 4, 5};

        int d = 7;

        rotateArrayBy_D_Place(inputArray, d);
        Util.printArray(inputArray, "Result array 1: ");

        rotateArrayBy_D_PlaceByReversing(inputArray2, d);
        Util.printArray(inputArray, "Result array 2: ");
    }

    private static void rotateArrayBy_D_PlaceByReversing(int[] inputArray, int d) {

        // 1. reverse first d element
        // 2. reverse remaining element
        // 3. reverse whole array

        int n = inputArray.length;
        if(d == n) return;

        d = d % n;

        reverseArray(0, d - 1, inputArray);
        reverseArray(d, n - 1, inputArray);
        reverseArray(0, n - 1, inputArray);
    }

    private static void reverseArray(int start, int end, int[] inputArray) {

        while (start < end) {
            int temp = inputArray[start];
            inputArray[start] = inputArray[end];
            inputArray[end] = temp;
            start++;
            end--;
        }
    }

    // with extra space
    private static void rotateArrayBy_D_Place(int[] inputArray, int d) {

        int n = inputArray.length;
        if(d == n) return;

        d = d % n;
        int[] temp = new int[d];

        for (int i = 0; i < d; i++) {

            temp[i] = inputArray[i];
        }

        for (int i = d; i < n; i++) {

            inputArray[i - d] = inputArray[i];
        }

        for (int i = n - d; i < n; i++) {

            inputArray[i] = temp[i - (n - d)];
        }

        // Time complexity: O(d) + O(n -d) + (d) = O(n + d)
        // Space complexity: O(d) -> space for temp[]
    }
}
