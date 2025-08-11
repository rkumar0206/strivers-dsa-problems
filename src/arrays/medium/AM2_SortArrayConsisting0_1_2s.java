package arrays.medium;

import util.Util;

public class AM2_SortArrayConsisting0_1_2s {

    public static void main(String[] args) {

        //int[] arr = {2, 0, 2, 1, 1, 0};
        //int[] arr = {2, 0, 1};
        //int[] arr = {0};
        int[] arr = {1, 0, 2}; // wrong answer with initial thinking logic

        //sortArrayInitialThinking(arr);
        sortArrayThreePointers(arr);

        Util.printArray(arr, "Result array: ");
    }

    private static void sortArrayThreePointers(int[] arr) {

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {

            if (arr[mid] == 0) {
                swapElement(arr, mid, low);
                low++;
                mid++;
            }else if (arr[mid] == 1) {
                mid++;
            }else {
                swapElement(arr, mid, high);
                high--;
            }
        }
    }

    private static void swapElement(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    private static void sortArrayInitialThinking(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            if (arr[left] > arr[right]) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                right--;
            } else if (arr[left] < arr[right]){
                left++;
            }
        }

        Util.printArray(arr, "Result array: ");

    }
}
