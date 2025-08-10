package arrays.easy;

import java.util.Arrays;

public class A9_FindMissingNumber {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 6, 7, 8, 9, 10};

        findMissingNumberInitialThinking(a, a.length + 1);
    }

    private static void findMissingNumberInitialThinking(int[] a, int n) {

        int sum = Arrays.stream(a).sum();
        int sumOfnNumbers = n * (n + 1) / 2;

        System.out.println("Missing number: " + (sumOfnNumbers - sum));
    }

}
