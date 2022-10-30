class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left =1,right=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            right = Math.max(piles[i],right);
        }
        
        int pans = piles.length;
        
        while(left<=right){
            
            int mid = left + (right-left)/2;
            
            long time = getTime(piles,mid);
            
            if(time<=h){
                pans = mid;
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }
        return pans;
    }
    public long getTime(int []piles,int mid){
        long count = 0;
        for(int pile : piles){
            count += pile/mid;
            if(pile%mid != 0) count++;
        }
        return count;
    }
}