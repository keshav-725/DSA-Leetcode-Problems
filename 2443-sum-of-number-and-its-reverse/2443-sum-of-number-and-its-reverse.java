class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for(int val=num/2;val<=num;val++){
            StringBuilder sb = new StringBuilder(val+"");
            int trev = Integer.parseInt(sb.reverse().toString());
            if(val+trev == num) return true;
        }
        return false;
    }
}