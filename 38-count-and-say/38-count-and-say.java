class Solution {
    public String countAndSay(int n) {
        String base = "1";
        StringBuilder res;
        int j;
        
        if(n==1) return base;
        for(int i=2 ; i<=n ; i++){
            j=0;
            res = new StringBuilder();
            while(j<base.length()){
                char num = base.charAt(j);
                int count = 0;
                while(j<base.length() && num==base.charAt(j)){
                    count++;
                    j++;
                }
                res.append(count).append(num);
            }
            base = res.toString();
        }
        return base;
    }
}