#include <iostream>

#include "linkedlist.cpp"

using namespace std;

//void CopyOrNot(MyType t)
//{
//	cout << "CopyOrNot with value is called" << endl;
//}
//
//void CopyOrNot2(MyType& t)
//{
//	cout << "CopyOrNot with ref is called" << endl;
//}

void TestStack()
{	
	//MyType t(10);
	//CopyOrNot(t);

	//MyType t2(20);
	//CopyOrNot2(t2);
	
	class MyType
	{
	public:
		MyType(int v) : value(v) {}
		MyType(const MyType& other) : value(other.value)
		{
			std::cout << "Copy is called" << std::endl;
		}
		int value;
	};

	Stack<MyType*> st;
	for (int i = 0; i < 10; ++i)
	{
		st.Push(new MyType(i * 100));
	}
	st.Display();
	st.Pop();
	st.Pop();
	st.Display();
}

int main()
{
	TestStack();

	cout << "Hello from linkedlist" << endl;
	int x;
	cin >> x;

	return 0;
}
