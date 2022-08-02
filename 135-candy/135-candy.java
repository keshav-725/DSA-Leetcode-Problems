class Solution {
    public int candy(int[] ratings) {
        int []larr = new int[ratings.length];
        larr[0]=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                larr[i] = larr[i-1]+1;
            }else{
                larr[i] = 1;
            }
        }
        int []rarr = new int[ratings.length];
        rarr[ratings.length-1]=1;
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                rarr[i] = rarr[i+1]+1;
            }else{
                rarr[i] = 1;
            }
        }
        int ans =0;
        for(int i=0;i<ratings.length;i++){
            ans += Math.max(larr[i],rarr[i]);
        }
        
        return ans;
    }
}