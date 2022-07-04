class Solution {
    public int candy(int[] rat) {
        int n = rat.length;
        int sum = 1, last = 1;
        for(int i=0 ; i<n-1 ; ){
            
            while(i<n-1 && rat[i+1]>rat[i]){
                last++;
                sum += last;
                i++;
            }
            while(i<n-1 && rat[i+1]==rat[i]) {
                last = 1;
                sum += 1;
                i++;
            }
            if(i<n-1 && rat[i+1]<rat[i]){
                int count = 0;
                while(i<n-1 && rat[i+1]<rat[i]){
                    count++;
                    i++;
                }
                sum += (count*(count+1))/2 + Math.max(last, count+1)-last;
                last = 1;
            }
        }
        return sum;
    }
}