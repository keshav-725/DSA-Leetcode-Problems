class Solution {
    public class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    int [][]dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        LinkedList<Pair> queue = new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    queue.add(new Pair(i,j));
                }else{
                    mat[i][j]=-1;
                }
            }
        }
        while(queue.size()>0){
            Pair rem = queue.removeFirst();
            for(int i=0;i<dir.length;i++){
                int rowdash = rem.x + dir[i][0];
                int coldash = rem.y + dir[i][1];
                
                if(rowdash>=0 && coldash>=0 && rowdash<mat.length && coldash<mat[0].length && mat[rowdash][coldash]<0){
                    queue.addLast(new Pair(rowdash,coldash));
                    mat[rowdash][coldash] = mat[rem.x][rem.y]+1;
                }
            }
        }
        return mat;
    }
}