#include <iostream>

using namespace std;

int main()
{
	int a = 10;
	int & b = a;

	cout << b << endl;

	b = 8;
	cout << b << "\n";
	cout << &b << endl;
	cout << &a << endl;
	cout << a << "\n";

	int & c = b;
	c = 4;

	cout << a << "\n";

	cout << "addresses" << endl;
	cout << &a << "\n";
	cout << &b << "\n";
	cout << &c << "\n";

	//c gets the value of d, it's not an alias of d
	int d = 999;
	c = d;
    cout << c << "\n";
    cout << "addresses" << endl;
    cout << &a << "\n";
    cout << &c << "\n";
    cout << &d << endl;

	return 0;
}