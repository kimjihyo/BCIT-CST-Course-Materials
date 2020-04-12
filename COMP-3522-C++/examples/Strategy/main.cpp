#include <iostream>
#include "Fighter.hpp"
#include "Behavior.hpp"

//adapted from https://www.geeksforgeeks.org/strategy-pattern-set-2/
int main() {
    // let us make some behaviors first
    JumpBehavior* shortJump = new ShortJump;
    JumpBehavior* longJump = new LongJump;
    KickBehavior* tornadoKick = new TornadoKick;

    // Make a fighter with desired behaviors
    Fighter *ken = new Ken(tornadoKick, shortJump);
    ken->display();

    // Test behaviors
    ken->punch();
    ken->kick();
    ken->jump();

    // Change behavior dynamically (algorithms are
    // interchangeable)
    ken->setJumpBehavior(longJump);
    ken->jump();
    return 0;
}