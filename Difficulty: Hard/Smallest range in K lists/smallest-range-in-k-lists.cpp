//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;
#define N 1000


// } Driver Code Ends

// you are required to complete this function 
// function should print the required range
class Solution{
    public:
    pair<int,int> findSmallestRange(int KSorted[][N], int n, int k)
    {
        //code here
          
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>,
        greater<pair<int, pair<int, int>>>> minHeap;
        int maxi=INT_MIN;
        for(int i=0;i<k;i++){
            minHeap.push({{KSorted[i][0]},{i,0}});
            maxi=max(KSorted[i][0], maxi);
           // cout<<KSorted[i][0]<<endl;
        }
        int start=0;
        int end=INT_MAX;
        while(!minHeap.empty()){
            auto  x=minHeap.top();
            int val=x.first;
            int row=x.second.first;
            int col=x.second.second;
        //cout<<maxi<<endl;
            minHeap.pop();
            //cout<<row<<" "<<col<<endl;
            if(maxi-val<end-start){
               // cout<<start<<endl;
                start=val;
                end=maxi;
            }
            //cout << start << " " << end << endl;
            if(col + 1 <n){ 
                minHeap.push({KSorted[row][col+1], {row, col+1}});

                maxi=max(KSorted[row][col+1], maxi);
               // cout<<maxi<<endl;
            }
            else{
                break;
            }
        }
        return {start,end};
    }
};


//{ Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n, k;
        cin>>n>>k;
        int arr[N][N];
        pair<int,int> rangee;
        for(int i=0; i<k; i++)
            for(int j=0; j<n; j++)
                cin>>arr[i][j];
        Solution obj;
	    rangee = obj.findSmallestRange(arr, n, k);
	    cout<<rangee.first<<" "<<rangee.second<<"\n";
    
cout << "~" << "\n";
}   
	return 0;
}


// } Driver Code Ends