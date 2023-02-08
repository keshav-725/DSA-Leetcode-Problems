class Solution {
    public List<Integer> pathInZigZagTree(int n) {
        
        int level=1,val=1;
        while(n>=val){
            val = val * 2;
            level++;
        }
        level--;
        // System.out.println(level);
        List<Integer> ans = new ArrayList<>();
        ans.add(n);
        while(n!=1){
            int cmp = comp(level--,n);
            n = cmp/2;
            ans.add(n);
        }
        Collections.reverse(ans);
        return ans;
    }
    public int comp(int level,int val){
        long st = (long)Math.pow(2,level-1);
        long en = (long)Math.pow(2,level)-1;
        int x = (int)(en + st -val);
        return x;
    }
}