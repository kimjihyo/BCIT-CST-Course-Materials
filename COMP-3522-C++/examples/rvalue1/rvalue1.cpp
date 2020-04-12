double get_average()
{
	double average = 0.0;
	// Calculates stuff
	return average; // 0 that's sent back is actually an rvalue
}
int main()
{
	int number = 10;

	number = 88;
	int &numberRef = number;

	int&& rNumber = number; // Error, number is an lvalue
	int&& rNumber1 = 10; // OK, 10 is a rvalue
	double&& rAverage = get_average(); // OK, get_average() is a rvalue
	int anotherNum = get_average();
}
