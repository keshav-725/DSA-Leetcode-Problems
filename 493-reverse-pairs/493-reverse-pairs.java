class Solution {
    public void mergeSort(int []nums,int left,int right){
        if(right<=left) return;
        int mid = left + (right-left)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }
    public int inversionCount(int []nums,int a1l,int a1r,int a2l,int a2r){
        int count=0;
        int ptr1=a1l,ptr2=a2l,ptr3=0;
        while(ptr1<=a1r && ptr2<=a2r){
            if((long)nums[ptr1]<=2l*(long)nums[ptr2]){
                ptr3++;
                ptr1++;
            }else{
                count+=(a1r-ptr1+1);
                ptr3++;
                ptr2++;
            }
        }
        return count;
    }
    public void merge(int []nums,int left,int mid,int right){
        int total = right-left+1;
        int []res = new int[total];
        int tl=left,tll=left,trr=right,tm1=mid,tm2=mid+1,tr=right,idx=0;
        ans += inversionCount(nums,left,tm1,tm2,right);
        while(tl<=mid && tm2<=right){
            if(nums[tl]<=nums[tm2]){
                res[idx]=nums[tl];
                idx++;
                tl++;
            }else{
                res[idx]=nums[tm2];
                idx++;
                tm2++;
            }
        }
        while(tl<=mid){
            res[idx]=nums[tl];
            idx++;
            tl++;
        }
        while(tm2<=right){
            res[idx]=nums[tm2];
            idx++;
            tm2++;
        }
        for(int i=left;i<=right;i++){
            nums[i] = res[i-left];
        }
    }
    int ans;
    public int reversePairs(int[] nums) {
        ans = 0;
        mergeSort(nums,0,nums.length-1);
        return ans;
    }
}