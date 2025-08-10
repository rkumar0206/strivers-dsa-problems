package arrays.easy;

import java.util.HashMap;
import java.util.Set;

public class A11_NumberThatAppearsOnce {

    public static void main(String[] args) {

        int[] a = {7, 4, 7, 1, 2, 1, 2, 5, 5};

        findNumberThatAppearsOnceInitialThinking(a, a.length);
        findNumberThatAppearsOnceXORMethod(a, a.length);
    }

    private static void findNumberThatAppearsOnceXORMethod(int[] a, int length) {

        // XOR properties:
        // XOR of two same numbers is always 0 i.e. a ^ a = 0. ←Property 1.
        // XOR of a number with 0 will result in the number itself i.e. 0 ^ a = a.  ←Property 2

        /*
            Assume the given array is: [4,1,2,1,2]
            XOR of all elements = 4^1^2^1^2
                    = 4 ^ (1^1) ^ (2^2)
                    = 4 ^ 0 ^ 0 = 4^0 = 4
            Hence, 4 is the single element in the array.
        */

        int xor = 0;

        for (int i = 0; i < length; i++) {
            xor = xor ^ a[i];
        }
        System.out.println("Number that appear once: " + xor);
    }

    private static void findNumberThatAppearsOnceInitialThinking(int[] a, int n) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            Integer num = map.get(a[i]);

            if (num == null) {
                map.put(a[i], 1);
            } else {
                map.remove(a[i]);
            }
        }

        Set<Integer> integers = map.keySet();
        System.out.println("Number that appear once: " + integers.stream().findFirst().get());
    }
}
