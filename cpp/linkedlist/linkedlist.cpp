// linkedlist.cpp : Defines the entry point for the console application.
//

#include <iostream>

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
