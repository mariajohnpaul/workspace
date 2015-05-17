#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


// It is NOT mandatory to use the provided template. You can handle the IO section differently.

int main() {

int N, K, unfairness;
    cin >> N >> K;
    long int candies[N];

    for (int i=0; i<N; i++)
        cin >> candies[i];
    //sort for only K elements

    sort(candies,candies+N);
   /* for(int j=0;j<N;j++)
        {
        int small=candies[j];
    for(int i=j+1;i<N;i++)
        {
        if(small>candies[i])
            {
            small=candies[i];
            candies[i]=candies[j];
            candies[j]=small;
        }
    }
    }*/

   for(int i=0;i<N;i++)cout<<candies[i]<<" ";

    long int ans=1<<30;
    for(int i=0;i<N-K+1;i++)
    {
       int temp = candies[i+K-1]-candies[i];
        if(temp<ans)ans=temp;
    }

    //cout<<i+K-1;
    unfairness=ans;
    /** Write the solution code here. Compute the result, store in  the variable unfairness --
    and output it**/
    cout << unfairness << "\n";
    return 0;
}
