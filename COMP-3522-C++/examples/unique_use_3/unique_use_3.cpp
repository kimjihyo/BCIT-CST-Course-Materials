#include <iostream>
#include <memory>
#include <vector>

using namespace std;

class student
{
public:
	//copy constructor
	student(const student& other) : name{other.name}
	{
		gpa = new double;
		*gpa = *(other.gpa);
	}
	//constructor
	student(const string name, const double gpa) : name{name}
	{
		this->gpa = new double(gpa);
	}

	//move copy constructor
	student(student&& other) : name{move(other.name)}
	{
		gpa = other.gpa;
		other.gpa = nullptr;
	}

	//move assignment
	student& operator=(student&& other)
	{
		name = move(other.name);
		gpa = other.gpa;
		other.gpa = nullptr;
		return *this;
	}

	~student() { if (gpa) { delete gpa; } }

	friend ostream& operator<<(ostream& os, const student&);
private:
	std::string name;
	double * gpa;
};

ostream& operator<<(ostream& os, const student& s)
{
	os << s.name;
	if (s.gpa != nullptr)
	{
		os << " " << *(s.gpa);
	}
	os << "\n";
	return os;
}

int main()
{
	std::vector<unique_ptr<student> > v;

	v.push_back(unique_ptr<student>(new student("Jeff", 92.4)));
	v.emplace_back(new student("Jason", 90.0)); // NEATO! auto converts new student object to unique pointer
	//v.push_back(new student("Jason", 90.0)); //doesn't work...expecting unique_ptr type

	student* m = v.front().get();
	cout << *m;
	
	cout << *(v.back());

}