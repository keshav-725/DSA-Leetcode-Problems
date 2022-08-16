class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total=nums1.length+nums2.length;

		boolean flag=false;

		if(total%2==0){
			flag=true;
		}
		int[] ar=new int[(total/2)+1];

		int i1=0,i2=0;

		for(int i=0;i<total/2+1;i++){
			if(i1<nums1.length && i2<nums2.length){
			if(nums1[i1]>nums2[i2]){
				ar[i]=nums2[i2];
                i2++;
			}
			else{
				ar[i]=nums1[i1];
                i1++;
			}
			}
			else if(i1<nums1.length){
				ar[i]=nums1[i1];
                i1++;
			}
			else if(i2<nums2.length){
				ar[i]=nums2[i2];
                i2++;
			}
		}

		if(!flag){
			return ar[total/2];
		}
		else{
			return ((double)ar[total/2] + (double)ar[total/2-1])/2;
        }
    }
}