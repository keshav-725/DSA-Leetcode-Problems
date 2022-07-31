class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> merged = new ArrayList<int[]>();
        
        for (int[] interval : intervals) {
            
            //If there is no merging and newInterval is smaller(in ascending order) than interval so we add newInterval
            if (interval[0] > newInterval[1]) {
                merged.add(newInterval);
                newInterval = interval;
            }
            
            //If there is no merging and newInterval is larger(in ascending order) than interval so we add interval
            else if (interval[1] < newInterval[0]) {
                merged.add(interval);
            } 
            //If there is merging and so we update newInterval as we are adding it in on line 24
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        merged.add(newInterval);
        
        return merged.toArray(new int[0][]);
    }
}