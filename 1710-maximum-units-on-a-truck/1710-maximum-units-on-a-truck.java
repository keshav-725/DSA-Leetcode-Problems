class Solution {
    public int maximumUnits(int[][] box, int truckSize) {
        Arrays.sort(box,(x,y)->x[1]-y[1]);
        int maxunit=0;
        for(int i=box.length-1;i>=0;i--){
            int val = box[i][0];
            if(truckSize<=val){
                maxunit += truckSize*box[i][1];
                break;
            }else{
                maxunit += box[i][0]*box[i][1];
                truckSize -= val;
            }
        }
        return maxunit;
    }
}