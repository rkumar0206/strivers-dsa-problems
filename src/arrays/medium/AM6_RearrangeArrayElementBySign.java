package arrays.medium;

import util.Util;

public class AM6_RearrangeArrayElementBySign {

    public static void main(String[] args) {

        int[] arr = {3, 1, -2, -5, 2, -4};

        int[] ans = rearrangeElementBySign(arr);
        Util.printArray(ans, "Result array: ");
    }

    private static int[] rearrangeElementBySign(int[] arr) {

        int posIndex = 0;
        int negIndex = 1;

        int[] ans = new int[arr.length];

        for (int j : arr) {

            if (j < 0) {
                ans[negIndex] = j;
                negIndex += 2;
            } else {
                ans[posIndex] = j;
                posIndex += 2;
            }
        }

        return ans;
    }
}
