#include <iostream>
#include <memory>

using namespace std;

class A {
	int n;
public:
	A(int n) : n{n} {}
	~A(){cout << "destroy A" << endl;}
	friend ostream& operator<<(ostream &os, const A& a) {
		os << a.n;
		return os;
	}
};

auto make_A(A n)
{
	//auto destroyed on leaving function. No memory leak
	return unique_ptr<A>(new A(n));
}

void show(unique_ptr<A> & a)
{
	cout << *a << "\n";
}

int main()
{
	auto pointer = make_A(3479);
	show(pointer);

	//pointer auto destroyed when program ends
	return 0;
}