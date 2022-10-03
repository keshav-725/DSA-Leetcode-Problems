class Solution {
    public int minCost(String colors, int[] neededTime) {
        int time = neededTime[0], max = neededTime[0];
        char prev = colors.charAt(0);
    
        for(int i = 1; i < colors.length(); i++){
            time += neededTime[i];
            if(prev == colors.charAt(i)){
                if(max < neededTime[i])
                    max = neededTime[i];
                prev = colors.charAt(i);
            } 
            else{
                time -= max;
                prev = colors.charAt(i);
                max = neededTime[i];
            }
        }
        
        return (time - max);
    }
}