class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            int diff = arr[mid] - (mid+1);
            if(diff < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if(high==-1) return k;
        return arr[high] + (low - arr[high] + k);
    }
}