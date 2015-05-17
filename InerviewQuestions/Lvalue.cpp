/*
 * Lvalue.cpp
 *
 *  Created on: Oct 7, 2014
 *      Author: maria_000
 */

#include <iostream>
using namespace std;

//int gvar;
const int foo(void)
{
	//gvar=2;
	return 2;
}

class jp{

public:
	int a,b;
	jp():a(5),b(10){};
	jp operator =(jp &x)
	{
		this->a = x.a;
		return *this;
	};
};

int main()
{
	jp a;
	a.a=3;
	jp *pt = new jp();
	*pt=a;
	a.a=5;
	cout<<pt->a;
	foo();
	//cout<<gvar;
	cout<<foo();
	return 1;
}


