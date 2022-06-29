class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a1, int[] a2){
                return (a1[0]!=a2[0])?(a2[0]-a1[0]):(a1[1]-a2[1]);
            }
        });
        ArrayList<int[]> res = new ArrayList<>();
        for(int[] pepl : people)
            res.add(pepl[1], pepl);
        return res.toArray(new int[people.length][2]);
    }
}