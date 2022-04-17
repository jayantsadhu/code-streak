class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        if(n1>n2)
            return findMedianSortedArrays(arr2, arr1);
        int l1 = 0;
        int h1 = n1;
        
        while(l1<=h1){
            int p1 = (l1 + h1)/2;
            int p2 = (n1+n2+1)/2-p1;
            int leftMax1 = p1!=0? arr1[p1-1]: Integer.MIN_VALUE;
            int rightMin1 = p1!=n1? arr1[p1]: Integer.MAX_VALUE;
            int leftMax2 = p2!=0? arr2[p2-1]: Integer.MIN_VALUE;
            int rightMin2 = p2!=n2? arr2[p2]: Integer.MAX_VALUE;
            
            if(leftMax1<=rightMin2 && leftMax2<=rightMin1){
                if((n1+n2)%2==0){
                    double median = (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2))/2.0;
                    return median;
                }
                else{
                    double median = (double)Math.max(leftMax1, leftMax2);
                    return median;
                }
            }
            else if(leftMax1>rightMin2)
                h1 = p1-1;
            else l1 = p1+1;
        }

        throw new IllegalArgumentException();
    }
    
}