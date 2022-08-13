class Solution {
    public int shipWithinDays(int[] A, int M) {
        int N = A.length;
        int left = Integer.MIN_VALUE,right=0;
        for(int i=0;i<N;i++){
            right += A[i];
            left = Math.max(left,A[i]);
        }
        int pans=-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            
            int person = 1;
            int sum = 0;
            for(int i=0;i<N;i++){
                sum += A[i];
                if(sum>mid){
                    sum = A[i];
                    person++;
                }
            }
            if(person>M){
                left = mid+1;
            }else{
                right = mid-1;
                pans = mid;
            }
        }
        return pans;
    }
}