#include <iostream>
#include <memory>
#include <string>

using namespace std;

class name {
public:
    name(const char* s) : data{s}
    { cout << "Constructing the name " << data << "\n"; };
    void display_name() { std::cout << data << "\n"; }
    ~name() { cout << "Destroying the name " << data << "\n"; }
private:
    string data;
};

void modify_name(name* m) { /* Do something to the name here */ }

int main()
{
    name *namePtr = new name("Kelvin");
    shared_ptr<name> p1(namePtr); //sole owner of kelvin
    //shared_ptr<name> p1 = make_shared<name>("Kelvin"); //more efficient version of above

    //shared_ptr<name> p2(namePtr); //sole owner of kelvin - problems if p1 deletes kelvin
    shared_ptr<name> p2 = p1; //p2 shared with p1
    cout << "p1 count: " <<  p1.use_count() << endl;
    cout << "p2 count: " <<  p2.use_count() << endl;
    p1.reset();
    cout << "reset p1" << endl;
    cout << "p1 count: " <<  p1.use_count() << endl;
    cout << "p2 count: " << p2.use_count() << endl;

    return 0;
}