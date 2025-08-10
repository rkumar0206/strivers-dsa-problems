package arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class A12_LongestSubarrayWithGivenSum {

    public static void main(String[] args) {

//        int[] a = {2, 3, 5, 1, 9};
//        int k = 10;

//        int[] a = {2,3,5};
//        int k = 5;

        int[] a = {1, 2, 3, 1, 1, 1, 1, 3, 3};
        int k = 6;

        findLongestSubarrayWithGivenSumInitialThinking(a, a.length, k);

        findLongestSubArrayWithGivenSumForBothPositiveAndNegative(a, a.length, k); // used hashing
        findLongestSubArrayWithGivenSum(a, a.length, k); // only for positive numbers
    }

    private static void findLongestSubArrayWithGivenSumForBothPositiveAndNegative(int[] a, int n, int k) {

        Map<Long, Integer> preSumMap = new HashMap<>();

        long sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            sum += a[i];

            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            long rem = sum - k;

            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        System.out.println("Max subarray length count: " + maxLen);

    }

    private static void findLongestSubArrayWithGivenSum(int[] a, int n, int k) {

        int left = 0;
        int right = 0;

        int sum = a[0];
        int maxLen = 0;

        while (right < n) {

            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;

            if (right < n) {
                sum += a[right];
            }
        }

        System.out.println("Max subarray length count: " + maxLen);
    }

    private static void findLongestSubarrayWithGivenSumInitialThinking(int[] a, int n, int k) {

        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            int sum = a[i];
            int initialArrayLength = 1;

            for (int j = i + 1; j < n; j++) {

                sum = sum + a[j];

                if (sum < k) {
                    initialArrayLength++;
                } else if (sum == k) {
                    initialArrayLength++;
                    break;
                } else {
                    initialArrayLength = -1;
                    break;
                }
            }

            if (initialArrayLength > maxLen) {
                maxLen = initialArrayLength;
            }
        }

        System.out.println("Max subarray length count: " + maxLen);
    }
}
