  #include <iostream>
#include <cmath>
using namespace std;

int height(int n) {
int x=n;
    n=((n+1)/2)+1;
    if(x%2)return((pow(2,n))-2);
        else return((pow(2,n))-1);
    return 0;
}
int main() {
    int T;
    cin >> T;
    while (T--) {
        int n;
        cin >> n;
        cout << height(n) << endl;
    }
}
