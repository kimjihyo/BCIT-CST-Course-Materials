//
// Created by A00257049 on 2019-03-28.
//

#ifndef DAY2_PIZZA_HPP
#define DAY2_PIZZA_HPP
// Abstract Pizza class (All classes extend
// from this)
#include <iostream>

class Pizza
{
public:
    // it is an abstract pizza
    std::string description = "Unknown Pizza";

    virtual std::string getDescription()
    {
        return description;
    }
    virtual int getCost() {return 0;}
};

// The decorator class :  It extends Pizza to be
// interchangable with its toppings decorator can
// also be implemented as an interface
class ToppingsDecorator : public Pizza
{
protected:
    Pizza *pizza;
};

/*
 * Concrete pizza classes
 * */
class RegularDough : public Pizza
{
public:
    RegularDough() {  description = "Regular Dough Pizza"; }
    int getCost() override {  return 100;  }
};

class WheatDough : public Pizza
{
public:
    WheatDough()  { description = "Wheat Dough Pizza"; }
    int getCost() override {  return 200;  }
};

class SourDough : public Pizza
{
public:
    SourDough() { description = "Sour Dough Pizza"; }
    int getCost() override {  return 300; }
};
#endif //DAY2_PIZZA_HPP
