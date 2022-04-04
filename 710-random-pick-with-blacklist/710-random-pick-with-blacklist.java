class Solution {
    HashMap<Integer,Integer> map;
    int len;
    Random r;
    int remlen;
    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        r = new Random();
        for(int i=0;i<blacklist.length;i++){
            map.put(blacklist[i],-1);
        }
        remlen = n - blacklist.length;
        for(int num : blacklist){
            if(num<remlen){
                while(map.containsKey(n-1)){
                    n--;
                }
                map.put(num,n-1);
                n--;
            }
        }
    }
    
    public int pick() {
        int idx = r.nextInt(remlen);
        if(map.containsKey(idx)){
            return map.get(idx);
        }
        return idx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */