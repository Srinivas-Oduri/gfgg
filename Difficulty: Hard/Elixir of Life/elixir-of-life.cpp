//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

//User function Template for C++

class Solution
{
    public:
   int maxFrequency(string s)
    {
        int size=1;
        string ans;
        for(int i=0;i<s.size()-1/2;i++){
            if(s.substr(0,i)==s.substr(s.size()-i,i) && s.substr(0,i)!="\0"){
                ans=s.substr(0,i);break;
            }
        }
        if(ans=="\0"){return 1;}
        int c=0;
        for(int i=0;i<s.size()-ans.size()+1;i++){
            if(s.substr(i,ans.size()) == ans){
                c++;
            }
        }
        return c;
    }
};


//{ Driver Code Starts.

int main() 
{
   	ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);
   	int t;
   	cin >> t;
   	while(t--)
   	{
   		string str;
   		cin >> str;
   		Solution obj;
   		cout << obj.maxFrequency(str) << "\n";
   	
cout << "~" << "\n";
}
    return 0;
}
// } Driver Code Ends