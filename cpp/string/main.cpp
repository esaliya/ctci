#include <iostream>
#include <string>
#include <vector>
#include "strings.cpp"

using namespace std;

void Q1_4()
{
    vector<string> v;
    v.push_back("aaa");
    v.push_back("aabb");
    v.push_back("aacbb");
    v.push_back("aabc");
    v.push_back("");

    StringFunctions sf;
    for (string s : v){
        cout<<"string "<<s<<" is "<<(sf.Q1_4_PalindromePermutation(s) ? "a ":"not a ")<<"permutation of a palindrome."<<endl;
    }
};

int main(int argc, char* argv[])
{
    Q1_4();
    cout<<"hello"<<endl;
    int x =0 ;
    cin >> x;
    return 0;
}
