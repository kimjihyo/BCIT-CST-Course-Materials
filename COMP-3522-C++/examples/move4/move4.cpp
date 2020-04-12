#include <iostream>
#include <string>

using namespace std;

class student
{
public:

	student() = default;
	student(const student& other) : name{other.name}
	{
		gpa = new double;
		*gpa = *(other.gpa);
	}
	student(const string name, const double gpa) : name{name}
	{
		this->gpa = new double(gpa);
	}

	student(student&& other) : name{move(other.name)}
	{
		gpa = other.gpa;
		other.gpa = nullptr;
	}

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
	// When this code is done, there are two student objects
	// but the contents of the rvalue have been 'moved'
	student first_student("Zephryn", 90.0);
	student second_student;
	second_student = std::move(first_student);

	cout << first_student << "\n";
	cout << second_student << "\n";

	return 0;
}
