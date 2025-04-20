//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            int N = S.length();
            Solution ob = new Solution();
            String[] element = br.readLine().trim().split("\\s+");
		    int[] f = new int[N];
		    for(int i = 0; i < N; i++){
		        f[i] = Integer.parseInt(element[i]);
		    }
            ArrayList<String> res  = ob.huffmanCodes(S,f,N);
            for(int i = 0; i < res.size(); i++)
            {
                System.out.print(res.get(i)+" ");
            }
            System.out.println();
        
System.out.println("~");
}
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    static public class Node {
        int val;
        Node left, right;
        public Node(int val, Node left, Node right) {
            this.val = val; this.left = left; this.right = right;
        }
    }
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)-> (a.val != b.val) ? a.val - b.val : 1);
        for(int v : f) {
            pq.add(new Node(v, null, null));
        }
        
        while(pq.size()>1) {
            Node n1 = pq.poll(), n2 = pq.poll();
            pq.add(new Node(n1.val + n2.val, n1, n2));
        }
        
        ArrayList<String> res = new ArrayList();
        traverse(pq.poll(), "", res);
        return res;
    }
    
    void traverse(Node node, String code, ArrayList<String> strs) {
        if(node.left == null) {
            strs.add(code);
        } else {
            traverse(node.left, code+'0', strs);
            traverse(node.right, code+'1', strs);
        }
    }
}