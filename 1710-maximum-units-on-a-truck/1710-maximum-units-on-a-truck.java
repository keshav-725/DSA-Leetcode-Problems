class Solution {
    public int maximumUnits(int[][] box, int truckSize) {
        Arrays.sort(box,(x,y)->y[1]-x[1]);
        int maxunit=0;
        for(int i=0;i<box.length;i++){
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