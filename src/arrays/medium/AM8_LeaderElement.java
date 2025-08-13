package arrays.medium;

import java.util.ArrayList;
import java.util.Collections;

public class AM8_LeaderElement {

    public static void main(String[] args) {

//        int[] arr = {4,7,1,0};
        int[] arr = {10, 22, 12, 3, 0, 6};

        ArrayList<Integer> ans = findLeaderElements(arr);
        System.out.println("Ans array: " + ans);
    }

    private static ArrayList<Integer> findLeaderElements(int[] arr) {

        int n = arr.length;
        int max = arr[n - 1];
        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(max);

        for (int i = n - 2; i >= 0; i--) {

            if (arr[i] > max) {

                max = arr[i];
                ans.add(max);
            }
        }

        ans.sort(Collections.reverseOrder());

        return ans;
    }
}
