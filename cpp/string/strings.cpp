#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <sstream>
#include <algorithm>

using namespace std;
class StringFunctions
{
public:

    bool Q1_2_IsPermutation(string s1, string s2)
    {
        std::sort(s1.begin(), s1.end());
        std::sort(s2.begin(), s2.end());

        if (s1.compare(s2) == 0 ) 
            return true;
        else
            return false;
    };
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

    bool Q1_5_OneEditAway(string a, string b)
    {
        int aLen = a.length();
        int bLen = b.length();
        int errCnt = 0;
        string other;

        if (std::abs(aLen - bLen) > 1)
            return false;

        if (aLen < bLen) { other = b; }
        else { other = a; a = b; }
        aLen = a.length(); 

        int aPos = 0;
        int oPos = 0;

        while (aPos < aLen)
        {
            if (a[aPos] != other[oPos])
            {
                errCnt++;
            }

            if (aLen == bLen)
            {
                aPos++;
                oPos++;
            }
            else
            {
                oPos++;
            }
            if (errCnt > 1)
            {
                return false;
            }
        }
        return true;
    }

    string Q1_6_StringCompression(string str)
    {
        if (str.length() == 0) return str;

        stringstream ss;
        char prev = str[0];
        int count = 0;
        for (char s: str)
        {
            if (s == prev)
            {
                count++;
            }
            else
            {
                ss << prev;
                ss << count;
                prev = s;
                count = 1;
            }
        }
        if (count > 1)
        {
            ss << prev;
            ss << count;
        }

        string tmp = ss.str();
        if (tmp.length() > str.length())
            return str;
        else
            return tmp;
    }

    template<size_t rows, size_t cols>
    void Q1_7_TransposeAnImage(int (&image)[rows][cols])
    {
        if (rows != cols)
        {
            throw exception("rows and columns must be equal.");
        }
        size_t N = rows;

        int tmp1, tmp2;

        for (size_t i = 0;  i < ceil(N /2)  ; ++i)
        {
            for (size_t j = i; j < N -1- i; j++)
            {                   
                tmp1 = image[j][N-1-i];
                image[j][N-1-i] = image[i][j];
                tmp2 = image[N-1-i][N-1 -j];
                image[N-1-i][N-1 -j]= tmp1;
                tmp1 = image[N- 1-j][N-1-(N-1-i)];
                image[N- 1-j][N-1-(N-1-i)]= tmp2;
                image[i][j] =tmp1;                
            }               
        }        
    }

    template<size_t R, size_t C>
    void Q1_8_ZeroMatrix(int (&mat)[R][C])
    {
        typedef std::pair<size_t, size_t> P;

        vector<P> v;
        for (size_t i = 0; i < R; ++i)
        {
            for (size_t j = 0; j < C; ++j)
            {
                if (mat[i][j] == 0)
                {
                    v.push_back(P(i,j));
                }
            }
        }

        for (P p: v)
        {
            for (size_t j = 0; j < C; ++j)
            {
                mat[p.first][j] = 0;
            }
            for (size_t i = 0; i < R; ++i)
            {
                mat[i][p.second] = 0;
            }
        }
    }

    bool Q1_9_IsRotation(string a, string b)
    {
        if (a.length() == b.length() && a.length() != 0)
        {
            string tmp = a + a;
            return (tmp.find(b) != string::npos) ? true : false;
        }
        return false;
    }
};
