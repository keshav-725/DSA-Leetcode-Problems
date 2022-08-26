class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> ulist = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
                ulist.add(nums[i]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        getSubsets(ans,new ArrayList<>(),ulist,map,0);
        return ans;
    }
    public void getSubsets(List<List<Integer>> ans,ArrayList<Integer> list,ArrayList<Integer> ulist,HashMap<Integer,Integer> map,int idx){
        if(idx==ulist.size()){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        int key = ulist.get(idx);
        for(int i=0;i<=map.get(key);i++){
            for(int j=0;j<i;j++){
                list.add(key);
            }
            getSubsets(ans,list,ulist,map,idx+1);
            for(int j=0;j<i;j++){
                list.remove(list.size()-1);
            }
        }
    }
}