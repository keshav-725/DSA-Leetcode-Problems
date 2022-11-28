class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashSet<Integer> wset = new HashSet<>();
        HashMap<Integer,Integer> lmap = new HashMap<>();
        
        for(int []arr : matches){
            int win = arr[0];
            int loss = arr[1];
            
            wset.add(win);
            lmap.put(loss,lmap.getOrDefault(loss,0)+1);
        }
        List<Integer> win = new ArrayList<>();
        List<Integer> loss = new ArrayList<>();
        for(int key : wset){
            if(!(lmap.containsKey(key))){
                win.add(key);
            }
        }
        for(int key : lmap.keySet()){
            if(lmap.get(key)==1){
                loss.add(key);
            }
        }
        Collections.sort(win);
        Collections.sort(loss);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(win);
        ans.add(loss);
        return ans;
    }
}