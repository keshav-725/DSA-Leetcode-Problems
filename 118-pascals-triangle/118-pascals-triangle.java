class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(1);
        ans.add(temp1);
        if(numRows==1) return ans;
        temp1 = new ArrayList<>();
        temp1.add(1);
        temp1.add(1);
        ans.add(temp1);
        if(numRows==2) return ans;
        List<Integer> prev = temp1;
        for(int i=2;i<numRows;i++){
            temp1 = new ArrayList<>();
            temp1.add(1);
            for(int j=0;j<prev.size()-1;j++){
                int sum = prev.get(j)+prev.get(j+1);
                temp1.add(sum);
            }
            temp1.add(1);
            ans.add(temp1);
            prev = temp1;
        }
        return ans;
    }
}