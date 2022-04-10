class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;Math.pow(x,i)<=bound;i++){
            for(int j=0;Math.pow(y,j)<=bound;j++){
                int sum = (int)Math.pow(x,i)+(int)Math.pow(y,j);
                if(sum<=bound){
                    if(!set.contains(sum)){
                        set.add(sum);
                        ans.add(sum);
                    }
                }
                if(y==1) break;
            }
            if(x==1) break;
        }
        return ans;
    }
}