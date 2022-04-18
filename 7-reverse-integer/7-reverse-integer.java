class Solution {
    public int reverse(int x) {
        int mx = Integer.MAX_VALUE;
        int res = 0;
        while(x!=0){
            if(res>mx/10 || (res==mx/10 && (x%10)>7))
                return 0;
            if(res<-mx/10 || (res==mx/10 && (x%10)<-8))
                return 0;
            res = res *10 + (x%10);
            x /= 10;
        }
        return res;
    }
}