class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer,PriorityQueue<Integer>>map=new HashMap<>();
        
        int m=mat.length;
        int n=mat[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                PriorityQueue<Integer> p=map.getOrDefault(i-j,new PriorityQueue<Integer>());
                p.add(mat[i][j]);
                map.put((i-j),p);
            }
        }
        
          for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                PriorityQueue<Integer> p=map.get(i-j);
                mat[i][j]=p.poll();
            }
        }
        
        return mat;
    }
}