class Solution {
    public String longestPalindrome(String s) {
        String palind = "";
        for(int i=0 ; i<s.length() ; i++){
            int len1 = longestPalLength(i,i+1, s);
            int len2 = 1+longestPalLength(i-1,i+1, s);
            if(len1>palind.length()){
                palind = s.substring(i-len1/2+1, i+len1/2+1);
            }
            if(len2>palind.length()){
                palind = s.substring(i-len2/2, i+len2/2+1);
            }
        }
        return palind;
    }
    public int longestPalLength(int i, int j, String s){
        int count = 0;
        while(i>=0 && j<s.length()){
            if(s.charAt(i--)!=s.charAt(j++))
                break;
            count += 2;
        }
        return count;
    }
}