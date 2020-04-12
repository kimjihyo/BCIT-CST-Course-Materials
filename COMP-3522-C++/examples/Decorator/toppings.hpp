//
// Created by A00257049 on 2019-03-28.
//

#ifndef DAY2_TOPPINGS_HPP
#define DAY2_TOPPINGS_HPP
/*
 * Concrete toppings classes
 * */
#include <iostream>
class Tomato : public ToppingsDecorator
{
public:
    Tomato(Pizza *pizza) { this->pizza = pizza; }
    std::string getDescription() override {
        return pizza->getDescription() + ", Tomato ";
    }
    int getCost() override { return 50 + pizza->getCost(); }
};

class Pineapple : public ToppingsDecorator
{
public:
    Pineapple(Pizza *pizza) {  this->pizza = pizza;  }
    std::string getDescription() override {
        return pizza->getDescription() + ", Pineapple ";
    }
    int getCost() override {
        return 90 + pizza->getCost(); }
};
class Pepperoni : public ToppingsDecorator
{
public:
    Pepperoni(Pizza *pizza)  {  this->pizza = pizza; }
    std::string getDescription() override {
        return pizza->getDescription() + ", Pepperoni ";
    }
    int getCost() override {  return 75 + pizza->getCost(); }
};

// Other toppings can be coded in a similar way
#endif //DAY2_TOPPINGS_HPP
