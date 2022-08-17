class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m;i<m+n;i++){
            nums1[i] = nums2[i-m];
        }
        int gap = (int)Math.ceil((n+m)/2.0);
    
    for(;gap>=1;gap=(int)Math.ceil(gap/2.0)){
        for(int i=0,j=gap;j<m+n;i++,j++){
            if(nums1[i]>nums1[j]){
                int temp = nums1[i];
                nums1[i]=nums1[j];
                nums1[j]=temp;
            }
        }
        if(gap==1) break;
    }
    }
}