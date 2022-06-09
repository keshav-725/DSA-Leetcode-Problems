class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=i+1;j<col;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int j=0;j<col/2;j++){
            for(int i=0;i<row;i++){
                int temp = matrix[i][col-j-1];
                matrix[i][col-j-1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        
    }
}