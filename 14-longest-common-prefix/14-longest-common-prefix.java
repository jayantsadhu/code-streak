class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        for(int j=0 ; true ; j++){
            char c;
            if(j<strs[0].length())
                c = strs[0].charAt(j);
            else return res;
            
            for(int i=1 ; i<strs.length ; i++){
                if(j>=strs[i].length() || strs[i].charAt(j)!=c)
                    return res;
            }
            res += c;
        }
    }
}