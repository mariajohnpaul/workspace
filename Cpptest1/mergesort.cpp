/*
 * mergesort.cpp
 *
 *  Created on: Oct 27, 2014
 *      Author: maria_000
 */
#include<iostream>
#include<cstdlib>
using namespace std;

int buff[100];

void mergesort(int st,int end)
{
	if((end-st)<2)return;
	int mid=st+end/2;
	mergesort(st,mid);
	mergesort(mid+1,end);

	//merge code logic
	int i=0;
	int buf[end-st];
	int ost=st;
	int oend=end;
	int omid=mid;
	while(st<=end)
	{
if(st>omid+1)
{
	for(;mid<=oend;mid++)
		buf[i]=buff[mid];

	break;
}

if(mid>end)
{
	for(;st<=omid;st++)
		buf[i]=buff[st];

	break;
}
		if(buff[st]<buff[mid+1] )
		{
			buf[i++]=buff[st];
			st++;
		}else
		{
			buf[i++]=buff[mid+1];
			mid++;
		}
		i++;
	}
	//copy to original
for(int i=ost;i<oend;i++)
{
	buff[i]=buf[i];
}
}

int main()
{
	for(int i=0;i<100;i++)
	{
		buff[i]=rand()%100;
	}
	mergesort(0,5);
	for(int i=0;i<5;i++)
		cout<<buff[i];
}

