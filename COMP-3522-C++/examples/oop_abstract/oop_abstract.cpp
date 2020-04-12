#include <iostream>
#include <string>

class creature
{
public:
    virtual void all_info() const= 0;
};


class person  : public creature
{
  public:
    person() = default;
    person(const std::string& name) : name(name) {}

    void set_name(const std::string& n) { name = n; }
    std::string get_name() const { return name; }
    
    virtual void all_info() const override { std::cout << "My name is " << name << std::endl; }
    
  protected:
    std::string name;
};



int main () 
{
    // creature some_beast;   // Error: abstract class

    creature* hulk = new person("Dr Bruce Banner");
    hulk->all_info();

    return 0 ;
}

