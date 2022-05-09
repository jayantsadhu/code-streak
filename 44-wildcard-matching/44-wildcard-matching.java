class Solution {
    public boolean isMatch(String str, String ptrn) {
        int s = 0;
        int p = 0;
        int lastStar = -1;
        int lastMatch = 0;
        
        while(s<str.length()){
            if(p<ptrn.length() && (ptrn.charAt(p)=='?' || ptrn.charAt(p)==str.charAt(s))){
                p++;
                s++;
            }
            else if(p<ptrn.length() && ptrn.charAt(p)=='*'){
                lastStar = p;
                lastMatch = s;
                p++;
            }
            else if(lastStar!=-1){
                p = lastStar+1;
                lastMatch++;
                s = lastMatch;
            }
            else return false;
        }
        while(p<ptrn.length() && ptrn.charAt(p)=='*') p++;
        return p==ptrn.length();
    }
}