class Solution {
    public int findMaxLength(int[] arr) {
        int max = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<arr.length;i++){
            int num = arr[i]==0?-1:1;
            sum += num;
            if(map.containsKey(sum)){
                int diff = i - map.get(sum);
                max = Math.max(diff,max);
            }else{
                map.put(sum,i);
            }
        }
        return max;
    }
}