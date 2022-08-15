class Solution {
    public int findPeakElement(int[] arr) {
        int left=0,right=arr.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            
            long lval = (mid-1)>=0 ? arr[mid-1]:Long.MIN_VALUE;
            long rval = (mid+1)<arr.length ? arr[mid+1]:Long.MIN_VALUE;
            
            if(arr[mid]>lval && arr[mid]>rval) return mid;
            
            else if(arr[mid]>lval && arr[mid]<rval) left=mid+1;
            
            else right = mid-1;
        }
        return 0;
    }
}