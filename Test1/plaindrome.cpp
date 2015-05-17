#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int T=0;
    string input;
    //cin>>T;
    T=1;
        for(int i=0;i<T;i++)
        {
        //cin>>input;
        	input="abc";
            //int len=input.size()-1;
        	int len=0;
            while(input[len++]!='\0');
            cout<<len;
            int ans=0;
            for(int j=0,k=len;j<k;j++,k--)
            {
                if(input[j]>input[k])
                    {
                    ans+=(input[j]-input[k]);
                }else
                    {
                    ans+=(input[k]-input[j]);
                }
            }
            cout<<ans<<"\n";
    }
    return 0;
}
