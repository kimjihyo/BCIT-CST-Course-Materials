#include <iostream>
//dynamic cast does runtime type checking. pointer evaluates to null if can't convert

class Base { public: virtual ~Base() { } };

class Derived : public Base { public: virtual ~Derived() { } };

class Unrelated { public: virtual ~Unrelated() { } };

int main()
{
	Derived d;
//	Base *b = dynamic_cast<Base *>(&d);
//	Unrelated *u = dynamic_cast<Unrelated *>(&d);

//	compare to
	Base *b = (Base *)(&d);
	Unrelated *u = (Unrelated *)(&d);
//	if (b) {
	if (u) {
		std::cout << "In the same inheritance hierarchy" << std::endl;
	}
	else {
		std::cout << "Not in the same inheritance hierarchy" << std::endl;
	}

}
