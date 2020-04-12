#include <iostream>
#include <assert.h>

struct Rectangle {
    int width;
    int height;

    virtual void setW(int w){
        width = w;
    }

    virtual void setH(int h){
        height = h;
    }
    int area() {
        return width*height;
    }
};

struct Square : public Rectangle {
    void setW(int w) override {
        height = width = w;
    }

    void setH(int h) override {
        height = width = h;
    }
};

//does not conform to Liskov Substitution Principle, can't pass in square
void area(Rectangle &r)
{
    r.setW(5); //sets height & width 5
    r.setH(2); //sets height & width 2
    assert(r.area() == 10); // Error area = 4
}

int main() {
    Square s;
    Rectangle r;

    area(s); //ERROR
    area(r); //OK!

    return 0;
}