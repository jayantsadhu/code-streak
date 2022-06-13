class Solution {
    public int distributeCookies(int[] cookies, int k) {
        ans = Integer.MAX_VALUE;
        int[] ch = new int[k];
        soln(0, cookies, k, ch);
        return ans;
    }
    int ans;
    public void soln(int idx, int[] co, int k, int[] ch){
        
        if(idx==co.length){
            int res = Integer.MIN_VALUE;
            for(Integer cookies : ch)
                res = Math.max(res, cookies);
            ans = Math.min(ans, res);
            return;
        }
        for(int i=0 ; i<k  ; i++){
            ch[i] += co[idx];
            soln(idx+1, co, k, ch);
            ch[i] -= co[idx];
        }
    }
}