class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int[] ch = new int[k];
        return soln(0, cookies, k, ch);
    }
    public int soln(int idx, int[] co, int k, int[] ch){
        
        if(idx==co.length){
            int res = Integer.MIN_VALUE;
            for(Integer cookies : ch)
                res = Math.max(res, cookies);
            return res;
        }
        int unfaireness = Integer.MAX_VALUE;
        for(int i=0 ; i<k  ; i++){
            ch[i] += co[idx];
            unfaireness = Math.min(unfaireness, soln(idx+1, co, k, ch));
            ch[i] -= co[idx];
        }
        return unfaireness;
    }
}