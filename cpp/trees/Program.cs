using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace trees
{
    class Node
    {
        private Node[] children;
        private int value;

        public Node(Node[] children, int value)
        {
            this.children = children;
            this.value = value;
        }

        public Node GetChild(int index)
        {
            if (children == null)
            {
                throw new Exception("The node has no children.");
            }

            if (index >= children.Length)
            {
                throw new IndexOutOfRangeException("Child index is out of bounds.");
            }

            return children[index];
        }

        public int GetValue()
        {
            return value;
        }

        public void SetValue(int value)
        {
            this.value = value;
        }
        
        public int GetNumChildren()
        {
            if (children == null)
            {
                return 0;
            }
            return children.Length;
        }        
    }

    class Program
    {
        struct StrcutNode
        {
            public int value;
        };

        static void DisplayTree(Node root, int level)
        {
            if (root == null)
            {
                return;
            }

            Console.WriteLine("[" + level+"] "+ root.GetValue());
            for(int i = 0; i < root.GetNumChildren(); ++i)
            {
                DisplayTree(root.GetChild(i), root.GetValue());
            }
        }

        static void Main(string[] args)
        {
            /*
            int[] values = new int[10];
            Console.WriteLine(values[0]);

            Program.StrcutNode[] ss = new Program.StrcutNode[10];
            ss[0].value = 20;
            */

            Node[] aChildren = new Node[3];
            aChildren[0] = new Node(null, 10);
            aChildren[1] = new Node(null, 20);
            aChildren[2] = new Node(null, 30);

            Node a = new Node(aChildren, 40);

            Node[] bChildren = new Node[3];
            bChildren[0] = new Node(null, 50);
            bChildren[1] = new Node(null, 60);
            bChildren[2] = new Node(null, 70);

            Node b = new Node(bChildren, 80);

            Node[] cChildren = new Node[2];
            cChildren[0] = a;
            cChildren[1] = b;

            Node c = new Node(cChildren, 90);

            DisplayTree(c,0);


            int s;
            s = Console.Read();
        }
    }
}
