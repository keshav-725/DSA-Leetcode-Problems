class Solution {
    public int arrangeCoins(int n) {
        long sum = 0;
        int i=0;
        while(sum<n){
            int val = i+1;
            sum += val;
            i++;
        }
        if(sum==n) return i;
        return i-1;
    }
}