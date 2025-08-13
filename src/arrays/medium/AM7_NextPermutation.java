package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AM7_NextPermutation {

    public static void main(String[] args) {

        //ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 3, 2));
        //ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3,2,1));
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2, 1, 5, 4, 3, 0, 0));

        rearrangeArrayWithNextPermutation(arr);
        System.out.println("Ans: " + arr);
    }

    private static void rearrangeArrayWithNextPermutation(ArrayList<Integer> arr) {

        /*
         The steps are the following:

        Find the break-point, i: Break-point means the first index i from the back of the given array where arr[i] becomes smaller than arr[i+1].
        For example, if the given array is {2,1,5,4,3,0,0}, the break-point will be index 1(0-based indexing). Here from the back of the array, index 1 is the first index where arr[1] i.e. 1 is smaller than arr[i+1] i.e. 5.
        To find the break-point, using a loop we will traverse the array backward and store the index i where arr[i] is less than the value at index (i+1) i.e. arr[i+1].
        If such a break-point does not exist i.e. if the array is sorted in decreasing order, the given permutation is the last one in the sorted order of all possible permutations. So, the next permutation must be the first i.e. the permutation in increasing order.
        So, in this case, we will reverse the whole array and will return it as our answer.
        If a break-point exists:
        Find the smallest number i.e. > arr[i] and in the right half of index i(i.e. from index i+1 to n-1) and swap it with arr[i].
        Reverse the entire right half(i.e. from index i+1 to n-1) of index i. And finally, return the array.

         */

        int n = arr.size();
        int ind = -1;

        for (int i = n - 2; i >= 0; i--) {

            if (arr.get(i) < arr.get(i + 1)) {
                ind = i;
                break;
            }
        }

        if (ind == -1) {
            // sorted in descending order, reverse to make it in natural order
            Collections.reverse(arr);
            return;
        }

        // search for the element which just greater than the ind element and swap it
        for (int i = n - 1; i > ind; i--) {

            if (arr.get(i) > arr.get(ind)) {

                int temp = arr.get(i);
                arr.set(i, arr.get(ind));
                arr.set(ind, temp);
                break;
            }
        }

        // reverse the elements after the ind value
        List<Integer> integers = arr.subList(ind + 1, n);
        Collections.reverse(integers);

    }
}
