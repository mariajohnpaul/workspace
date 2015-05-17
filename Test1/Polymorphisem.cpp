#include<iostream>
using namespace std;
class Base {

public:
	int value;
	void love(void){
		cout<<"hello at base\n ";
	};
	Base():value(20) {
		cout << "Constructor at Base\n ";

	}
	virtual ~Base() {
		cout << "Destructor at base\n ";
	}

};
class Derived: public virtual Base {
public:
	void love(void) {
		cout << "Love at Deriv\n ";
	}
	Derived() {
		cout << "Constructor at Derived\n ";
	}
	virtual ~Derived() {
		cout << "Destructor at derived\n ";
	}

};

class Derived1: public virtual Base {
public:
	void love(void) {
		cout << "Love at Deriv\n ";
	}
	Derived1() {
		cout << "Constructor at Derived1\n ";
	}
	virtual ~Derived1() {
		cout << "Destructor at derived1\n ";
	}

};

class twoderive:public Derived, public Derived1{
public:

twoderive()
{
	cout<<"constructor in two drive\n ";
}

};

void pol(Base *bptr) {
	(*bptr).love();
	delete (bptr);
	bptr=NULL;
}
/*

void pol(twoderive **pt)
{
	delete(*pt);
	*pt=NULL;
}
*/

int main() {
	//Derived *dv = new Derived();
	//pol(dv);
	twoderive *tdr=new twoderive();
	pol(tdr);
delete(tdr);
	try{
		if(!tdr){throw(1);}
		else{
			cout<<"ponter is ok";
	int jp = tdr->value;
	tdr->Derived::love();
		}
	}catch(exception& e)
	{
     cout<<"John Something happened" << e.what();
	}catch(int a)
	{
		cout<<"John Something happened GOT INT" ;
	}

	cout << "john\n ";

}
