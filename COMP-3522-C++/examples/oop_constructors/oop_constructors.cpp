#include <iostream>
#include <string>

/*
 * Inheritance doesn't inherit constructor (along with some other things)
 * use the using::parent_class::parent_constructor line to inherit constructors
 */

class person 
{
  public:
    person() = default;
    person(const std::string& name) : name(name) {}

    void set_name(const std::string& n) { name= n; }
    std::string get_name() const { return name; }
    void all_info() const { std::cout << "[person name=" << name << "]" << std::endl; }
    
  private:
    std::string name;
};


class student : public person
{
  public:
    student() = default;
    student(const std::string& name, const std::string& passed) 
      : person(name), passed(passed) {}
    void all_info() const { 
	     std::cout << "My name is " << get_name() << std::endl; 
       std::cout << "I passed the following class: " << passed << std::endl;
    }
  private:
    std::string passed;
};

////won't compile, doesn't inherit default constructor
// class cst_student : public student
// {
//   public:
//     cst_student(const std::string& name, const std::string& passed)
//       : student(name, passed) {}
//     void print() { std::cout << "C++ is great!"; }
// };

class cst_student : public student
{
    using student::student;
    //add additional data members and functions specific to cst student
public:
    void print() { std::cout << "C++ is great!"; }
};


int main () 
{
    student xavier("Xavier X", "Data Mining");
    xavier.all_info();

    cst_student noinput;
    noinput.all_info();
    noinput.print();

    return 0 ;
}
