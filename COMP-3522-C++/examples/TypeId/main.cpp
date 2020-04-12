#include <iostream>
#include <stack>
#include <typeinfo>

int main()
{
    int a;
    std::stack<double> b;
    double c;

    std::cout << "a has type " << typeid(a).name() << std::endl;
    std::cout << "int has type " << typeid(int).name() << std::endl;
    std::cout << "b has type " << typeid(b).name() << std::endl;
    std::cout << "c has type " << typeid(c).name() << std::endl;


    return 0;
}