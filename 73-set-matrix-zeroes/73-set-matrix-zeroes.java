class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        int nrow = matrix.length;
        int ncol = matrix[0].length;
        for(int i=0;i<nrow;i++){
            for(int j=0;j<ncol;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int i=0;i<nrow;i++){
            for(int j=0;j<ncol;j++){
                if(row.contains(i)){
                    matrix[i][j]=0;
                }else{
                    if(col.contains(j)){
                        matrix[i][j]=0;
                    }
                }
            }
        }
    }
}