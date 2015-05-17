#include<iostream>
using namespace std;
class singleton{
private:

	singleton()
{
		//singleton::val++;
		cout<<"created no of times \n ";//<<singleton::val;
}

	singleton(const singleton &);
public:


	int val;
	static singleton* getinstance()
	{
		static singleton *ptr=new singleton();
		return ptr;
	}
	void print(void)
	{
		cout<<"hi \n";
	}
	friend void friendf(singleton *);
};

/*void test(singleton jp)
{
	jp.val++;
	cout<<"check created again\n";

}*/

void friendf (singleton *pt)
{
pt->val++;
}
int main()
{
	singleton *jp = singleton::getinstance();
	//test(*jp);

	friendf(jp);
	friendf(jp);
	cout<<jp->val;

jp->print();

	return 0;
}
