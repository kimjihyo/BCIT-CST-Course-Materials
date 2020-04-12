#include <iostream>
#include <vector>

using namespace std;
int main() {
    vector <int> v;
    v.push_back(5);
    cout << v.size() << endl;
    v.push_back(4);
    v.push_back(3);
    cout << v.size() << endl; //number of elements in vector
    cout << v.capacity() << endl; //how much total space vector has
    for(int val : v)
    {
        cout << val;
    }
    return 0;
}