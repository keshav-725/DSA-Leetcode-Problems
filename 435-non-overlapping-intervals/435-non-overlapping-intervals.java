class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int count = 0;
        int left = intervals[0][0];
        int right = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<right){
                if(intervals[i][1]<=right){
                    right = intervals[i][1];
                }
                count++;
            }
            else{
                right = intervals[i][1];
            }
        }
        return count;
    }
}