class Solution {
    int sum=0;
    public boolean makesquare(int[] matchsticks) {
        int n=matchsticks.length;
        Arrays.sort(matchsticks);
        int p=0;
        int q=n-1;
        while(p<q){
            int copy=matchsticks[p];
            matchsticks[p]=matchsticks[q];
            matchsticks[q]=copy;
            p++;q--;
        }
        if(n<4) return false;
        for(int val:matchsticks){
            sum=sum+val;
        }
        if(sum%4!=0){
            return false;
        }
        return backtrack(matchsticks,0,n,0,0,0,0);        
    }
    public boolean backtrack(int[] matchsticks,int i,int n,int sum1,int sum2,int sum3,int sum4){
        if(i==n){
            if(sum1==sum2 && sum2==sum3 && sum3==sum4){
                return true;
            }
            return false;
        }
        boolean flag=false;
        for(int j=0;j<4;j++){
            if(j==0 && sum1+matchsticks[i]<=sum/4){
                flag=flag|| backtrack(matchsticks,i+1,n,sum1+matchsticks[i],sum2,sum3,sum4);
            }
            else if(j==1 && sum2+matchsticks[i]<=sum/4){
                flag=flag|| backtrack(matchsticks,i+1,n,sum1,sum2+matchsticks[i],sum3,sum4);
            }
            else if(j==2 && sum3+matchsticks[i]<=sum/4){
                flag=flag|| backtrack(matchsticks,i+1,n,sum1,sum2,sum3+matchsticks[i],sum4);
            } 
            else if(j==3 && sum4+matchsticks[i]<=sum/4){
                flag=flag|| backtrack(matchsticks,i+1,n,sum1,sum2,sum3,sum4+matchsticks[i]);
            }
        }
        return flag;
    }
}