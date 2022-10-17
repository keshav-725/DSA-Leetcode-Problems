class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for(int val=num/2;val<=num;val++){
            int rval = num-val;
            if(check(val,rval)) return true;
        }
        return false;
    }
    public boolean check(int n1,int n2){
        StringBuilder sb1 = new StringBuilder(n1+"");
        StringBuilder sb2 = new StringBuilder(n2+"");
        while(sb1.length()>sb2.length()){
            sb2.insert(0,'0');
        }
        while(sb2.length()>sb1.length()){
            sb1.insert(0,'0');
        }
        if(sb1.reverse().toString().equals(sb2.toString())) return true;
        return false;
    }
}