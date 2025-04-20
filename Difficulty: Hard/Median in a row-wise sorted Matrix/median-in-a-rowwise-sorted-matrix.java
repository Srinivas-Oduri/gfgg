//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int R = Integer.parseInt(read.readLine());
            int C = Integer.parseInt(read.readLine());
            int matrix[][] = new int[R][C];
            int c = 0;
            for (int i = 0; i < R; i++) {
                String line[] = read.readLine().trim().split(" ");
                for (int j = 0; j < C; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int median(int mat[][]) {
        // code here
        // traversing matrix with O(n*m)
        int row = mat.length;
        int col = mat[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0,r=0,c=0;i<row*col;i++)
        {
            list.add(mat[r][c]);
            c++;
            if(c == col)
            {
                c=0;
                r++;
            }
        }
        Collections.sort(list);
        
        return list.get(list.size()/2);
    }
}