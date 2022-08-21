class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates,target,ans,list,0,0);
        return ans;
    }
    public void combinationSumHelper(int[] candidates, int target,List<List<Integer>> ans,List<Integer> list,int sum,int idx){
        if(sum>target) return;
        if(sum == target){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]) continue;
            list.add(candidates[i]);
            combinationSumHelper(candidates,target,ans,list,sum+candidates[i],i+1);
            list.remove(list.size()-1);
        }
    }
}