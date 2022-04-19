class Solution {
    public int strStr(String h, String n) {
        int nl = n.length();
        int hl = h.length();
        for(int k=0 ; k<hl ; k++){
            int i = k;
            int j=0;
            while(i<hl && j<nl && h.charAt(i)==n.charAt(j)){
                i++;
                j++;
            }
            if(j==n.length()) return k;
        }
        return -1;
    }
}