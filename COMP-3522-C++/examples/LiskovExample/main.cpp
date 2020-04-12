#include <iostream>

class LivingEntity {};
class Animal : LivingEntity {};
class Cat : Animal {};

class AnimalShelter {
public:
    LivingEntity e;
    void adopt();
    virtual AnimalShelter *clone() { return new AnimalShelter{*this}; }
    virtual void add_animal(Animal *a){};
};

class CatShelter : public AnimalShelter{
public:
    Animal a;
    void adopt();
    virtual CatShelter *clone() override { return new CatShelter{*this}; }
    void add_animal(LivingEntity *a) override {}; //becomes an overloaded function, doesn't override add_animal
};

int main() {
    CatShelter *d1 = new CatShelter();
    AnimalShelter * b = d1->clone();
    CatShelter *d2 = dynamic_cast<CatShelter *>(b);
    if(d1) {
        std::cout << "cloned";
    }
    return 0;
}