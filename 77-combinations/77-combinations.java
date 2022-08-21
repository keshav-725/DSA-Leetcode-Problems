class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getCombination(n,k,ans,list,1);
        return ans;
    }
    public void getCombination(int n,int k,List<List<Integer>> ans,List<Integer> list,int idx){
        if(idx-1==n){
            if(list.size()==k){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(idx);
        getCombination(n,k,ans,list,idx+1);
        list.remove(list.size()-1);
        getCombination(n,k,ans,list,idx+1);
    }
}