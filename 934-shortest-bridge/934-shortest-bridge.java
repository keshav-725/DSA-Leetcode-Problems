class Solution {
    public class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y = y;
        }
    }
    int [][]dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public int shortestBridge(int[][] grid) {
        boolean [][]visited = new boolean[grid.length][grid[0].length];
        LinkedList<Pair> pq = new LinkedList<>();
        boolean flag = false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    getAllConnectedLand(i,j,grid,visited,pq);
                    flag = true;
                    break;
                }
            }
            if(flag==true) break;
        }
        int level=0;
        while(pq.size()>0){
            int size = pq.size();
            while(size-->0){
                Pair rm = pq.removeFirst();
                for(int i=0;i<4;i++){
                    int rowdir = rm.x + dir[i][0];
                    int coldir = rm.y + dir[i][1];
                    
                    if(rowdir<0 || coldir<0 || rowdir>=grid.length || coldir>=grid[0].length || visited[rowdir][coldir]==true){
                        continue;
                    }else{
                        if(grid[rowdir][coldir]==1) return level;
                        pq.addLast(new Pair(rowdir,coldir));
                        visited[rowdir][coldir]=true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
    public void getAllConnectedLand(int i,int j,int [][]grid,boolean [][]visited,LinkedList<Pair> pq){
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || grid[i][j]==0 || visited[i][j]==true) return;
        visited[i][j]=true;
        pq.add(new Pair(i,j));
        getAllConnectedLand(i-1,j,grid,visited,pq);
        getAllConnectedLand(i+1,j,grid,visited,pq);
        getAllConnectedLand(i,j-1,grid,visited,pq);
        getAllConnectedLand(i,j+1,grid,visited,pq);
    }
}