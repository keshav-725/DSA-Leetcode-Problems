class Solution {
    public class Pair{
        int x;
        int y;
        int dist;
        Pair(int x,int y,int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    int [][]dir = {{-1,0},{0,-1},{1,0},{0,1}};
    public int maxDistance(int[][] mat) {
        LinkedList<Pair> queue = new LinkedList<>();
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    queue.add(new Pair(i,j,0));
                }
            }
        }
        while(queue.size()>0){
            Pair rem = queue.removeFirst();
            for(int i=0;i<4;i++){
                int nrow = rem.x + dir[i][0];
                int ncol = rem.y + dir[i][1];
                
                if(nrow>=0 && ncol >=0 && nrow < mat.length && ncol<mat[0].length && mat[nrow][ncol]==0){
                    mat[nrow][ncol]=1;
                    ans = Math.max(ans,rem.dist+1);
                    queue.add(new Pair(nrow,ncol,rem.dist+1));
                }
            }
        }
        return ans==Integer.MIN_VALUE?-1:ans;
    }
}