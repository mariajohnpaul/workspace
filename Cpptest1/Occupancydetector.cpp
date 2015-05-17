#include<iostream>
#include<map>
using namespace std;

map<int,int> occu;

void add(int x, int y)
{
	occu.insert(pair<int,int>(x,y));
}

void query(int time)
{
	map<int,int>::iterator mi=occu.begin();

	mi=occu.find(time);
	//if(mi!=occu.end())
cout<<mi->first;
	for(;mi!= occu.end();mi++)
	{
		if(mi->first == time)
		{
			if(mi->second)cout<<"not free";
			else cout<<"empty";
			return;
		}
		if(mi->first>time)
		{
			mi--;
			if(mi->second)cout<<"not free";
			else cout<<" empty";
			return;

		}
	}
	mi--;
	if(mi->second)cout<<"not free";
	else cout<<"empty";
	return;
}

int main()
{
add(42,0);
add(31,1);
query(30);
}
