import java.math.BigInteger;
class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int sign = 1;
        int i = 0;
        
        while(i<n && s.charAt(i)==' ')
            i++;
        
        if(i<n && s.charAt(i)=='-'){
            sign = -1;
            i++;
        }
        else if(i<n && s.charAt(i)=='+') i++;
        
        int base = 0;
        while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9'){
            
            if(base>Integer.MAX_VALUE/10 || base==Integer.MAX_VALUE/10 && s.charAt(i)-'0'>7)
                return sign==1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            
            base = base*10 + s.charAt(i++)-'0';
        }
        return sign*base;
    }
}