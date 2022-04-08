class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<answers.length;i++){
            int num = answers[i];
            if(map.containsKey(num)){
                if(map.get(num)==num+1){
                    map.put(num,1);
                    count+=num+1;
                }else{
                    map.put(num,map.get(num)+1);
                }
            }else{
                map.put(num,1);
                count = count + num+1;
            }
        }
        return count;
    }
}