//
// Created by A00257049 on 2019-01-31.
//

#include "Example.hpp"

void mySwap(Example& first, Example& second) {
    using std::swap;
    swap(first.size, second.size); //using std::swap
    swap(first.my_list, second.my_list); //using std::swap
}