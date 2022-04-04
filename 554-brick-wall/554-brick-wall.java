class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxsum = 0,maxkey=0;
        for(int i=0;i<wall.size();i++){
            int sum = 0;
            for(int j=0;j<wall.get(i).size()-1;j++){
                int num = wall.get(i).get(j);
                sum += num;
                map.put(sum,map.getOrDefault(sum,0)+1);
               if(maxsum<map.get(sum)){
                   maxsum = map.get(sum);
                   maxkey = sum;
               }
            }
        }
        int crossbrick = wall.size() - maxsum;
        return crossbrick;
    }
}