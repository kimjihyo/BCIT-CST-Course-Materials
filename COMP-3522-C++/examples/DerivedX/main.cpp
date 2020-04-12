#include <iostream>

using namespace std;
class A
{
private:
    int x;
public:
    void setX(int x) {this->x = x;}
    virtual void print() {cout << "A x:" << x << endl;}
};

class B : public A
{
private:
    int x;
public:
    void print() override
    {
        A::print();
        cout << "B x:" << x << endl;
    }
};

int main() {
    A a;
    B b;
    b.setX(2);
    b.print();

    return 0;
}