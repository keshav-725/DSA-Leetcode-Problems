class Solution {
    public String addBinary(String a, String b) {
        int n=a.length()-1;
        int m=b.length()-1;
        int sum=0;
        int c=0;
        StringBuilder res=new StringBuilder();
        while(n>=0 || m>=0 || c==1){
          sum=c;
          if(n>=0) sum+=a.charAt(n)-'0';
          if(m>=0) sum+=b.charAt(m)-'0';
          res.append((char)(sum%2+'0'));
          c=sum/2;
          n--;
          m--;
        }
        return res.reverse().toString();
    }
}