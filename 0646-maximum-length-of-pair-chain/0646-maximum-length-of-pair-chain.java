class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        
        int last = Integer.MIN_VALUE,max=0;
        
        for(int []pair : pairs){
            if(last<pair[0]){
                max++;
                last = pair[1];
            }
        }
        return max;
    }
}