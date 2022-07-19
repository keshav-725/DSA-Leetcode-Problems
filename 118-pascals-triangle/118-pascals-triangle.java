class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            temp1 = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    temp1.add(1);
                }else{
                    temp1.add(prev.get(j-1)+prev.get(j));
                }
            }
            ans.add(temp1);
            prev = temp1;
        }
        return ans;
    }
}