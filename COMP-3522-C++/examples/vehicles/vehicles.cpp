#include <iostream>
/*
 * virtual keyword not necessary in children
 * can include override keyword for virtual functions for safety
 * polymorphic << overload with separate virtual print function
 * */

using namespace std;

class vehicle
{
	public:
		vehicle() { cout << "Creating a vehicle!\n"; }
		~vehicle() { cout << "Destroying a vehicle!\n"; }

		virtual void accelerate() = 0;
		virtual void decelerate() = 0;
		virtual ostream& output(ostream& os) const;
		friend ostream& operator<<(ostream& os, const vehicle& v);
};

ostream& vehicle::output(ostream& os) const
{
	os << "I'm a vehicle!\n";
	return os;
}

ostream& operator<<(ostream& os, const vehicle& v)
{
	return v.output(os);
}

class bicycle : public vehicle
{
	public:
		bicycle() { cout << "Creating a bicycle!\n"; }
		~bicycle() { cout << "Destroying a bicycle!\n"; }

		virtual void accelerate() { cout << "PEDAL FASTER!\n"; }
		virtual void decelerate() { cout << "SLOW DOWN!\n"; }
		virtual ostream& output(ostream& os) const;
		//friend ostream& operator<<(ostream& os, const vehicle& v);
};

ostream& bicycle::output(ostream& os) const
{
	os << "I'm a bike!\n";
	return os;
}

int main()
{
	bicycle my_bike;
	vehicle& my_vehicle = my_bike;
	my_vehicle.accelerate();
	cout << my_vehicle;
}