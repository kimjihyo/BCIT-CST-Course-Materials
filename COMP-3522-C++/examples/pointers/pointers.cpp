#include <iostream>

using namespace std;

int main()
{
	cout << sizeof(int) << "\n";
	cout << sizeof(int*) << "\n";

	int a{10};
	int b{7};
	int * c{nullptr};

	c = &a; // stores the address of a in the pointer c

	cout << "c address: " << &c << "\n"; // prints the address of c
	cout << "a address pointed by c: " << c << "\n"; // prints the address of a
	cout << "a address: " << &a << "\n"; // prints the address of a
	cout << "dereference c to get a's value: " << *c << "\n"; // prints 10

	*c = -4; //change value of a through c
	cout << a << "\n"; // prints new value of a
	
	c = &b; //change c to point to b
	cout << "c address: " << &c << "\n"; // prints the address of c
	cout << "b address pointed by c: " << c << "\n"; // prints the address of b
	cout << *c << "\n"; // prints 7

	return 0;
}