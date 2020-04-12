#include <iostream>
#include <string>

/*
 * Inherit constructors with the using::parent_class::parent_constructor notation
 */

class person 
{
  public:
    person() {}
    person(const std::string& name) : name(name) {}

    void set_name(const std::string& n) { name= n; }
    std::string get_name() const { return name; }
    void all_info() const { std::cout << "[person name=" << name << "]" << std::endl; }
    
  private:
    std::string name;
};

class student  : public person
{
    using person::person;
    //using person::person; is equivalent to writing the below
    //student() {}
    //student(const std::string& name) : person(name) {}
};

int main () 
{
    person trixie("Serena Chacha");
    trixie.all_info();

    student bill("Bill Gates");
    bill.all_info();

    return 0 ;
}
