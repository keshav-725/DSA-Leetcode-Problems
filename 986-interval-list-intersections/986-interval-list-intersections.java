class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int fidx = 0;
        int sidx = 0;
        ArrayList<int[]> list = new ArrayList<>();
        while(fidx<firstList.length && sidx<secondList.length){
            if(firstList[fidx][1]<secondList[sidx][0]) fidx++;
            else if(secondList[sidx][1]<firstList[fidx][0]) sidx++;
            else{
                int start,end;
                if(firstList[fidx][0]>=secondList[sidx][0]){
                    start = firstList[fidx][0];
                }else{
                    start = secondList[sidx][0];
                }
                if(firstList[fidx][1]<=secondList[sidx][1]){
                    end = firstList[fidx][1];
                    fidx++;
                }else{
                    end = secondList[sidx][1];
                    sidx++;
                }
                int []res = new int[]{start,end};
                list.add(res);
            }
        }
        int [][]ans = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}