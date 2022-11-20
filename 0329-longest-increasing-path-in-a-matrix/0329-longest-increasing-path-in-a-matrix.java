class Solution {
    int ans;
    public int longestIncreasingPath(int[][] matrix) {
        Integer [][]visited = new Integer[matrix.length][matrix[0].length];
        ans = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                // System.out.println(i+" - "+j+" -----------------------------");
                int val = getMaxLength(i,j,matrix,visited,Integer.MIN_VALUE);
                ans = Math.max(ans,val);
            }
        }
        return ans;
    }
    public int getMaxLength(int i,int j,int [][]matrix,Integer[][] visited,int pval){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || matrix[i][j]<=pval) return 0;
        
        if(visited[i][j]!=null) return visited[i][j];
        
        // System.out.println(i+" -> "+j+" -> "+matrix[i][j]);
        
        
        int up = getMaxLength(i-1,j,matrix,visited,matrix[i][j]);
        int left = getMaxLength(i,j-1,matrix,visited,matrix[i][j]);
        int down = getMaxLength(i+1,j,matrix,visited,matrix[i][j]);
        int right = getMaxLength(i,j+1,matrix,visited,matrix[i][j]);
        
        int mval = Math.max(Math.max(up,down),Math.max(left,right))+1;
        
        return visited[i][j]=mval;
    }
}