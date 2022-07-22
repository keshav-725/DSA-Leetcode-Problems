class Solution {
    class Pair{
        int x;
        int y;
        int dist;
        Pair(int x,int y,int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int shortestBridge(int[][] grid) {
        int ans = 0;
        LinkedList<Pair> queue = new LinkedList<>();
        boolean [][]visited = new boolean[grid.length][grid[0].length];
        boolean flag = false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    addToQueue(grid,visited,queue,i,j);
                    flag = true;
                    break;
                }
            }
            if(flag==true) break;
        }
        while(queue.size()>0){
            Pair rem = queue.removeFirst();
            if(grid[rem.x][rem.y]==1){
                ans = rem.dist;
                break;
            }
            for(int i=0;i<4;i++){
                int rowdash = rem.x + dir[i][0];
                int coldash = rem.y + dir[i][1];
                
                if(rowdash>=0 && coldash>=0 && rowdash<grid.length && coldash<grid[0].length && visited[rowdash][coldash]==false){
                    visited[rowdash][coldash] = true;
                    queue.addLast(new Pair(rowdash,coldash,rem.dist+1));
                }
            }
        }
        return ans-1;
    }
    int [][]dir = {{-1,0},{0,-1},{1,0},{0,1}};
    public void addToQueue(int[][] grid,boolean [][]visited,LinkedList<Pair> queue,int row,int col){
        queue.add(new Pair(row,col,0));
        grid[row][col]=-1;
        visited[row][col]=true;
        for(int i=0;i<4;i++){
            int rowdash = row + dir[i][0];
            int coldash = col + dir[i][1];
            
            if(rowdash>=0 && coldash>=0 && rowdash<grid.length && coldash<grid[0].length && visited[rowdash][coldash]==false && grid[rowdash][coldash]==1){
                addToQueue(grid,visited,queue,rowdash,coldash);
            }
        }
    }
}