class Solution {
    int [][]dir = {{-1,0},{0,-1},{1,0},{0,1}};
    class Pair{
        int x,y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public int shortestBridge(int[][] grid) {
        LinkedList<Pair> queue = new LinkedList<>();
        boolean [][]visited = new boolean[grid.length][grid[0].length];
        boolean check = false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    check=true;
                    addToQueue(visited,queue,grid,i,j);
                    break;
                }
            }
            if(check==true) break;
        }
        int level=-1;
        while(queue.size()>0){
            int size = queue.size();
            level++;
            while(size-->0){
                Pair rem = queue.removeFirst();
                for(int i=0;i<dir.length;i++){
                    int nrow = rem.x + dir[i][0];
                    int ncol = rem.y + dir[i][1];
                    
                    if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && visited[nrow][ncol]==false){
                        if(grid[nrow][ncol]==1) return level;
                        visited[nrow][ncol]=true;
                        queue.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
        return -1;
    }
    public void addToQueue(boolean [][]visited,LinkedList<Pair> queue,int[][] grid,int row,int col){
        if(row<0 || col<0 || row>= grid.length || col>= grid[0].length || visited[row][col]==true || grid[row][col]==0) return;
        
        visited[row][col] = true;
        queue.addLast(new Pair(row,col));
        // System.out.println("row-> "+row + " col-> "+col);
        
        addToQueue(visited,queue,grid,row+1,col);
        addToQueue(visited,queue,grid,row-1,col);
        addToQueue(visited,queue,grid,row,col+1);
        addToQueue(visited,queue,grid,row,col-1);
    }
}