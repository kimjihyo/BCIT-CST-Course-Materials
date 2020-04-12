#include <vector>

using namespace std;

vector<double> convert(const vector<double>& scores)
{
	vector<double> percentages;
    
    for (vector<double>::const_iterator it = scores.begin(); it != scores.end(); ++it)
    {
        // Do stuff
    }
    return percentages;
}

int main()
{
    int x = 5;
    int &&ref = x;
    std::vector<double> scores; 
    // Do stuff
    //Before C++ 11 - convert returns copy, and assignment operator does another copy
    //Before C++ 11 there was no Copy elision/RVO
    scores = convert(scores);
    // Do stuff
}
