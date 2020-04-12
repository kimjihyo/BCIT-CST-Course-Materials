//
// Created by A00257049 on 2019-01-31.
//
#include <iostream>

#ifndef COPYSWAP_EXAMPLE_HPP
#define COPYSWAP_EXAMPLE_HPP

using namespace std;
class Example {
  private:
    size_t size;
    int * my_list;
public:
    //default constructor
    Example(size_t size = 0) : size{size}, my_list{size ? new int[size] : nullptr} {}

	  //copy constructor
    Example(const Example& other) : size{other.size}, my_list{size? new int[size] : nullptr}
    {
        // A loop here to copy the data…
        for(int i=0; i<size; i++)
        {
            my_list[i] = other.my_list[i];
        }
    }

    friend void mySwap(Example& first, Example& second);

    void setVal(int index, int val)
    {
        my_list[index] = val;
    }

    void print() {
        for(int i=0; i<size; i++)
        {
            cout << my_list[i] << " ";
        }
        cout << endl;
    }

    ~Example(){delete[] my_list;}
}; // Now we are at the end of Example class



#endif //COPYSWAP_EXAMPLE_HPP
