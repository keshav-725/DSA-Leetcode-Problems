class Solution {
    public int maxArea(int h, int w, int[] hCuts, int[] vCuts) {
        Arrays.sort(hCuts);
        Arrays.sort(vCuts);
        long m = 1000000007;
        int hmax=hCuts[0];
        int vmax=vCuts[0];
        int i =1;
        for(;i<hCuts.length;i++){
            hmax = Math.max(hmax,hCuts[i]-hCuts[i-1]);
        }
        hmax = Math.max(hmax,h-hCuts[i-1]);
        i =1;
        for(;i<vCuts.length;i++){
            vmax = Math.max(vmax,vCuts[i]-vCuts[i-1]);
        }
        vmax = Math.max(vmax,w-vCuts[i-1]);
        long val = ((hmax)%m*(vmax)%m)%m;
        // long val = (hmax*vmax)%m;
        return (int)val;
    }
}