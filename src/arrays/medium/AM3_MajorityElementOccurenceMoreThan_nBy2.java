package arrays.medium;

import java.util.HashMap;

public class AM3_MajorityElementOccurenceMoreThan_nBy2 {

    public static void main(String[] args) {

        //int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int[] arr = {3,2,3};
        //int[] arr = {4, 4, 2, 4, 3, 4, 4, 3, 2, 4};

        //Integer result = findMajorityElementInitialThinking(arr);
        Integer result = findMajorityElementOptimalApproach(arr);
        System.out.println("Result: " + result);
    }

    private static Integer findMajorityElementOptimalApproach(int[] arr) {

        int cnt = 0;
        int element = arr[0];


        for (int k : arr) {

            if (cnt == 0) {
                cnt++;
                element = k;
            } else if (k == element) {
                cnt++;
            } else {
                cnt--;
            }
        }

        // if in question it is stated that there will be always an answer then we don't need to check below;

        cnt = 0;
        for (int j : arr) {

            if (j == element) {
                cnt++;
            }
        }

        if (cnt > arr.length / 2) {
            return element;
        }

        return -1;

    }

    private static Integer findMajorityElementInitialThinking(int[] arr) {

        int nBy2 = arr.length / 2;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j : arr) {

            if (map.containsKey(j)) {

                Integer i1 = map.get(j);
                ++i1;
                if (i1 > nBy2) {
                    return j;
                }
                map.put(j, i1);
            } else {
                map.put(j, 1);
            }
        }

        return 0;
    }
}
