class Solution {
    public int numSplits(String s) {
        int n = s.length();
        int pre[] = new int[n+1];
        int suf[] = new int[n+1];
        Set<Character> set = new HashSet<>();
        for(int i=0 ; i<n ; i++){
            set.add(s.charAt(i));
            pre[i+1] = set.size();
        }
        set = new HashSet<>();
        for(int i=n-1 ; i>=0 ; i--){
            set.add(s.charAt(i));
            suf[i+1] = set.size();
        }
        System.out.println(Arrays.toString(pre));
        int count = 0;
        for(int i=0 ; i<n-1 ; i++){
            if(pre[i+1]==suf[i+2])
                count++;
        }
        return count;
    }
}