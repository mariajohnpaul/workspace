/*
 * cpptest.cpp
 *
 *  Created on: Sep 14, 2014
 *      Author: maria_000
 */
#include <iostream>
#include <cmath>
using namespace std;

int height(int n) {
    if(n%2)return((pow(2,(((n+1)/2)+1)))-1);
        else return((pow(2,((n+1)/2)+1))-2);
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



