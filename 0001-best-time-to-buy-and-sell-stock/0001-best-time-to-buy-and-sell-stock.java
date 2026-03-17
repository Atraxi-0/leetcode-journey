class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1) return 0;
        int arr[] = new int[prices.length]; 
        int index = 0;
        for (int i=1; i<prices.length; i++) {
            if(prices[index]<prices[i]) {
                arr[i] = prices[i] - prices[index];
            } else {
                index = i;
                arr[i] = 0;
            }
        }
        return Arrays.stream(arr).max().getAsInt();
    }
}