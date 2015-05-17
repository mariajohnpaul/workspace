/*
 * exception.cpp
 *
 *  Created on: Oct 26, 2014
 *      Author: maria_000
 */
#include<iostream>
using namespace std;
class base{
public:
	int a;
	base()
	{

	}
	virtual ~base(){};
	virtual void print(void)
	{
		cout<<"base\n";
	}
	virtual void fdr2(void)
	{

	}
};
class dr1:public base{
void print(void)
{
	cout<<"dr1\n";
}

};



class dr2:public base{
public:
	char k;
	void print(void)
	{
		cout<<"dr2\n";
	}
	virtual void fdr2(void)
	{
		cout<<"function at dr2\n";
	}

};

void func(base *b)
{
	try{
	dr2 *drp=dynamic_cast<dr2*>(b);

	if(!drp)
	{
		cout<<"pointing to wrong";
	}

	}catch(std::exception &exp)
	{
cout<<exp.what();
	}
b->print();
b->a=20;
b->fdr2();

}

int main()
{
	//try
	{
	//int *N=new int[100000000000000000000000000000000000000000000000];
	}
	//catch (std::exception &exp)
	{
		dr2 *drr1=new dr2();
		func(drr1);
//cout<<"Exception caught"<<exp.what();

	}
}



