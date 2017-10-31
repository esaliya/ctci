using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace queues
{

    class Queue<T>
    {
        private class QueueNode<U>
        {
            public QueueNode(U value)
            {
                this.value = value;
            }

            public QueueNode<U> next;
            public U value;
        }

        public Queue()
        {
            this.tail = null;
            this.head = null;
        }

        public void Add(T value)
        {
            QueueNode<T> tmp = new QueueNode<T>(value);
            if(tail == null)
            {
                tail = tmp;
                head = tail;
            }
            else
            {               
                tail.next = tmp;
                tail = tmp;
            }            
        }

        public T Remove()
        {
            if (head == null)
            {
                throw new Exception("Empty queue.");
            }

            T tmp = head.value;
            head = head.next;
            return tmp;
        }

        public bool IsEmpty()
        {
            return head == null;
        }

        public T Peek()
        {
            if (head == null)
            {
                throw new Exception("Empty queue.");
            }

            return head.value;
        }

        public void Display()
        {
            QueueNode<T> tmp = head;
            while (tmp != null)
            {
                Console.Write(tmp.value + "->");
                tmp = tmp.next;
            }
            Console.WriteLine();
        }

        private QueueNode<T> tail;
        private QueueNode<T> head;
    }

    class Program
    {
        static void Main(string[] args)
        {
            Queue<int> q = new Queue<int>();
            q.Add(10);
            q.Add(20);
            q.Add(30);
            q.Add(40);
            q.Add(50);
            q.Display();
            Console.WriteLine("Peeking " + q.Peek());
            Console.WriteLine("Removing " + q.Remove());
            q.Display();
            Console.WriteLine("IsEmpty " + q.IsEmpty());
            int x = 0;
            x = Console.Read();
        }
    }
}
