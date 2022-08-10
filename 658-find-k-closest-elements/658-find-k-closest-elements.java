class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int ridx = getIndex(arr,x);
        int lidx = ridx-1;
        List<Integer> list = new ArrayList<>();
        while(k>0){
            int lval = Integer.MAX_VALUE;
            int rval = Integer.MAX_VALUE;
            if(lidx>=0){
                lval = Math.abs(arr[lidx]-x);
            }
            if(ridx<arr.length){
                rval = Math.abs(arr[ridx]-x);
            }
            if(rval>=lval){
                list.add(arr[lidx]);
                lidx--;
            }else{
                list.add(arr[ridx]);
                ridx++;
            }
            k--;
        }
        Collections.sort(list);
        return list;
    }
    public int getIndex(int []arr,int x){
        int left=0,right=arr.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]==x) return mid;
            else if(arr[mid]<x){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}