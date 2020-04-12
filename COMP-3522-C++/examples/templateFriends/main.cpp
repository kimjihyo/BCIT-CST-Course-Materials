#include <iostream>

using namespace std;
template <typename T>
class A {
    T t;
public:
    A(T t) : t(t) {}

    //option 1 - create new template parameter name, write body outside
    template<class U>
    friend A<U> foo(A<U>& a);

    //option 2 - no template redefinition, write definition in place
    friend A<T> foo2(A<T>& a) {
        cout << "foo2 - " << a.t << endl;
        return a;
    }
};

//completing option 1 definition outside body
template<class T>
A<T> foo(A<T>& a)
{
    cout << "foo - " << a.t << endl;
    return a;
}

int main() {
    A<int> a{5};
    a = foo(a);
    a = foo2(a);
    return 0;
}