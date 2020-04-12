#include <iostream>
#include <memory>

using namespace std;

static const int SOME_VALUE = 512;

int zero_buffer(int * buffer, int length)
{
	if (length < SOME_VALUE)
	{
		return -1;
	}
	for (int i = 0; i < length; ++i)
	{
		buffer[i] = 0;
	}
	return 0;
}

void first_method() {
	const int size = 256;
	int* buffer = new int[size]; //Create dynamic memory

	// PROBLEM: WHAT ABOUT EXCEPTIONS FROM zero_buffer?
	int result = zero_buffer(buffer, size);
	if(result == -1) {
		// PROBLEM: buffer NOT DELETED
	  	return;
	}
	cout << "Result: " << result << "\n";
	delete[] buffer;
}

void better_method() {
	const int size = 256;
	unique_ptr<int> buffer(new int[size]);

	int result = zero_buffer(buffer.get(), size);
	if(result == -1) {
		return; //buffer memory deleted at end of return
	}
	cout << "Result: " << result << "\n";
	//buffer memory deleted at end of scope
}

int main()
{
	better_method();
	return 0;

}