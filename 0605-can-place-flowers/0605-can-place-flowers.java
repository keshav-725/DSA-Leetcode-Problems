class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) return true;
        int len = flowerbed.length;
        for(int i=0;i<len;i++){
            if(flowerbed[i]==1) continue;
            boolean checkleft = (i==0) || flowerbed[i-1]==0;
            boolean checkright = (i==len-1) || flowerbed[i+1]==0;
            
            if(checkleft && checkright){
                flowerbed[i]=1;
                n--;
                if(n==0) return true;
            }
        }
        return false;
    }
}