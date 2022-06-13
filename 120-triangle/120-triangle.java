class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp1 = new ArrayList<>();
        for(int j=0;j<triangle.get(0).size();j++){
            temp1.add(triangle.get(0).get(j));
        }
        res.add(temp1);
        for(int i=1;i<triangle.size();i++){
            List<Integer> temp = triangle.get(i);
            List<Integer> plist = res.get(i-1);
            List<Integer> tlist = new ArrayList<>();
            for(int j=0;j<temp.size();j++){
                if(j==0){
                    tlist.add(plist.get(0)+temp.get(0));
                }else if(j==temp.size()-1){
                    tlist.add(plist.get(plist.size()-1)+temp.get(temp.size()-1));
                }else{
                    int min = Math.min(plist.get(j),plist.get(j-1));
                    tlist.add(min+temp.get(j));
                }
            }
            res.add(tlist);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<res.get(res.size()-1).size();i++){
            ans = Math.min(ans,res.get(res.size()-1).get(i));
        }
        return ans;
    }
}