class Solution {
    public int getIndex(int []arr,int x){
        int left = 0,right = arr.length-1;
        int pans = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            
            if(arr[mid]==x) return mid;
            else if(arr[mid]<x){
                pans = mid;
                left = mid + 1;
            }else{
                right = mid-1;
            }
        }
        return pans;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lp = getIndex(arr,x);
        int rp = lp+1;
        // System.out.println("lp-> "+lp+" rp-> "+rp);
        List<Integer> ans = new ArrayList<>();
        while(k-->0){
            int lval=Integer.MAX_VALUE,rval=Integer.MAX_VALUE;
            if(lp>=0) lval=arr[lp];
            if(rp<arr.length) rval=arr[rp];
            if(lval==Integer.MAX_VALUE){
                ans.add(rval);
                rp++;
            }else if(rval==Integer.MAX_VALUE){
                ans.add(lval);
                lp--;
            }else if(Math.abs(rval-x)>=Math.abs(lval-x)){
                ans.add(lval);
                lp--;
            }else{
                ans.add(rval);
                rp++;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}