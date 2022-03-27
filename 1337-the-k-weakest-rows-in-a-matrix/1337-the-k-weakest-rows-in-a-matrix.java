class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ones = new int[mat.length];
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 1)  {
                    ones[i]++;
                }
            }
        }
        
        int[] cl = ones.clone();
        Arrays.sort(cl);
        int[] res = new int[k];
        boolean[] v = new boolean[mat.length];
        Arrays.fill(v, false);
        for(int i=0; i<k; i++){
            for(int j=0; j<ones.length; j++){
                if(cl[i] == ones[j] && !v[j]){
                    res[i] = j;
                    v[j] = true;
                    break;
                }
            }
        }
        return res;
    }
}