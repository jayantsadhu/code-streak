class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0) return res;
        helper(digits, 0, res, "");
        return res;
    }
    String msg[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public void helper(String dig, int i, List<String> res, String word){
        if(i==dig.length()) {
            res.add(word);
            return;
        }
        String message = msg[dig.charAt(i)-'2'];
        for(int j=0 ; j<message.length() ; j++){
            char ch = message.charAt(j);
            helper(dig, i+1, res, word+ch);
        }
    }
}