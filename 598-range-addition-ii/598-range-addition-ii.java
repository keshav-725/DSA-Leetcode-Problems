class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int xidx=m;
        int yidx=n;
        for(int i=0;i<ops.length;i++){
            xidx = Math.min(xidx,ops[i][0]);
            yidx = Math.min(yidx,ops[i][1]);
        }
        return xidx*yidx;
    }
}