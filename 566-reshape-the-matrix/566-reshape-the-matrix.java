class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length*mat[0].length!=r*c){
            return mat;
        }
        int[][] ans = new int[r][c];
        int k=0;
        int l=0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(l==mat[0].length){
                    l = 0;
                    k++;
                }
                ans[i][j] = mat[k][l];
                l++;
                
            }
        }
        return ans;
    }
}