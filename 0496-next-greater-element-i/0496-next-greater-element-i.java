class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            int num = nums2[i];
            while(st.size()>0 && st.peek()<num){
                st.pop();
            }
            if(st.size()==0){
                map.put(num,-1);
            }else{
                map.put(num,st.peek());
            }
            st.push(num);
        }
        int i = 0;
        int []ans = new int[nums1.length];
        for(int num : nums1){
            ans[i++] = map.get(num);
        }
        return ans;
    }
}