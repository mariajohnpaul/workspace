/*
 * template.cpp
 *
 *  Created on: Oct 25, 2014
 *      Author: maria_000
 */

#include<iostream>
using namespace std;

template<typename T>
T john(T x) {
	int *y = reinterpret_cast<int*>(&x);

	//cout<<*y<<hex;

	cout << *y << "\n";
	return x;
}

template<typename A, typename B>
void john(A a, B b) {
	a = a + b;
}

template<typename T>
class auto_ptr {
private:
	T *ptr;
public:
	auto_ptr(T *temp) {
		ptr=temp;
		cout << "implement auto pointer";
	}
	~auto_ptr() {
		cout << "DELETING auto pointer";
		delete ptr;
		ptr=NULL;
	}
T& operator=(T *temp)
{
	ptr=temp;
	return ptr;
}
T& operator*()
{
	return *ptr;
}
T* operator->()
{
	return ptr;
}

};

int main() {
	auto_ptr<int> jp (new int);
	*jp=2;

cout<<*jp;
{
	auto_ptr<int> q(new int);
}
	//cout<<john(2);
	cout << john("a");
	//cout<<john(2.3);
}
