//
// Created by A00257049 on 2019-11-25.
//

#ifndef STRATEGY_BEHAVIOR_HPP
#define STRATEGY_BEHAVIOR_HPP

#include <iostream>
using namespace std;

// Encapsulated kick behaviors
class KickBehavior
{
public:
    virtual void kick() = 0;
};

class LightningKick : public KickBehavior
{
public:
    void kick()
    {
        cout << "Lightning Kick" << endl;
    }
};

class TornadoKick : public KickBehavior
{
public:
    void kick()
    {
        cout << "Tornado Kick" << endl;
    }
};

// Encapsulated jump behaviors
class JumpBehavior
{
public:
    virtual void jump() = 0;
};

class ShortJump : public JumpBehavior
{
public:
    void jump() override
    {
        cout << "Short Jump" << endl;
    }
};

class LongJump : public JumpBehavior
{
public:
    void jump() override
    {
        cout << "Long Jump" << endl;
    }
};

#endif //STRATEGY_BEHAVIOR_HPP
