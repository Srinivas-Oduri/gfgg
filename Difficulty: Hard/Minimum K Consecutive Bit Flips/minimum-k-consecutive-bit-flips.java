//{ Driver Code Starts
import java.io.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    static int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int flips = 0;
        int flipped = 0; 
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
           
            if (!queue.isEmpty() && queue.peek() == i) {
                queue.poll();
                flipped ^= 1; 
            }

            if ((arr[i] ^ flipped) == 0) { 
                if (i + k > n) return -1; 
                
                flips++;
                queue.add(i + k); 
                flipped ^= 1;
            }
        }
        return flips;
    }
}


//{ Driver Code Starts.

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int k = Integer.parseInt(br.readLine());
            System.out.println(new Solution().kBitFlips(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends