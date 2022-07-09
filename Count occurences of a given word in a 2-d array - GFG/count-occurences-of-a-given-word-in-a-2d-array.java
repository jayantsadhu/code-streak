// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 
        
        Integer nextInt(){
            return Integer.parseInt(next());
        }
    } 
    
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t>0)
        {
            int R = sc.nextInt();
            int C = sc.nextInt();
            
            char mat[][] = new char[R][C];
            for(int i=0;i<R;i++)
            {
                for(int j=0;j<C;j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
            String target  = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findOccurrence(mat,target));
            
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int dx[] = { -1, 1, 0, 0};
    static int dy[] = {  0, 0,-1, 1};
    public int findOccurrence(char b[][], String w)
    {
        int res = 0;
        for(int i=0 ; i<b.length ; i++){
            for(int j=0 ; j<b[0].length ; j++){
                count = 0;
                solve(i, j, b, w, 0, new HashSet<>());
                res += count;
            }
        }
        return res;
    }
    static int count;
    public static void solve(int i, int j, char[][] b, String w, int k, Set<String> set){
        if(b[i][j]!=w.charAt(k)) return;

        if(k==w.length()-1){
            count++;
            return;
        }
        set.add((String.valueOf(i)+","+String.valueOf(j)));
        for(int l=0 ; l<4 ; l++){
            int idx = i + dx[l];
            int idy = j + dy[l];
            if(isValid(idx, idy, b.length, b[0].length) && !set.contains((String.valueOf(idx)+","+String.valueOf(idy))))
                solve(idx, idy, b, w, k+1, set);
        }
        set.remove((String.valueOf(i)+","+String.valueOf(j)));
    }
    private static boolean isValid(int idx, int idy, int length, int length2) {
        return (idx>=0 && idy>=0 && idx<length && idy<length2);
    }
}