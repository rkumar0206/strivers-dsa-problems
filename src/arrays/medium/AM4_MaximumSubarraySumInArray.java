package arrays.medium;

import java.util.Arrays;

public class AM4_MaximumSubarraySumInArray {

    public static void main(String[] args) {

//        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr = {-2, -1, -3, -4, -1, -2, -1, -5, -4}; // algorithm fails if all elements are negative

        long ans = findMaximumSubarraySum(arr);
        System.out.println("Sum: " + ans);
    }

    private static long findMaximumSubarraySum(int[] arr) {


        long max = Long.MIN_VALUE;
        long sum = 0;

        int start = 0;
        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < arr.length; i++) {

            if (sum == 0) {
                start = i;
            }

            sum += arr[i];

            if (sum > max) {
                max = sum;

                startIndex = start;
                endIndex = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        int[] subarray = Arrays.copyOfRange(arr, startIndex, endIndex);
        System.out.println("SubArray: " + Arrays.toString(subarray));

        return max;
    }
}
