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

void Q2_1_RemoveDuplicates()
{
	// Using Utils

	LinkedListUtils llutils;	
	ListNode* head = llutils.BuildLinkedList();
	// duplicate
	ListNode* tmp = new ListNode(10);
	tmp->next = head;
	head = tmp;

	llutils.DisplayList(head);
	llutils.RemoveDuplicates(head);
	llutils.DisplayList(head);
	llutils.DeleteList(head);
	head = nullptr;
	llutils.DisplayList(head);

	// Using LinkedList class
	LinkedList lst;
	for (int i = 0; i < 10; ++i)
	{
		lst.PushBack(i*10);
	}

	lst.Display();
	lst.PushBack(10);
	lst.Display();
	lst.RemoveDuplicates();
	lst.Display();
	lst.PushBack(20);
	lst.Display();
}

int main()
{
	//TestStack();

	Q2_1_RemoveDuplicates();

	cout << "Hello from linkedlist" << endl;
	int x;
	cin >> x;

	return 0;
}
