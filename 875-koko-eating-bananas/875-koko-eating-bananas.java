class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left =1,right=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            right = Math.max(piles[i],right);
        }
        int pans=-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            
            long hr=0;
            for(int i=0;i<piles.length;i++){
                hr += (piles[i]/mid);
                if(piles[i]%mid != 0){
                    hr++;
                }
            }
            if(hr>h){
                left = mid+1;
            }else{
                pans = mid;
                right = mid-1;
            }
        }
        return left;
    }
}