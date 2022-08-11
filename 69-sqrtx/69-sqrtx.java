class Solution {
    public int mySqrt(int x) {
        int left =1,right=x;
        int pans=0;
        while(left<=right){
            int mid = left + (right-left)/2;
            int val = x/mid;
            if(mid<=val){
                pans = mid;
                left = mid+1;
            }
            else right = mid-1;
            
        }
        return pans;
    }
}