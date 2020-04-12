#include <iostream>
#include "pizza.hpp"
#include "toppings.hpp"
//adapted from https://www.geeksforgeeks.org/decorator-pattern-set-3-coding-the-design/
using namespace std;

// Driver class and method
int main() {
    // create new RegularDough pizza
    Pizza *pizza = new RegularDough{};
    cout << pizza->getDescription() << " Cost :" << pizza->getCost() << endl;

    // create new SourDough pizza
    Pizza *pizza2 = new SourDough{};

    // decorate it with freshtomato topping
    pizza2 = new Tomato(pizza2);

    //decorate it with Pepperoni topping
    pizza2 = new Pepperoni(pizza2);

    cout << pizza2->getDescription() << " Cost :" << pizza2->getCost() << endl;
    return 0;
}