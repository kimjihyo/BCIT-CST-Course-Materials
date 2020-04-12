#include <iostream>

int main()
{
	int * a = new int[5];
	int size_dynamic_array = sizeof(a);

	int b [5];
	int size_static_array = sizeof(b);
	int size_static_array_element = sizeof b[0];
	int num_elements_array = size_static_array / size_static_array_element; //20 / 4 = 5

	std::cout << "Pointer has size " << size_dynamic_array << std::endl;
	std::cout << "Array has size " << size_static_array << std::endl;
	std::cout << "Array element has size " << size_static_array_element << std::endl;
	std::cout << "Array num elements " << num_elements_array << std::endl;
}