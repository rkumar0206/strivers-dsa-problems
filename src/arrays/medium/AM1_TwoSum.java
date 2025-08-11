package arrays.medium;

import java.util.Arrays;
import java.util.HashMap;

public class AM1_TwoSum {

    public static void main(String[] args) {

        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;

        String ans = findTwoSumNumberInitialThinking(arr, target);
        ans = findTwoSumNumberOptimalSolution(arr, target);

        System.out.println(ans);
    }

    private static String findTwoSumNumberOptimalSolution(int[] arr, int target) {

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int sum = arr[left] + arr[right];
            if (sum == target) {
                return "YES";
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return "NO";
    }

    private static String findTwoSumNumberInitialThinking(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int a = -1;
        int b = -1;

        for (int i = 0; i < arr.length; i++) {

            int diff = target - arr[i];

            if (map.containsKey(diff)) {
                a = diff;
                b = arr[i];
                break;
            }

            map.put(arr[i], i);
        }


        System.out.println("First number: " + a);
        System.out.println("Second number: " + b);

        if (a == -1 & b == -1) {
            return "NO";
        } else {
            return "YES";
        }

    }
}
