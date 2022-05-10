class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=9;i++){
            helper(i,k,n,ans,""+i,i);
        }
        return ans;
    }
    public void helper(int i,int k,int n,List<List<Integer>> ans,String res,int sum){
        if(sum>n) return;
        if(sum == n ){
            List<Integer> list = new ArrayList<>();
            if(res.length()==k){
                for(int a=0;a<res.length();a++){
                    int ch = res.charAt(a)-'0';
                    list.add(ch);
                }
                ans.add(list);
            }
            return;
        }
        for(int j=i+1;j<=9;j++){
            helper(j,k,n,ans,res+j,sum+j);   
        }
    }
}