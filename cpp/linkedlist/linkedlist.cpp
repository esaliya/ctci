// linkedlist.cpp : Defines the entry point for the console application.
//

#include <iostream>
#include <map>

template <class T>
class Stack
{
public:
	Stack() : head(nullptr) {}

	~Stack()
	{
		Element* tmp;
		while (head != nullptr)
		{
			tmp = head;
			head = head->next;
			delete tmp;
		}
	}

	void Push(const T& value)
	{
		Element* tmp = new Element(value);

		if (head == nullptr)
		{
			head = tmp;
		}
		else
		{
			tmp->next = head;
			head = tmp;
		}
	}

	void Pop()
	{
		if (head == nullptr)
		{
			throw ("Trying to pop an empty stack.");
		}

		Element* tmp = head;
		head = head->next;
		delete tmp;
	}

	void Display()
	{
		Element* tmp = head;
		while (tmp != nullptr)
		{
			std::cout << tmp->value << ", ";
			tmp = tmp->next;
		}
		std::cout<<std::endl;
	}

private:

	struct Element
	{
		T value;
		Element* next;

		Element(const T& val) : value(val), next(nullptr) {}		
	};

	Element* head;
};


// default access modfier for struct is public, default inheritance is public as well.
// default access modfier for class is private, default inheritance is private.
struct ListNode
{
	int value;
	ListNode* next;

	ListNode(int val) : value(val), next(nullptr) {}
};


class LinkedListUtils
{
public:

	ListNode* BuildLinkedList()
	{
		// build linkedlist
		ListNode* head;
		ListNode* tail;
		ListNode* tmp;

		for (int i = 0; i < 10; ++i)
		{
			tmp = new ListNode(i * 10);

			if (i == 0)
			{
				head = tail = tmp;
			}
			else
			{
				tail->next = tmp;
				tail = tmp;
			}
		}
		return head;
	}

	void DisplayList(ListNode* node)
	{
		while (node != nullptr)
		{
			std::cout << "[" << node->value << "]->";
			node = node->next;
		}
		std::cout<<std::endl;
	}

	void RemoveDuplicates(ListNode* node)
	{
		std::map<int, bool> values;
		ListNode* prev = node;

		while (node != nullptr)		
		{
			if (values.find(node->value) != values.end())
			{
				prev->next = node->next;
				delete node;
				node = prev->next;
			}
			else
			{
				values.insert(std::pair<int, bool>(node->value, true));
				prev = node;
				node = node->next;
			}
		}
	}

	void DeleteList(ListNode* node)
	{
		ListNode* tmp;
		while (node != nullptr)
		{
			tmp = node;
			node = node->next;
			delete tmp;		
		}
	}

	ListNode* ReverseList(ListNode* head)
	{
		if (head == nullptr)
		{
			throw std::exception("List is null.");
		}
		ListNode  newHead(0);

		ListNode* tmp;
		ListNode* tmpHead;
		while (head != nullptr)
		{
			tmp = newHead.next;
			tmpHead = head->next;
			newHead.next = head;
			head->next = tmp;
			head = tmpHead;
		}

		return newHead.next;
	}
};

class LinkedList
{
private:
	struct Node
	{
		int value;
		Node* next;

		Node(int val) : value(val), next(nullptr) {}
	};

	Node* head;
	Node* tail;

public:
	LinkedList()
	{
		head = nullptr;
		tail = nullptr;
	}

	virtual ~LinkedList()
	{
		Node* tmp;
		while (head != nullptr)
		{
			tmp = head;
			head = head->next;
			delete tmp;
		}
	}

	void PushBack(int val)
	{
		Node* tmp;
		if (head == nullptr)
		{
			head = new Node(val);
			tail = head;
		}
		else
		{
			tmp = new Node(val);
			tail->next = tmp;
			tail = tmp;
		}
	}

	void Display()
	{
		Node* tmp = head;
		while (tmp != nullptr)
		{
			std::cout << "[" << tmp->value << "]->";
			tmp = tmp->next;
		}
		std::cout << std::endl;
	}

	void RemoveDuplicates()
	{
		Node* tmp = head;
		Node* prev = head;
		
		std::map<int, bool> values;

		while (tmp != nullptr)
		{
			if (values.find(tmp->value) != values.end())
			{
				prev->next = tmp->next;
				if (tmp == tail)
				{
					tail = prev;
				}
				delete tmp;
				tmp = prev->next;
			}
			else
			{
				values.insert(std::pair<int,bool>(tmp->value, true));
				prev = tmp;
				tmp = tmp->next;				
			}
		}
	}
};


