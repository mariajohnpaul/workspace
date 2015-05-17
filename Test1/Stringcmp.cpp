
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    string S1,S2;
    cin>>S1>>S2;

    sort(S1.begin(),S1.end());
    sort(S2.begin(),S2.end());
    int ans= search(S1.begin(),S1.end(),"a");
    int ans=0,i,j;
    for( i=0,j=0;i<S1.length() && j<S2.length();)
        {

            if(S1[i]!=S2[j])
                {
                if(S1[i]<S2[j])
                    {
                    i++;
                    ans++;
                }else
                    {
                    j++;
                    ans++;
                }
            }else
                {
                i++;
                j++;
            }

    }
    if(j<i)
        {
        ans+=S2.length()-j;
    }
     if(i<j)
        {
        ans+=S1.length()-i;
    }
    cout<<ans;
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    return 0;
}




