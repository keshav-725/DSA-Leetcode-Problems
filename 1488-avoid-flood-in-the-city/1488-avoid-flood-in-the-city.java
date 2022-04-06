class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer,Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        int []ans = new int[rains.length];
        for(int i=0;i<rains.length;i++){
            int num = rains[i];
            if(num!=0){
                ans[i] = -1;
                if(map.containsKey(num)){
                    int key = map.get(num);
                    if(set.ceiling(key)==null) return new int[0];
                    ans[set.ceiling(key)] = num;
                    set.remove(set.ceiling(key));
                    map.put(num,i);
                }else{
                    map.put(num,i);
                }
            }else{
                set.add(i);
            }
        }
        for(int i=0;i<ans.length;i++){
            if(ans[i]==0){
                ans[i]=1;
            }
        }
        return ans;
    }
}