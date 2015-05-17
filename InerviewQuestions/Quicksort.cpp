/*
 * Quicksort.cpp
 *
 *  Created on: Oct 9, 2014
 *      Author: maria_000
 */
#include <iostream>
using namespace std;

int arr[] = {12,334,1,2,4,5,6,8,7,66,99,34,56,74,13,15,14,100};

class sort{
public:
	void quicksort(int start, int end)
	{
		int ts =start,te=end;
		if((end-start)<2)
			return;
		int mid=((start+end)/2);
		while(end>start)
		{
			if(arr[start]<arr[mid])
			{
				start++;
			}
			if(arr[end]>arr[mid])
			{
				end--;
			}
			if(arr[start]>=arr[mid] && arr[end]<=arr[mid])
						{

							if(arr[start]==arr[mid])
							{
								mid=end;
							}
							if(arr[end]==arr[mid])
							{
								mid=start;
							}

							//swap
							int temp= arr[start];
							arr[start]=arr[end];
							arr[end]=temp;

						}



		}
		quicksort(ts,start);
		quicksort(start,te);
		return;
	}
};
int main()
{
class sort jp;
jp.quicksort(0,17);
for(int i=0;i<18;i++)
	cout<<arr[i]<<",";
}



