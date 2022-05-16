class Solution {
    public int maxProfit(int[] prices) {
        int []min = new int[prices.length];
        int []max = new int[prices.length];
        int minc = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            minc = Math.min(minc,prices[i]);
            min[i] = minc;
        }
        int maxc = Integer.MIN_VALUE;
        for(int i=prices.length-1;i>=0;i--){
            maxc = Math.max(maxc,prices[i]);
            max[i] = maxc;
        }
        int profit = 0;
        
        for(int i=prices.length-2;i>=0;i--){
            profit = Math.max(profit,max[i+1]-min[i]);
        }
        return profit;
    }
}