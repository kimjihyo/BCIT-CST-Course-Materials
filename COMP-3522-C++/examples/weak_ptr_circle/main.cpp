#include <iostream>
#include <memory>

using namespace std;
struct Person {
    string name;
    //shared_ptr <Person> personRef; //circular reference
    weak_ptr <Person> personRef; //prevents circular reference
    Person(string name) : name(name) { cout << name <<" constructed\n"; }
    ~Person() { cout << name << " destructed\n"; }
};

int main() {
    shared_ptr<Person> homer = make_shared<Person>("Homer");
    shared_ptr<Person> marge = make_shared<Person>("Marge");

    homer->personRef = marge;
    marge->personRef = homer;

    //shared pointers auto delete if personRef is a weak pointer
    return 0;
}