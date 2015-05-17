/*
 * test1.cpp
 *
 *  Created on: Sep 20, 2014
 *      Author: maria_000
 */

#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
inline bool isodd(int x) {
	return ((x % 2) == 1);
}

double area(double a) {

	return a * a;
}
float area(float a) {
	return a * a;
}

int main() {
	vector<int> col;
	int arr[] = { 1, 3, 4, 6, 12, 45 };
	for (int i = 0; i <= 5; i++)
		col.push_back(arr[i]);
	//int c = count_if(col.begin(), col.end(), [](int x){return(x%2);});
	//cout << c;
	//int c = area(arr[1]);
	//c=area(2.2);
	try {
		int *pt = new int[90000000];
		int i;
		cin>>i;
		//delete(pt);
		delete [] pt;

	} catch(bad_alloc &)
	{
		cout<<"allocaton failed";
	}

	cout << area(2.2);
	cout << area(11111111111111111111.111111111111111111111111);


	return 1;
}

