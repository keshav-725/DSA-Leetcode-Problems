class Solution {
    public class Node{
        Node []children = new Node[26];
        boolean isEnd = false;
        public boolean contains(char ch){
            return (children[ch-'a']!=null);
        }
        public Node get(char ch){
            return children[ch-'a'];
        }
        public void set(char ch){
            children[ch-'a'] = new Node();
        }
        public boolean getEnd(){
            return this.isEnd;
        }
        public void setEnd(){
            this.isEnd = true;
        }
    }
    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        Node root = new Node();
        
        String s = strs[0];
        Node curr = root;
        for(char ch : s.toCharArray()){
            curr.set(ch);
            curr = curr.get(ch);
        }
        curr.setEnd();
        
        for(int i=1;i<strs.length;i++){
            s = strs[i];
            curr = root;
            boolean check = false;
            for(int j=0;j<s.length();j++){
                char ch = s.charAt(j);
                if(curr.contains(ch)==false){
                    check = true;
                    String sub = s.substring(0,j);
                    if(ans.length()>sub.length()){
                        ans = sub;
                    }
                    break;
                }
                curr = curr.get(ch);
            }
            if(check==false && s.length()<ans.length()){
                ans = s;
            }
        }
        return ans;
        
    }
}