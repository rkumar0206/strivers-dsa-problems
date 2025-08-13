package arrays.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AM9_LongestConsecutiveSequence {

    public static void main(String[] args) {

//        int[] arr = {4,7,1,0};
//        int[] arr = {100, 200, 1, 3, 2, 4};
        int[] arr = {0,3,7,2,5,8,4,6,0,1};



        int longest = findLongestConsecutiveSequenceOptimal(arr);
        System.out.println("Longest subsequence: " + longest);
    }

    private static int findLongestConsecutiveSequenceOptimal(int[] arr) {

        Set<Integer> set = new HashSet<>();

        int longest = 0;

        for (int j : arr) {
            set.add(j);
        }

        for (int num : arr) {

            if (!set.contains(num - 1)) {

                int cnt = 1;
                int n = num;

                while (set.contains(n + 1)) {
                    n++;
                    cnt++;
                }

                longest = Math.max(longest, cnt);

            }

        }

        return longest;

    }

    public static int longestSuccessiveElementsBetter(int []a) {
        int n = a.length;
        if (n == 0) return 0;

        //sort the array:
        Arrays.sort(a);
        int lastSmaller = Integer.MIN_VALUE;
        int cnt = 0;
        int longest = 1;

        //find longest sequence:
        for (int j : a) {
            if (j - 1 == lastSmaller) {
                //a[i] is the next element of the
                //current sequence.
                cnt += 1;
                lastSmaller = j;
            } else if (j != lastSmaller) {
                cnt = 1;
                lastSmaller = j;
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }
}
