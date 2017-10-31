#include <iostream>
#include <string>
#include <vector>
#include <map>
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

void Q1_5()
{
    map<string, string> m;
    m.insert(std::pair<string, string>("pale", "pal"));
    m.insert(std::pair<string, string>("pales", "pale"));
    m.insert(std::pair<string, string>("sale", "dale"));
    m.insert(std::pair<string, string>("tale", "bake"));

    StringFunctions sf;
    for (map<string, string>::iterator it = m.begin(); it != m.end(); it++){
        cout<<"string "<<it->first<<" and "<<it->second<<" are "<<(sf.Q1_5_OneEditAway(it->first, it->second) ? "":"not ")<<"one edit away."<<endl;
    }
}

void Q1_6()
{
    vector<string> v;
    v.push_back("aaaa");
    v.push_back("aabbccdd");
    v.push_back("aacbbeeee");
    v.push_back("abcd");
    v.push_back("");

    StringFunctions sf;
    for (string s : v){
        cout<<"compressed string of "<<s<<" is "<<sf.Q1_6_StringCompression(s)<<endl;
    }
} 

void Q1_7()
{
    const int N = 5;
    int image[N][N];
    for (int i = 0;  i < N; ++i)
    {
        for (int j = 0; j < N; j++)
        {
            image[i][j] = i;
            cout<<image[i][j]<<" ";
        }
        cout<<endl;
    }

    cout<<endl<<endl;

    StringFunctions sf;
    sf.Q1_7_TransposeAnImage<N,N>(image);
    for (int i = 0;  i < N; ++i)
    {
        for (int j = 0; j < N; j++)
        {                
            cout<<image[i][j]<<" ";
        }
        cout<<endl;
    }
}

void Q1_8()
{
    const int N = 5;
    int mat[N][N];
    for (int i = 0;  i < N; ++i)
    {
        for (int j = 0; j < N; j++)
        {
            mat[i][j] = i+1;          
        }
    }

    mat[2][3] = 0;
    mat[4][1] = 0;

    for (int i = 0;  i < N; ++i)
    {
        for (int j = 0; j < N; j++)
        {
            cout<<mat[i][j]<<" ";     
        }
        cout<<endl;
    }

    cout<<endl<<endl;

    StringFunctions sf;
    sf.Q1_8_ZeroMatrix<N,N>(mat);
    for (int i = 0;  i < N; ++i)
    {
        for (int j = 0; j < N; j++)
        {                
            cout<<mat[i][j]<<" ";
        }
        cout<<endl;
    }
}

void Q1_9()
{
    map<string, string> m;
    m.insert(std::pair<string, string>("waterbottle", "erbottlewa"));
    m.insert(std::pair<string, string>("caterbottle", "erbottlecat"));
    m.insert(std::pair<string, string>("mail", "ilma"));

    StringFunctions sf;
    for (map<string, string>::iterator it = m.begin(); it != m.end(); it++){
        cout<<"string "<<it->first<<" and "<<it->second<<" are "<<(sf.Q1_9_IsRotation(it->first, it->second) ? "":"not ")<<"a rotaion."<<endl;
    }
}

int main(int argc, char* argv[])
{
    //Q1_4();
    //Q1_5();
    //Q1_6();
    //Q1_7();
    //Q1_8();
    Q1_9();
    cout<<"hello"<<endl;
    int x =0 ;
    cin >> x;
    return 0;
}
