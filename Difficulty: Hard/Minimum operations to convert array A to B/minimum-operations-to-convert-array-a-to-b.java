//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            
            int[] A = new int[N];
            int[] B = new int[M];
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);
                
            for(int i=0; i<M; i++)
                B[i] = Integer.parseInt(S2[i]);

            Solution ob = new Solution();
            System.out.println(ob.minInsAndDel(A,B,N,M));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int minInsAndDel(int[] A, int[] B, int N, int M) {
        List<Integer> arr=new ArrayList<>();
        int cnt=0;
        for(int i=0;i<N;i++) {
            if(Arrays.binarySearch(B,A[i])>=0) {
                if(arr.isEmpty()) {
                    arr.add(A[i]);
                    cnt=1;
                    continue;
                }
                if(arr.get(arr.size()-1)<A[i]) {
                    arr.add(A[i]);
                    cnt++;
                }
                else {
                    int idx=Collections.binarySearch(arr,A[i]);
                    if(idx<0) {
                        idx*=(-1);
                        idx--;
                    }
                    arr.set(idx,A[i]);
                }
            }
        }
        return (M-cnt)+(N-cnt);
    }
};