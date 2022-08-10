class Solution {
    public int lowerbound(int []arr,int target){
        int left = 0;
        int right = arr.length-1;
        int ans=arr.length;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]>=target){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int rindex = lowerbound(arr,x);
        int lindex = rindex-1;
        List<Integer> list = new ArrayList<>();
        while(k>0){
            if(lindex>=0 && rindex<arr.length){
                if((x-arr[lindex])<=(arr[rindex]-x)){
                    list.add(arr[lindex]);
                    lindex--;
                }else{
                    list.add(arr[rindex]);
                    rindex++;
                }
            }else if(lindex>=0){
                list.add(arr[lindex]);
                lindex--;
            }else if(rindex<arr.length){
                list.add(arr[rindex]);
                rindex++;
            }
            k--;
        }
        Collections.sort(list);
        return list;
    }
}