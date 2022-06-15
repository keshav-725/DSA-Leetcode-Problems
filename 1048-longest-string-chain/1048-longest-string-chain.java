class Solution {
    private boolean isSubsequence(String s, String t) {
        int idxS=0,idxT=0;
        for(;idxS<s.length()&&idxT<t.length(); idxT++){
            if(s.charAt(idxS) == t.charAt(idxT)) {
                idxS++;
            }
        }
        return (idxS == s.length());
    }
    
    private boolean isConnected(String s, String t) {
        if(s.length() != t.length()-1) return false;
        return isSubsequence(s, t);
    }
    
    private int dfs(List<List<Integer>>graph, int currIdx, Integer dp[]) {
        if(dp[currIdx] != null) {
            return dp[currIdx];
        }
        int mx=0;
        for(int nextIdx: graph.get(currIdx)) {
            mx=Math.max(mx, dfs(graph, nextIdx, dp));
        }
        return (dp[currIdx] = 1 + mx);
    }
    
    public int longestStrChain(String[] words) {
        List<List<Integer>>graph=new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(w -> w.length()));
        int n=words.length;
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
            for(int j=i+1;j<n;j++){
                if(isConnected(words[i],words[j])) {
                    graph.get(i).add(j);
                }
            }
        }
        Integer dp[]=new Integer[n];
        int ans=0;
        for(int idx=0;idx<n;idx++) {
            if(dp[idx]==null) {
                ans=Math.max(ans, dfs(graph, idx, dp));
            }
        }
        return ans;
    }
}