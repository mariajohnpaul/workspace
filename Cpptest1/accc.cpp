/*
 * accc.cpp
 *
 *  Created on: Oct 25, 2014
 *      Author: maria_000
 */
#include <iostream>
using namespace std;
class base
{
private :

protected :
	int prba;
public:

	int puba;
	base(int i=10)
	{
		cout<<"passed value"<<i;
		cout<<"base prba value "<<prba<<"\n";
	}
};
class derived1:public base{
private :
	int prda;
public :
	int puda;
	derived1(int i):base(i)
	{
		cout<<"derived prba value "<<prba<<"\n";
	}
};
int main()
{
base bp;
derived1 dr(22);


}


