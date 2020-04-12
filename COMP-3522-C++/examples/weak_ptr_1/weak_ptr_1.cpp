#include <iostream>
#include <memory>

// GLOBALS ARE BAD
// BUT THIS IS JUST AN EXAMPLE
std::weak_ptr<int> gw;
 
void observe()
{
    //indicates how many shared pointers, excluding weak pointers managing object
    std::cout << "use_count == " << gw.use_count() << ": ";

    // Has to be copied into a shared_ptr before usage
    if (std::shared_ptr<int> spt = gw.lock()) {
	   std::cout << *spt << "\n";
    }
    else {
        std::cout << "gw is expired\n";
    }
}
 
int main()
{
    // A block inside a block to define a nested scope
    {
        std::shared_ptr<int> sp = std::make_shared<int>(42);
        gw = sp;
        observe();
    }

    //outside scope of block, there is no shared pointer so gw pointer expired
    observe();
}