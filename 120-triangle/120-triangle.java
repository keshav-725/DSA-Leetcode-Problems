class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        List<Integer> next = new ArrayList<>();
        for(int j=0;j<triangle.get(0).size();j++){
            prev.add(triangle.get(0).get(j));
        }
        if(triangle.size()==1){
            next = prev;
        }
        for(int i=1;i<triangle.size();i++){
            List<Integer> temp = triangle.get(i);
            next = new ArrayList<>();
            for(int j=0;j<temp.size();j++){
                if(j==0){
                    next.add(prev.get(0)+temp.get(0));
                }else if(j==temp.size()-1){
                    next.add(prev.get(prev.size()-1)+temp.get(temp.size()-1));
                }else{
                    int min = Math.min(prev.get(j),prev.get(j-1));
                    next.add(min+temp.get(j));
                }
            }
            prev = next;
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<prev.size();i++){
            ans = Math.min(ans,prev.get(i));
        }
        return ans;
    }
}