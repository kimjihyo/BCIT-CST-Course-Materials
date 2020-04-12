//
// Created by A00257049 on 2019-11-25.
//

#ifndef STRATEGY_FIGHTER_HPP
#define STRATEGY_FIGHTER_HPP

#include "Behavior.hpp"
#include <iostream>
using namespace std;

// Abstract as you must have a specific fighter
class Fighter
{
    KickBehavior *kickBehavior = nullptr;
    JumpBehavior *jumpBehavior = nullptr;

public:
    Fighter(KickBehavior *kickBehavior,
               JumpBehavior *jumpBehavior)
    {
        this->jumpBehavior = jumpBehavior;
        this->kickBehavior = kickBehavior;
    }

    void punch()
    {
        cout << "Default Punch" << endl;
    }

    void kick()
    {
        // delegate to kick behavior
        if(kickBehavior != nullptr)
         kickBehavior->kick();
    }

    void jump()
    {
        // delegate to jump behavior
        if(jumpBehavior != nullptr)
            jumpBehavior->jump();
    }

    void roll()
    {
        cout << "Default Roll" << endl;
    }

    void setKickBehavior(KickBehavior *kickBehavior)
    {
        this->kickBehavior = kickBehavior;
    }

    void setJumpBehavior(JumpBehavior *jumpBehavior)
    {
        this->jumpBehavior = jumpBehavior;
    }
    virtual void display() = 0;
};


// Characters
class Ryu : public Fighter
{
public:
    Ryu(KickBehavior *kickBehavior, JumpBehavior *jumpBehavior) : Fighter(kickBehavior, jumpBehavior) {}
public:
    void display() { cout << "Ryu" << endl; }
};

class Ken : public Fighter
{
public:
    Ken(KickBehavior *kickBehavior, JumpBehavior *jumpBehavior) : Fighter(kickBehavior,jumpBehavior){}
public:
    void display()
    {
        cout << "Ken" << endl;
    }
};

class ChunLi : public Fighter
{
public:
    ChunLi(KickBehavior* kickBehavior, JumpBehavior* jumpBehavior) : Fighter(kickBehavior,jumpBehavior) {}

public:
    void display()
    {
        cout << "ChunLi" << endl;
    }
};
#endif //STRATEGY_FIGHTER_HPP
