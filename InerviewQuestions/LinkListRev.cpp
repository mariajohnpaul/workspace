/*
 * LinkListRev.cpps
 *
 *  Created on: Sep 30, 2014
 *      Author: maria_000
 */
#include<iostream>
using namespace std;

class Node *top;
class Node *end;
unsigned int count;

class Node{
private:


	class Node *next;
	class Node *prev;
	int data;



	class Node* createnode(void)
	{
		class Node *temp= (class Node*) new(class Node) ;
		if(count==0)
			{
			top=temp;
			end=temp;
			}
		count++;
		return temp;
	}
	void addnode(class Node* pt)
	{

		end->next=pt;
		//end->prev=end;
		pt->prev=end;
		end=pt;

	}

public:
	Node()
		{
		next = NULL;
		prev=NULL;
		}
	void add(int Val)
	{
		class Node *pt = createnode();
		pt->data=Val;
		addnode(pt);

	}
	void printlist(void)
	{
		class Node *iter = top;
		while(iter)
		{
		cout<<iter->data;
		iter=iter->next;
		}
	}
	void reverse(void)
	{
		class Node *temp =end;
    while(end!=top)
    {
    	end->next=end->prev;
    	end=end->next;

    }
    top=temp;
    top->prev=NULL;
    end->next=NULL;
	}

};

int main()
{
	class Node Jp;
	Jp.add(2);
	Jp.add(0);
	Jp.add(1);
	Jp.add(0);
	Jp.add(5);
	Jp.add(6);

	int i;
	cin>>i;
	while(i)
	{
		int t=0;
		cin>>t;
		Jp.add(t);
		i--;
	}

	Jp.printlist();
	cout<<"\n"<<"reversing\n";
	Jp.reverse();
	Jp.printlist();


}



