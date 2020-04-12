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

int main() {
    unique_ptr<name> ptr_unique_1(new name("Darren"));

    // We can use -> (and *) on the unique_ptr
    // just like with a normal pointer
    ptr_unique_1->display_name(); 

    // To get a raw pointer from the
    // unique_ptr we use the get() method
    modify_name(ptr_unique_1.get()); 

    // Use std::move to transfer ownership
    // to ptr_unique_2 - ptr_unique_1 now holds no pointer
    unique_ptr<name> ptr_unique_2(std::move(ptr_unique_1));

    // assign a new pointer to ptr_unique_1
    ptr_unique_1.reset(new name("Haruna"));

    // assign a new pointer to ptr_unique_2
    // "Darren" will now automatically be deleted
    ptr_unique_2.reset(new name("Sid"));

    // set ptr_unique_1 to contain nothing
    // "Haruna" will now automatically be deleted
    ptr_unique_1.reset();

    // "Sid" will automatically deleted at the end of
    // this function, as ptr_unique_2 goes out of scope
    return 0;
}