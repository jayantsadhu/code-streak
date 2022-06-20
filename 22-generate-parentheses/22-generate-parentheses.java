class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        solve(0, 0, n, res, "");
        return res;
    }
    public void solve(int o, int c, int n, List<String> res, String bracket){
        if(c==n) {
            res.add(bracket);
            return;
        }
        if(o==c) solve(o+1, c, n, res, bracket+"(");
        else if(o>c){
            solve(o, c+1, n, res, bracket+")");
            if(o<n)
                solve(o+1, c, n, res, bracket+"(");
        }
    }
}