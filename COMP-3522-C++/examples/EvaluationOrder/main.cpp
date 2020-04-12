#include <iostream>

int f(int a)
{
    std::cout << "function f: " << a << std::endl;
    return a;
}

int g(int a)
{
    std::cout << "function g: " << a << std::endl;
    return a;
}

int main()
{
    int a = 1, b = 2, c;
    c = f(++a) + g(++a) + b;
    std::cout << c;
}