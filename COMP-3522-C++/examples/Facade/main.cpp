#include <iostream>
using namespace std;

//sub system called by facade
class Waiter {
public:
    void writeOrder() {
        cout << "Waiter writing client order" << endl;
    }
    void sendToKitchen() {
        cout << "Waiter bring order to kitchen" << endl;
    }
    void deliverFood() {
        cout << "Waiter deliver food to client" << endl;
    }
};

//sub system called by facade
class Kitchen {
public:
    void cookFood() {
        cout << "Kitchen cooking food" << endl;
    }
    void callWaiter() {
        cout << "Kitchen calling waiter" << endl;
    }
    void cleanDishes() {
        cout << "Kitchen cleaning dishes" << endl;
    }
};

class OrderFacade {
    Waiter waiter;
    Kitchen kitchen;
public:
    void orderFood() {
        waiter.writeOrder();
        waiter.sendToKitchen();
        kitchen.cookFood();
        kitchen.callWaiter();
        waiter.deliverFood();
        kitchen.cleanDishes();
    }
};

int main() {
    //client doesn't need to know anything about order facade subsystems
    //client only interacts with order facade
    OrderFacade o;
    o.orderFood();
    return 0;
}