/*
 * Binery_tree.cpp
 *
 *  Created on: Oct 2, 2014
 *      Author: maria_000
 */
#include <iostream>
#include<cstdlib>
using namespace std;
class BineryTree {
private:

	struct BV {
		int data;
		BV * top;
		struct BV *left;
		struct BV *right;

		BV(void) {
			top = NULL;
			left = NULL;
			right = NULL;
		}
	};
	struct BV *root;
public:
	bool found;
	BineryTree() {
		root = NULL;
		found = 0;
	}
	void addnode(int val) {
		if (!root) {
			root = new BV;
			root->data = val;
			return;
		} else {
			bool found = 0;
			BV *itr = root;
			while (!found) {
				if (val < itr->data) {
					if (itr->left) {
						itr = itr->left;
						continue;
					} else {
						itr->left = new BV;
						(itr->left)->data = val;
						return;
					}
				} else if (val > itr->data) {
					if (itr->right) {
						itr = itr->right;
						continue;
					} else {
						itr->right = new BV;
						(itr->right)->data = val;
						return;
					}
				} else {
					return;
				}
			}
		}

	}

	int search(int Val) {
		BV *itr = root;
		int count = 0;
		while (itr) {
			count++;
			if (Val > itr->data) {
				itr = itr->right;
			} else if (Val < itr->data) {
				itr = itr->left;
			} else {
				found = 1;
				cout << "\n John i found " << itr->data;
				return count;

			}
		}
		return count;
	}

	void printallnodes(void) {
		BV *itr = root;
	}
};

class BinArr: BineryTree {
	int *arr;
	int current;
public:
	bool found;
	BinArr() {
		BineryTree();
		try{
		arr = new int[10001];
		}
		catch(bad_alloc)
		{
cout<<"bad_alloc";
		};
		found =0;
		for (int i = 0; i < 10000; i++)
		{
			cout<<i<<"\n";
			arr[i] = -1;
		}
		current = 0;
	}
	void add(int Val) {
		unsigned int itr = 0;
		if (arr[0] == -1) {
			arr[0] = Val;
			return;
		}
		while (arr[itr] != -1) {
			if (Val < arr[itr]) {
				//left
				itr = itr * 2 + 1;

			} else if (Val > arr[itr]) {
				//right
				itr = itr * 2 + 2;
			} else {
				//value already there
				return;
			}
		}
		arr[itr] = Val;
		return;
	}
	int search(int Val) {
		int itr = 0;
		int count=0;
		while (arr[itr] != -1) {
			count++;
			if (Val < arr[itr]) {
				//left
				itr = itr * 2 + 1;

			} else if (Val > arr[itr]) {
				//right
				itr = itr * 2 + 2;
			} else {
				//value already there
				found=1;
				return count;
			}

		}
		return count;
	}

};

int main() {
	int nv;
	cout << "Enter the number of values to be stored in Binery Tree \n";
	cin >> nv;
	nv%=1001;
	//BineryTree Jp;
	BinArr  JpArr;
	while (nv) {
		nv--;
		unsigned int val = rand() % 1000;
		cout << val << "\n";
		//Jp.addnode(val);
		JpArr.add(val);
	}
	cout << "Enter the Value to search";
	cin >> nv;
	//nv = Jp.search(nv);
	nv=JpArr.search(nv);
	if (JpArr.found) {
		cout << "\n Found in no of iteration " << nv;
	} else {
		cout << "\n Not Found in no of iteration " << nv;
	}

}

