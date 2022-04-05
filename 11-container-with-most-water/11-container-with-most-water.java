class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int maxarea = 0;
        while(i!=j){
            int ht = Math.min(height[i],height[j]);
            int dist = j-i;
            int area = dist * ht;
            maxarea = Math.max(maxarea,area);
            if(height[i]<height[j]) i++;
            else j--;
        }
        return maxarea;
    }
}