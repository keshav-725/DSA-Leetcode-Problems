class Solution {
public:
    double myPow(double x, int n) {
        if(n==0) return 1.0;
        return myPowP(x,n);
    }
    double myPowP(double x,int n){
        if(n==0) return 1;
        double t = myPowP(x,n/2);
        if(n%2) return n<0 ? 1/x*t*t : x*t*t;
        else return t*t;
    }
};