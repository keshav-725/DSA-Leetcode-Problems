class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        recursion(n,n,list,str);
        return list;
    }
    void recursion(int ip,int cp,List<String> list,StringBuilder str)
    {
        if(ip == 0 && cp == 0)
        {
            list.add(str.toString());
            return ;
        }
        if(ip != 0)
        {
            StringBuilder str1 = new StringBuilder(str);
            str1.append("(");
            recursion(ip-1,cp,list,str1);
        }
        if(cp > ip)
        {
            StringBuilder str1 = new StringBuilder(str);
            str1.append(")");
            recursion(ip,cp-1,list,str1);
        }
        
    }
    
}