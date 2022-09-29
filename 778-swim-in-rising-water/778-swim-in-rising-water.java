class Solution {
    int [][]dir = {{-1,0},{0,-1},{1,0},{0,1}};
    class Pair implements Comparable<Pair>{
        int x,y,time;
        Pair(int x,int y,int time){
            this.x = x;
            this.y=y;
            this.time = time;
        }
        public int compareTo(Pair other){
            return this.time - other.time;
        }
    }
    public int swimInWater(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean [][]visited = new boolean[row][col];
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0,0,grid[0][0]));
        visited[0][0]=true;
        int max = -1;
        while(queue.size()>0){
            Pair rem = queue.poll();
            // System.out.println(rem.x +" " + rem.y+" " +rem.time);
            max = Math.max(max,rem.time);
            if(rem.x==row-1 && rem.y==col-1) return max;
            
            for(int j=0;j<dir.length;j++){
                int nrow = rem.x + dir[j][0];
                int ncol = rem.y + dir[j][1];
                
                if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && visited[nrow][ncol]==false){
                    visited[nrow][ncol]=true;
                    queue.add(new Pair(nrow,ncol,grid[nrow][ncol]));
                }
            }
        }
        return -1;
    }
    
}