class Solution {
    int max;
    public int maxLength(List<String> arr) {
        int []check = new int[26];
        max = Integer.MIN_VALUE;
        helper(arr,check,"",0);
        return max;
    }
    public void helper(List<String> arr,int []check,String str,int idx){
        if(idx==arr.size()){
            max = Math.max(max,str.length());
            return;
        }
        
        boolean isPresent = false;
        String s = arr.get(idx);
        int []ncheck = check.clone();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ncheck[ch-'a']==0){
                ncheck[ch-'a']++;
            }else{
                for(int j=0;j<i;j++){
                    char jch = s.charAt(j);
                    ncheck[jch-'a']--;
                }
                isPresent = true;
                break;
            }
        }
        if(isPresent == false){
            helper(arr,ncheck,str+arr.get(idx),idx+1);
        }
        helper(arr,check,str,idx+1);
    }
}