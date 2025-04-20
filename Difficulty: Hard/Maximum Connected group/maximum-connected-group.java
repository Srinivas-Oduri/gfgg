//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {

    public int dfs(int i, int j, int n, int m, int grid[][], int vis[][], int col) {
        vis[i][j] = col;
        int dx[] = { -1, 1, 0, 0 };
        int dy[] = { 0, 0, -1, 1 };
        int sum = 1;
        for (int k = 0; k < 4; k++) {
            int tx = dx[k] + i;
            int ty = dy[k] + j;
            if (tx < n && ty < m && tx >= 0 && ty >= 0 && vis[tx][ty] == 0 && grid[tx][ty] == 1) {
                sum += dfs(tx, ty, n, m, grid, vis, col);
            }
        }
        return sum;
    }

    public int MaxConnection(int grid[][]) {
        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] arr = new int[n][m];
        int[] col = new int[n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = 0;
            }
        }
        int cnt = 1, res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && arr[i][j] == 0) {
                    int sum = dfs(i, j, n, m, grid, arr, cnt);
                    col[cnt] = sum;
                    res = Math.max(res, sum);
                    cnt++;
                }
            }
        }
        int dx[] = { -1, 1, 0, 0 };
        int dy[] = { 0, 0, -1, 1 };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    TreeSet<Integer> st = new TreeSet<>();
                    st.add(arr[i][j]);
                    for (int k = 0; k < 4; k++) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        if (tx >= 0 && ty >= 0 && tx < n && ty < m && arr[tx][ty] > 0) {
                            st.add(arr[tx][ty]);
                        }
                    }
                    int tmp = 0;
                    for(Integer x: st){
                        tmp += col[x];
                    }
                    res = Math.max(res, tmp + 1);
                }
            }
        }
        return res;
    }
}