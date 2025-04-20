//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int n = input_line.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minTime(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    boolean isPossible(int k, int arr[], int maxi){
        int painters = 1;
        int totalUnit = 0;
        for(int ele : arr){
            if(ele+totalUnit <=maxi){
                totalUnit+=ele;
            }else{
                painters++;
                totalUnit=ele;
                
                if(painters>k) return false;
            }
        }
        
        return true;
    }
    
    
    public int minTime(int[] arr, int k) {
        // code here
        
        int low = Integer.MIN_VALUE;
        int high = 0;
        
        
        for(int i=0; i<arr.length; i++){
            low = Math.max(low, arr[i]);
            high+=arr[i];
        }
        
        int ans = low;
        
        while(low <=high){
            int mid = low+ (high-low)/2;
            
            if(isPossible(k, arr, mid)){
                high = mid-1;
                ans = mid;
            }else low = mid+1;
        }
        
        return ans;
    }
}