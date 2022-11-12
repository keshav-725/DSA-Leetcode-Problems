class Solution {
    public int lengthOfLIS(int[] nums){
        int n = nums.length;
        int []dp = new int[n];
        dp[0] = 1;
        int ans = 1;
        for(int i=1;i<n;i++){
            int val = 0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    val = Math.max(dp[j],val);
                }
            }
            dp[i] = val+1;
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
    public int helper(int[] arr) {
        int []ans = new int[arr.length];
		int idx = 1;
		ans[0] = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>ans[idx-1]) {
				ans[idx] = arr[i];
				idx++;
			}else {
				int res = binarySearch(arr[i],ans,idx-1);
				ans[res] = arr[i];
			}
		}
        // for(int i=0;i<ans.length;i++){
        //     System.out.println(ans[i]);
        // }
        return idx;
    }
    private int binarySearch(int val, int[] arr,int idx) {
		int left = 0;
        int right = idx;
        int ans = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            // if(arr[mid]==val) return ,i
            if(arr[mid]<val){
                left = mid+1;
                ans = mid;
            }else{
                right = mid-1;
            }
        }
		return ++ans;
	}
}