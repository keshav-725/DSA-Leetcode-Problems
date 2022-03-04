class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> scoreStack = new Stack<>();
        int score=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                scoreStack.push(-1);
            }else if(ch==')'){
                while(scoreStack.peek()!= -1){
                    score += scoreStack.pop();
                }
                scoreStack.pop();
                if(score==0){
                    scoreStack.push(1);
                }
                else{
                    scoreStack.push(score*2);
                    score = 0;
                }
            }
        }
        int totalScore = 0;
        while(scoreStack.size()>0){
            totalScore += scoreStack.pop();
        }
        return totalScore;
    }
}