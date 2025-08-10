package arrays.easy;

public class A10_CountMaxConsecutiveOnes {

    public static void main(String[] args) {

        int[] a = {1, 0, 1, 1, 0, 1};

        countMaxConsecutiveOnesInitialThinking(a, a.length);
    }

    private static void countMaxConsecutiveOnesInitialThinking(int[] a, int length) {

        int maxConsecutive = 0;
        int previousMaxCount = 0;

        for (int i = 0; i < length; i++) {

            if (a[i] == 1) {
                maxConsecutive++;
            } else {
                previousMaxCount = maxConsecutive;
                maxConsecutive = 0;
            }
        }

        System.out.println("Max consecutive one: " + (Math.max(previousMaxCount, maxConsecutive)));
    }

}
