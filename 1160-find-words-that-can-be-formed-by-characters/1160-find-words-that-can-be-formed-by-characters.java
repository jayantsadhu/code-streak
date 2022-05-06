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
                if((++wd[words[i].charAt(j)-'a'])>al[words[i].charAt(j)-'a'])
                    break;
            count += j==words[i].length()? words[i].length() : 0;
        }
        return count;
    }
}