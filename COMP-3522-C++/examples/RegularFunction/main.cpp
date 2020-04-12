#include <iostream>

using namespace std;

struct Animal {
    int age;
    Animal(int age) : age(age){}
    bool operator>(Animal other) {
        return age > other.age;
    }
};

template <typename T>
bool greaterThan(T x, T y) {
    return x > y;
}

int main() {
    int x = 0;
    int y = 1;
    string a = "aaa";
    string b = "bbb";
    Animal cat(0);
    Animal dog(2);

    cout << boolalpha;
    cout << greaterThan<int>(x,y) << endl;
    cout << greaterThan<string>(a,b) << endl;
    cout << greaterThan<Animal>(cat,dog) << endl;

    return 0;
}