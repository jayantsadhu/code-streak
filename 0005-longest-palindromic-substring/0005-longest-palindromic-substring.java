class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int len = 0;
        String str = ""+s.charAt(0);
        for(int i=0; i<n-1; i++){
            int idxMaxLen = Math.max(1+maxLenPal(i-1, i+1, s, n), 
                                     maxLenPal(i, i+1, s, n));
            if(idxMaxLen>len){
                len = idxMaxLen;
                int sym;
                if(len%2==1){
                    sym = (len-1)/2;
                    str = s.substring(i-sym, i+sym+1);
                }
                else{
                    sym = len/2;
                    str = s.substring(i-sym+1, i+sym+1);
                }
            }
        }
        return str;
    }
    int maxLenPal(int idx1, int idx2, String s, int n){
        int i = idx1;
        int j = idx2;
        int count = 0;
        while(i>=0 && j<n && s.charAt(i)==s.charAt(j)){
            i--; j++;
            count += 2;
        }
        return count;
    }
}