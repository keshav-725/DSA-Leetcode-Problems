class Solution {
    public class Pair implements Comparable<Pair>{
        int x;
        int y;
        int dist;
        Pair(int x,int y,int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        public int compareTo(Pair o){
            return this.dist-o.dist;
        }
    }
    int [][]dir = {{-1,0},{0,-1},{1,0},{0,1}};
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        boolean [][]visited = new boolean[grid.length][grid[0].length];
        queue.add(new Pair(0,0,grid[0][0]));
        int max = 0;
        visited[0][0]=true;
        while(queue.size()>0){
            Pair rem = queue.remove();
            max = Math.max(max,rem.dist);
            // System.out.println(rem.dist);
            if(rem.x == grid.length-1 && rem.y == grid[0].length-1){
                break;
            }
            for(int i=0;i<4;i++){
                int nrow = rem.x + dir[i][0];
                int ncol = rem.y + dir[i][1];
                
                if(nrow>=0 && ncol >=0 && nrow < grid.length && ncol<grid[0].length && visited[nrow][ncol]==false){
                    visited[nrow][ncol]=true;
                    queue.add(new Pair(nrow,ncol,grid[nrow][ncol]));
                }
            }
        }
        return max;
    }
}