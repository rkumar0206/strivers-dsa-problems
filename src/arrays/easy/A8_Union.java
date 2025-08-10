package arrays.easy;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class A8_Union {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] b = {2, 3, 4, 4, 5, 11, 12};

        printUnionOfArraysInitialThinking(a, b);
        printUnionOfArraysUsingTwoPointer(a, b);
    }

    private static void printUnionOfArraysUsingTwoPointer(int[] a, int[] b) {

        int n = a.length;
        int m = b.length;

        ArrayList<Integer> union = new ArrayList<>(Math.max(n, m));

        int i = 0;
        int j = 0;

        while (i < n && j < m) {

            if (a[i] <= b[j]) {

                if (union.isEmpty() || union.getLast() != a[i]) {
                    union.add(a[i]);
                }
                i++;
            } else {
                if (union.isEmpty() || union.getLast() != b[j]) {
                    union.add(b[j]);
                }
                j++;
            }
        }

        while (i < n) {
            if (union.getLast() != a[i]) {
                union.add(a[i]);
                i++;
            }
        }

        while (j < m) {
            if (union.getLast() != b[j]) {
                union.add(b[j]);
                j++;
            }
        }

        System.out.println("Union: " + union);
        // Time complexity: O(n+m)

    }

    private static void printUnionOfArraysInitialThinking(int[] a, int[] b) {

        int n = a.length;
        int m = b.length;

        Set<Integer> union = new TreeSet<>();

        int max = Math.max(n, m);

        for (int i = 0; i < max; i++) {

            if (i < n) {
                union.add(a[i]);
            }

            if (i < m) {
                union.add(b[i]);
            }
        }

        System.out.println("Union: " + union);

    }
}
