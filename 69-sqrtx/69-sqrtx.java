class Solution {
    public int mySqrt(int x) {
        long i;
        for(i=0 ; i*i<=x ; i++);
        return ((int)i-1);
    }
}