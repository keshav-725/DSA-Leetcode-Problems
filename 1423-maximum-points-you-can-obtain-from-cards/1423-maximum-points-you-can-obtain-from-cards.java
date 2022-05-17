class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int len = cardPoints.length;
        for(int i=0;i<len;i++){
            sum += cardPoints[i];
        }
        int window = 0;
        for(int i=0;i<len-k;i++){
            window += cardPoints[i];
        }
        int j = 0,num=window;
        for(int i=len-k;i<len;i++){
            int inum = cardPoints[i];
            int jnum = cardPoints[j];
            num = num+inum-jnum;
            //System.out.println(num);
            window = Math.min(window,num);
            j++;
        }
        return sum-window;
    }
}