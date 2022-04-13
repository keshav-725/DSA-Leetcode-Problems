class Solution {
    public int[][] generateMatrix(int n) {
        int value = 1;
        int i=0,j=0,init=0;
        int total = n*n;
        int [][]arr = new int[n][n];
        while(value<=total){
            while(j<n){
                arr[i][j]=value;
                value++;
                j++;
            }
            i++;
            j--;
            while(i<n){
                arr[i][j]=value;
                value++;
                i++;
            }
            j--;
            i--;
            while(j>=init){
                arr[i][j]=value;
                value++;
                j--;
            }
            i--;
            j++;
            while(i>=init+1){
                arr[i][j]=value;
                value++;
                i--;
            }
            j++;
            i++;
            n--;
            init++;
        }
        return arr;
    }
}