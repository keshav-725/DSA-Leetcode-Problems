class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        long limit = points[0][1];
        int count = 1;
        for(int i=1;i<points.length;i++){
            if(limit<points[i][0]){
                count++;
                limit = points[i][1];
            }
        }
        return count;
    }
}