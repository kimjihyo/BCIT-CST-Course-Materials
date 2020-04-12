#include <iostream>
#include <memory>

using namespace std;

class stores_an_int {
public:
  stores_an_int(): i{new int(0)} { }
  stores_an_int(int i): i{new int(i)} { }
  ~stores_an_int() { if(i) { delete i; } } //need proper destructor
private:
  int* i; //store int with pointer
};

class also_stores_an_int {
public:
  also_stores_an_int(): i{new int(0)} { }
  also_stores_an_int(int i): i{new int(i)} { }
  //There's no destructor!!!
private:
  unique_ptr<int> i; // Don't need a destructor now!
};

int main()
{
  stores_an_int ten(10);
  stores_an_int fifty(50);

  also_stores_an_int also_ten(10);
  also_stores_an_int also_fifty(50);
  return 0;
}