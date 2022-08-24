class Solution {
    public int arrangeCoins(int n) {
        long sum = 0;
        long left =1,right = n,ans=1;
        while(left<=right){
            long mid = left + (right-left)/2;
            
            sum = ((mid)*(mid+1))/2;
            
            if(sum == n) return (int)mid;
            else if(sum>n){
                right = mid-1;
            }else{
                left = mid+1;
                ans = mid;
            }
        }
        return (int)ans;
    }
}