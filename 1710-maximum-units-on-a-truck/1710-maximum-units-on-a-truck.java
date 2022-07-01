class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> (b[1]-a[1]));
        
        int units = 0;
        for(int i=0 ; i<boxTypes.length && truckSize>0 ; i++){
            
            if(boxTypes[i][0]<=truckSize) units += boxTypes[i][0]*boxTypes[i][1];
            else units += truckSize*boxTypes[i][1];
            truckSize -= boxTypes[i][0];
        }
        return units;
    }
}