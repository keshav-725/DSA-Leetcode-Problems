class Solution {
    public int findLongestChain(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int count = 0;
        int limit = Integer.MIN_VALUE;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]>limit){
                count++;
                limit = intervals[i][1];
            }
        }
        return count;
    }
}