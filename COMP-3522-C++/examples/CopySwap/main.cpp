#include <iostream>
#include "Example.hpp"

int main() {
    Example e{5};

    e.setVal(0,2); //at index 0, set value to 2
    e.setVal(4,9); //at index 4, set value to 9

    Example eCopy;
    cout << "ecopy contents: " << endl;
    eCopy.print();
    eCopy = e;

    cout << "e address: " << &e << endl;
    e.print();

    cout << "eCopy address: " << &eCopy << endl;
    eCopy.print();
    return 0;
}