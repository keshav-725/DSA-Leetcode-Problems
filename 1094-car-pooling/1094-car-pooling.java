class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int [][]start = Arrays.copyOf(trips,trips.length);
        int [][]end = Arrays.copyOf(trips,trips.length);
        
        Arrays.sort(start,(a,b)->Integer.compare(a[1],b[1]));
        Arrays.sort(end,(a,b)->Integer.compare(a[2],b[2]));
        int istart = 0,iend =0;
        int max=0,count=0;
        
        while(istart<trips.length){
            if(start[istart][1]<end[iend][2]){
                count+=start[istart][0];
                istart++;
            }else if(start[istart][1]>end[iend][2]){
                count-=end[iend][0];
                iend++;
            }else{
                count += start[istart][0];
                count -= end[iend][0];
                istart++;
                iend++;
            }
            max = Math.max(count,max);
        }
        return max<=capacity;
    }
}