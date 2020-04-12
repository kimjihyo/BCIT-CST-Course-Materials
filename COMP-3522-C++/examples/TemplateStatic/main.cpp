#include <iostream>

using namespace std;

template <typename T>
class Test {
private:
    T val;
public:
    static int count;
    Test()
    {
        count++;
    }
    // some other stuff in class
};

template<class T>
int Test<T>::count = 0;

int main()
{
    Test<int> a;  // value of count for Test<int> is 1 now
    Test<int> b;  // value of count for Test<int> is 2 now
    Test<int> b1;  // value of count for Test<int> is 2 now
    Test<int> b2;  // value of count for Test<int> is 2 now
    Test<int> b3;  // value of count for Test<int> is 2 now
    Test<int> b4;  // value of count for Test<int> is 2 now
    Test<double> c;  // value of count for Test<double> is 1 now
    cout << Test<int>::count   << endl;  // prints 2 //output is 6/7 something else???
    cout << Test<double>::count << endl; //prints 1 //output is 6/7 something else???


    return 0;
}