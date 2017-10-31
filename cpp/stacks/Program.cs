using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace stacks
{
    class Stack<T>
    {
        private class StackNode<U>
        {
            public StackNode(U value)
            {
                this.value = value;
                this.next = null;
            }

            public U value;
            public StackNode<U> next;
        }

        public Stack()
        {
            this.head = null;
        }

        public void Push(T value)
        {
            StackNode<T> tmp = new StackNode<T>(value);
            tmp.next = head;
            head = tmp;
        }

        public T Pop()
        {
            if (head == null)
            {
                throw new Exception("Empty stack");
            }

            T tmp = head.value;
            head = head.next;
            return tmp;
        }

        public T Peek()
        {
            if (head == null)
            {
                throw new Exception("Empty stack");
            }

            return head.value;
        }

        public bool IsEmpty()
        {
            return head == null;
        }

        public void Display()
        {
            StackNode<T> tmp = head;
            while (tmp != null)
            {
                Console.WriteLine(tmp.value + "->");
                tmp = tmp.next;
            }
            Console.WriteLine();
        }

        StackNode<T> head;
    }


    class Program
    {
        static void Main(string[] args)
        {
            Stack<int> stack = new Stack<int>();
            stack.Push(10);
            stack.Push(20);
            stack.Push(30);
            stack.Push(40);
            stack.Push(50);
            stack.Push(60);
            stack.Display();
            Console.WriteLine("Peeking " + stack.Peek());
            stack.Display();
            Console.WriteLine("Poping " + stack.Pop());
            stack.Display();
            Console.WriteLine("IsEmpty " + stack.IsEmpty());

            int x = 0;
            x = Console.Read();
        }
    }
}
