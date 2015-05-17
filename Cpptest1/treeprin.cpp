/*
 * treeprin.cpp
 *
 *  Created on: Oct 26, 2014
 *      Author: maria_000
 */

#include<iostream>
#include<algorithm>
#include<vector>
#include<map>
#include<queue>
using namespace std;

struct Node{
	int data;
	Node *left;
	Node *right;

	Node(int x):data(x)
	{
		left=NULL;
		right=NULL;
	}
};

queue<Node*> qu;
Node *root = new Node(1);
void print_order(Node *inp){
	if(!inp)
	{
		return;
	}
	/*cout<<inp->data<<" ";
	print_order(inp->left);
	print_order(inp->right);
*/
	Node *temp=inp;
	qu.push(inp);

	int jp=10;
	while(temp)
	{
		cout<<temp->data;
		qu.push(temp->left);
		qu.push(temp->right);
		qu.pop();
		temp=qu.front();

	}

}

void make_tree(Node *inp)
{
	Node *temp=inp;
	queue<Node*> mk;
	mk.push(temp);
while(!qu.empty())
{
	temp->left=qu.front();
	qu.pop();
	mk.push(temp->left);
	temp->right=qu.front();
	qu.pop();
	mk.push(temp->right);
	mk.pop();
	temp=mk.front();


}
}

int main()
{
	vector<int> vi;
	for(int i=2;i<12;i++)qu.push(new Node(i));
	//build_binarytree
	//string st={"BLOOMBERG"};

	make_tree(root);


/*	root->left=new Node(2);
	root->right=new Node(3);
	root->left->left= new Node(4);
	root->left->right=new Node(5);*/



	print_order(root);

	return 1;
}

