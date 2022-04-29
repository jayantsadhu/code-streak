class Solution {
    public String countAndSay(int n) {
        String base = "1";
        if(n==1) return base;
        for(int i=2 ; i<=n ; i++){
            int j=0;
            String res = "";
            while(j<base.length()){
                char num = base.charAt(j);
                int count = 0;
                while(j<base.length() && num==base.charAt(j)){
                    count++;
                    j++;
                }
                res += String.valueOf(count)+num;
            }
            base = res;
        }
        return base;
    }
}