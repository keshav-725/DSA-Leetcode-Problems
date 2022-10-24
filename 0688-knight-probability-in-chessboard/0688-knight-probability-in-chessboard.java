class Solution {
    public double knightProbability(int N, int step, int start_x, int start_y) {
        double [][][]dp = new double[N][N][step+1];
        dp[start_x][start_y][0] = 1;
        int [][]dirs = {{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};
        for(int move=1;move<=step;move++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    for(int []dir : dirs){
                        int x = i+dir[0];
                        int y = j+dir[1];
                        
                        if(x>=0 && x<N && y>=0 && y<N){
                            dp[x][y][move] += dp[i][j][move-1]/8;
                        }
                    }
                }
            }
        }
        double res = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                res += dp[i][j][step];
            }
        }
        return res;
    }
}