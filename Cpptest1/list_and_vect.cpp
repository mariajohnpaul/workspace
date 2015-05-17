/*
 * list_and_vect.cpp
 *
 *  Created on: Oct 26, 2014
 *      Author: maria_000
 */


#include<iostream>
#include<vector>
#include<list>
#include<cmath>
#include<cstdlib>
#include<set>
#include<map>
#include<bitset>
using namespace std;
int main()
{
/*	vector<int> vi;
	for(int i=0;i<10;i++)
		{
		int vlu= rand();
		vi.push_back(rand()%100);

		}
vector<int>::iterator i;
	for(i=vi.begin();i<vi.end();i++)
		cout<<vi[*i]<<"\n";*/

/*	list<char> Ls1;

	for(int i=0;i<5;i++)
	{
		char temp;
		cin>>temp;
		Ls1.push_back(temp);
		}
Ls1.reverse();
list<char>::iterator itr = Ls1.begin();

for(itr;itr!=Ls1.end();itr++)
	cout<<*itr;*/

/*
	multimap<int,string> jp;

	jp.insert(pair<int,string>(1,"1john"));
	jp.insert(pair<int,string>(2,"2john"));
	jp.insert(pair<int,string>(2,"3john"));
	jp.insert(pair<int,string>(4,"4john"));


	multimap<int,string>::iterator itr = jp.find(1);
	if(itr!=jp.end())
	cout<<itr->first<<itr->second<<" found 1\n";
	jp.erase(itr);
	itr = jp.find(1);

	jp.erase(3);

	if(itr!=jp.end())
	cout<<itr->first<<itr->second<<"\n";
	for(map<int,string>::iterator itr=jp.begin();itr!=jp.end();itr++)
		{
			cout<<itr->first<<itr->second<<"\n";
		}
*/


	bitset<8> bt;
	bt.set();
	cout<<bt;

}

