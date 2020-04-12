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
    // Use the make_shared<T> function to create a shared_ptr
    shared_ptr<name> ptr = make_shared<name>("Kelvin");

    ptr->display_name();

    modify_name(ptr.get());

    // now ptr and anotherPtr are both pointing to
    // the "Kelvin" object
    shared_ptr<name> another_pointer = ptr;

    cout << ptr.use_count() << "\n";

    // now ptr switches to pointing to "Denny", but the "Kelvin"
    // object is not deleted as another_pointer is still holding it
    ptr.reset(new name("Denny"));

    cout << ptr.use_count() << "\n";

    // now no shared_ptr object is referencing the "Kelvin"
    // name, so it is deleted
    another_pointer.reset();

    cout << another_pointer.use_count() << "\n";

    // "Denny" will be automatically deleted when ptr goes out of scope
    return 0;
}