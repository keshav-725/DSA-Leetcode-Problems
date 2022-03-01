class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                queue.addLast(i);
            }
            else if(ch==')'){
                if(queue.size()==0 || s.charAt(queue.getLast())==')'){
                    queue.addLast(i);
                }else{
                    queue.removeLast();
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(queue.size()>0 && i==queue.getFirst()){
                queue.removeFirst();
                continue;
            }else{
                sb.append(""+ch);
            }
        }
        return sb.toString();
    }
}