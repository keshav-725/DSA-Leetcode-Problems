class Solution {
    public int largestRectangleArea(int[] a) {
        Stack<Integer> lst = new Stack<>();
        int []ls = new int[a.length];
        int []rs = new int[a.length];
        
        for(int i=0;i<a.length;i++){
            int num = a[i];
            while(lst.size()>0 && a[lst.peek()]>=num){
                lst.pop();
            }
            
            ls[i] = lst.size()>0 ? i-lst.peek() : i+1;
            
            lst.push(i);
        }
        
        lst = new Stack<>();
        int ans = Integer.MIN_VALUE;
        
        
        for(int i=a.length-1;i>=0;i--){
            int num = a[i];
            while(lst.size()>0 && a[lst.peek()]>=num){
                lst.pop();
            }
            rs[i] = lst.size()>0 ? lst.peek()-i : a.length-i;
            
            lst.push(i);
        }
        
        for(int i=0;i<a.length;i++){
            ans = Math.max(ans,Math.abs(rs[i]+ls[i]-1)*a[i]);
        }
        return ans;
    }
}