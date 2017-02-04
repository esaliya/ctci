#include <iostream>
#include <string>
#include <vector>
#include <map>

using namespace std;
class StringFunctions
{
public:
    bool Q1_4_PalindromePermutation(string str)
    {
        if (str.length() == 0)
        {
            return true;
        }

        map<char,int> mmap;
        for(char c: str)
        {
            if (mmap.find(c) != mmap.end())
            {
                mmap[c]++;
            }
            else
            {
                mmap.insert(pair<char, int>(c,1));
            }
        }

        int evenCount = 0;
        int oddCount = 0;

        for(map<char, int>::iterator it = mmap.begin(); it != mmap.end(); ++it)
        {
            if (it->second % 2 == 0)
            {
                evenCount++;
            }
            else
            {
                oddCount++;
            }
        }

        if (oddCount == 0 || oddCount == 1)
        {
            return true;
        }
        else
        {
            return false;
        } 
    }
};
