package util;

import java.util.Arrays;

public class Util {

    public static void printArray(int[] arr, String prefix) {

        prefix = (prefix == null || prefix.isEmpty()) ? "Arrays: " : prefix;
        System.out.println(prefix + Arrays.toString(arr));
    }

}
