class Solution {
    public int minPartitions(String n) {
        char ans = '0';
        for(int i = 0; i < n.length(); i++) {
            if(n.charAt(i) > ans) ans = n.charAt(i);
        }
        return Integer.parseInt(ans + "");
    }
}