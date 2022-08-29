class Solution {
    public List<Integer> grayCode(int n) {
        if(n==0){
            List<Integer> bres = new ArrayList<>();
            bres.add(0);
            return bres;
        }else if(n==1){
            List<Integer> bres = new ArrayList<>();
            bres.add(0);
            bres.add(1);
            return bres;
        }
        
        List<Integer> ans = grayCode(n-1);
        
        List<Integer> mtans = new ArrayList<>();
        
        for(int i=0;i<ans.size();i++){
            int val = ans.get(i);
            mtans.add(val);
        }
        for(int i=ans.size()-1;i>=0;i--){
            int val = ans.get(i);
            int bm = 1<<(n-1);
            val = val|bm;
            mtans.add(val);
        }
        return mtans;
    }
}