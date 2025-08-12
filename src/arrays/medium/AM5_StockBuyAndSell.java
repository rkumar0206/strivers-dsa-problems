package arrays.medium;

public class AM5_StockBuyAndSell {

    public static void main(String[] args) {

//        int[] arr = {7, 1, 5, 3, 6, 4};
//        int[] arr = {7,6,4,3,1};
        int[] arr = {2, 1, 2, 1, 0, 1, 2};

        //int ans = findMaximumProfitInitialThinking(arr);
        int ans = findMaximumProfitOptimal(arr);
        System.out.println("Max Profit: " + ans);
    }

    private static int findMaximumProfitOptimal(int[] arr) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int j : arr) {

            minPrice = Math.min(minPrice, j);
            maxProfit = Math.max(maxProfit, j - minPrice);

        }

        return maxProfit;

    }

    private static int findMaximumProfitInitialThinking(int[] arr) {

        int profit = 0;
        int i = 0;
        int j = 1;

        while (i <= j && j < arr.length) {

            if (arr[i] > arr[j]) {
                i = j;
                j++;
            } else if (arr[i] < arr[j]) {
                profit = Math.max(profit, (arr[j] - arr[i]));
                j++;
            } else {
                j++;
            }
        }

        return profit;

    }
}
