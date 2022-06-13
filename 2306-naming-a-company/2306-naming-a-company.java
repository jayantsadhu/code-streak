class Solution {
    public long distinctNames(String[] ideas) {
        int n = ideas.length;
        Set<String>[] initials = new Set[26];
        for(int i=0 ; i<26 ; i++)
            initials[i] = new HashSet<>();
        
        for(String name : ideas)
            initials[name.charAt(0)-'a'].add(name.substring(1));
        
        long count = 0;
        for(int i=0 ; i<26 ; i++){
            for(int j=i+1 ; j<26 ; j++){
                Set<String> unionSet = new HashSet<>();
                unionSet.addAll(initials[i]);
                unionSet.addAll(initials[j]);
                count += (unionSet.size()-initials[i].size())
                    *(unionSet.size()-initials[j].size());
            }
        }
        return 2*count;
    }
}