class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if(digits[n-1]!=9){
            digits[n-1]++;
            return digits;
        }
        int i=0;
        while(i<n && digits[i++]==9);
        if(i==n){
            int res[] = new int[n+1];
            res[0] = 1;
            return res;
        }
        int c = 1;
        for(i=n-1 ; i>=0 ; i--){
            int prev = c;
            c = (digits[i]+c)/10;
            digits[i] = (digits[i]+prev)%10;
        }
        return digits;
    }
}