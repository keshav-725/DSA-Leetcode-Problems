class Solution {
    public class Pair{
        int x,y,time;
        Pair(int x,int y,int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    int [][]dir = {{-1,0},{0,-1},{1,0},{0,1}};
    public int orangesRotting(int[][] grid) {
        LinkedList<Pair> queue = new LinkedList<>();
        int wor = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.addLast(new Pair(i,j,0));
                }else if(grid[i][j]==1) wor++;
            }
        }
        if(wor==0) return 0;
        boolean [][]visited = new boolean[grid.length][grid[0].length];
        int vwor=0;
        int time = -1;
        while(queue.size()>0){
            int size=queue.size();
            while(size-->0){
                Pair rem = queue.removeFirst();
                time = Math.max(time,rem.time);
                for(int k=0;k<dir.length;k++){
                    int nrow = rem.x + dir[k][0];
                    int ncol = rem.y + dir[k][1];
                    
                    if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && visited[nrow][ncol]==false && grid[nrow][ncol]==1){
                        queue.addLast(new Pair(nrow,ncol,rem.time+1));
                        visited[nrow][ncol] = true;
                        vwor++;
                    }
                }
            }
        }
        if(wor==vwor) return time;
        return -1;
    }
}