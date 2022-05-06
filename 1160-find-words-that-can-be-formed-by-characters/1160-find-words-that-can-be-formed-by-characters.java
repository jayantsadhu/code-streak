class Solution {
    public int countCharacters(String[] words, String chars) {
        int al[] = new int[26];
        for(int i=0 ; i<chars.length() ; i++){
            al[chars.charAt(i)-'a']++;
        }
        int count = 0;
        for(int i=0 ; i<words.length ; i++){
            int wd[] = new int[26];
            int j;
            for(j=0 ; j<words[i].length() ; j++)
                wd[words[i].charAt(j)-'a']++;
            for(j=0 ; j<26 ; j++){
                if(wd[j]>al[j]) break;
            }
            count += j==26? words[i].length() : 0;
        }
        return count;
    }
}