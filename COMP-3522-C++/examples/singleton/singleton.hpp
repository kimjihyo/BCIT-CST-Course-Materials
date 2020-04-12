//
// Created by A00257049 on 2019-03-27.
//

#ifndef SINGLETON_SINGLETON_HPP
#define SINGLETON_SINGLETON_HPP
class singleton
{
public:
    static singleton& get_instance()
    {
        static singleton instance;
        return instance; // Instantiated on first use.
    }
private:
    int value;
    singleton() {} //private constructor

public:
    singleton(singleton const&)       = delete;
    void operator=(singleton const&)  = delete;

    int get_value() {
        return value++;
    }
};
#endif //SINGLETON_SINGLETON_HPP
