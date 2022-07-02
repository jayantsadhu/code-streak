class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int hl = horizontalCuts.length;
        int vl = verticalCuts.length;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        //int hGaps[] = new int[hl+1];
        //int vGaps[] = new int[vl+1];
        int hLargestGap = horizontalCuts[0];
        int vLargestGap = verticalCuts[0];
        
        for(int i=1 ; i<hl ; i++)
            hLargestGap = Math.max(hLargestGap, (horizontalCuts[i]-horizontalCuts[i-1]));
        hLargestGap = Math.max(hLargestGap, (h - horizontalCuts[hl-1]));
        
        for(int i=1 ; i<vl ; i++)
            vLargestGap = Math.max(vLargestGap, (verticalCuts[i]-verticalCuts[i-1]));
        vLargestGap = Math.max(vLargestGap, (w - verticalCuts[vl-1]));
        
        int mod = (int)1e9 + 7;
        long res = (long)hLargestGap*vLargestGap;
        return (int)(res % mod);
    }
}