//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());
            int K = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            System.out.println(ob.countWaystoDivide(N, K));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countWaystoDivide(int N, int K) {
        // Create a DP table
        int[][][] dp = new int[N + 1][K + 1][N + 1];

        // Initialize the DP table with -1 (memoization)
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                for (int k = 0; k <= N; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        // Recursive call with memoization
        return countGroups(N, K, 1, dp);
    }

    private int countGroups(int N, int K, int prev, int[][][] dp) {
        // Base case: if no groups left
        if (K == 0) {
            return (N == 0) ? 1 : 0;
        }

        // Check if already computed
        if (dp[N][K][prev] != -1) {
            return dp[N][K][prev];
        }

        int ways = 0;
        // Iterate from `prev` to `N` to maintain non-decreasing order
        for (int i = prev; i <= N; i++) {
            if (N - i >= 0) {
                ways = (ways + countGroups(N - i, K - 1, i, dp)) % 1000000007;
            }
        }

        // Store result in the DP table
        dp[N][K][prev] = ways;

        return ways;
    }
}