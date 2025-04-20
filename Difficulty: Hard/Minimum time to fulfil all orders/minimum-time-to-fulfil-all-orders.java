//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int l; 
            l = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, l);
            
            Solution obj = new Solution();
            int res = obj.findMinTime(n, l, arr);
            
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Solution {
    public static int findMinTime(int n, int l, int[] arr) {
        // code here
        //brute force T.C-> O(N*INT_MAX) S.C-> O(1)
        // int maxRank = Arrays.stream(arr).max().getAsInt();
        // int minTime = 1;
        // int maxTime = ((n*(n+1))/2) * maxRank;
        // int ans = maxTime;
        // for(int i=minTime; i<=maxTime; i++) {
        //     if(canMakeNDonuts(arr,l,n,i)) {
        //         ans = i;
        //         break;
        //     }
        // }
        // return ans;
        
        //optimal T.C-> O(N*log(INT_MAX)) i.e O(N*32) S.C->O(1)
        int low = 1, mid;
        int maxRank = Arrays.stream(arr).max().getAsInt();
        int high = ((n*(n+1))/2) * maxRank;
        int ans = high;
        while(low<=high) {
            mid = low + (high-low)/2;
            if(canMakeNDonuts(arr,l,n,mid)) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    //checks whether in given time whether N donuts can be made or not
    public static boolean canMakeNDonuts(int[] ranks, int l, int n, int maxTime) {
        int numOfDonutsMade = 0, currChefRank = 0, numOfDonutsCurrChefCanMake = 0;
        for(int i=0; i<l && numOfDonutsMade <=n; i++) {
            currChefRank = ranks[i];
            numOfDonutsMade += getNumOfDonutsMadeByChef(maxTime,currChefRank);
        }
        return numOfDonutsMade>=n;
    }
    // if chef with rank R can make 1 donut in 1R minutes then how many donuts can he make in
    // in given time so the formula is [n*(n+1)/2]*R <= maxTime
    // so the equation becomes (Rn^2 + Rn - 2*maxTime) <= 0
    // now simply solve this quadratic equation and find out the value of n which is the number of max donuts 
    // the chef with rank R can make in given time
    public static int getNumOfDonutsMadeByChef(int maxTime, int rank) {
        int root = (int) Math.sqrt((rank*rank) + (8*rank*maxTime));
        int x1 = (-rank + root)/(2*rank);
        int x2 = (-rank - root)/(2*rank);
        int ans = Math.max(x1,x2);
        return ans;
    }
}
        
