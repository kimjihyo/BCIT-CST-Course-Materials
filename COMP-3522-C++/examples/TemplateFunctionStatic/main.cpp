#include <iostream>

using namespace std;

template <typename T>
void fun(const T& x)
{
    static int i = 0;
    cout << ++i;
    return;
}

int main()
{
    fun<int>(1);  // prints 11
    cout << endl;
    fun<int>(2);  // prints 12
    cout << endl;
    fun<double>(1.1); // prints 11
    cout << endl;
    return 0;
}