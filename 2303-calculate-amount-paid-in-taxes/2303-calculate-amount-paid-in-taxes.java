class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int i = 0;
        if(brackets[i][0]>=income){
            return (double)(income*brackets[i][1])/100.0;
        }
        double taxes = brackets[i][0]*brackets[i][1]/100.0;
        for(i=1 ; i<brackets.length && brackets[i][0]<income ; i++){
            taxes += (brackets[i][0]-brackets[i-1][0])*brackets[i][1]/100.0;
        }
        if(i<brackets.length && brackets[i][0]>=income)
            taxes += (income-brackets[i-1][0])*brackets[i][1]/100.0;
        taxes = ((int)(taxes*1e5))/(1e5);
        return taxes;
    }
}