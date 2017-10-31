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

    class BTNode
    {
        public BTNode(int value, BTNode left, BTNode right)
        {
            this.value = value;
            this.left = left;
            this.right = right;
        }
        public int value;
        public BTNode left;
        public BTNode right;
    }

    class BST
    {
        private BTNode m_root;
        
        public BTNode AddValue(int value)
        {       
            return AddValue(ref m_root, value);                 
        }

        private BTNode AddValue(ref BTNode root, int value)
        {
            if (root == null)
            {
                root = new BTNode(value, null, null);
                return root;
            }
            else if (root.value == value)
            {
                return root;
            }
            else if (root.value > value)
            {
                return AddValue(ref root.left, value);
            }
            else
            {  
               return AddValue(ref root.right, value);
            }
        }
        
        public BTNode FindNode(int value)
        {
            return FindNode(m_root, value);
        }

        private BTNode FindNode(BTNode root, int value)
        {
            if (root == null)
            {
                return null;
            }

            if (root.value == value)
            {
                return root;
            }
            else if (root.value > value)
            {
                return FindNode(root.left, value);
            }
            else
            {
                return FindNode(root.right, value);
            }
        }

        public void PreOrderTraversal()
        {
            PreOrderTraversal(m_root);
        }

        private void PreOrderTraversal(BTNode root)
        {
            if (root == null)
            {
                Console.Write("null ");
            }
            else
            {
                Console.Write(root.value+" ");
                PreOrderTraversal(root.left);
                PreOrderTraversal(root.right);
            }
        }

        public void InOrderTraversal()
        {
            InOrderTraversal(m_root);
        }

        private void InOrderTraversal(BTNode root)
        {
            if (root == null)
            {
                Console.Write("null ");
            }
            else
            {
                InOrderTraversal(root.left);
                Console.Write(root.value + " ");
                InOrderTraversal(root.right);
            }
        }

        public void PostOrderTraversal()
        {
            PostOrderTraversal(m_root);
        }

        private void PostOrderTraversal(BTNode root)
        {
            if (root == null)
            {
                Console.Write("null ");
            }
            else
            {
                PostOrderTraversal(root.left);
                PostOrderTraversal(root.right);
                Console.Write(root.value + " ");
            }
        }

        public bool IsBST()
        {
            return IsBST(m_root, null, null);
        }

        private bool IsBST(BTNode root, BTNode minNode, BTNode maxNode)
        {
            Console.WriteLine((minNode == null) ? -1 : minNode.value);

            if (root == null)
                return true;

            if ((minNode !=null && root.value < minNode.value) || (maxNode!=null && root.value > maxNode.value))
            {
                return false;
            }

            return IsBST(root.left, minNode, root) && IsBST(root.right, root, maxNode);
        }

    }

    class A
    {
        public int value;
        public A(int value)
        {
            this.value = value;
        }
    }

    class B
    {
        public void ChangeA(A a)
        {
            a.value = 20;
        }

        public void ChangeAByRef(ref A a)
        {
            a = new A(45);
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

        static void GeneralTreeTest()
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

            DisplayTree(c, 0);
        }

        static void BSTTest()
        {

            //GeneralTreeTest();
            BST bst = new BST();
            bst.AddValue(200);
            bst.AddValue(100);
            bst.AddValue(300);
            bst.AddValue(50);
            bst.AddValue(150);
            bst.AddValue(250);
            bst.AddValue(350);
            bst.AddValue(25);
            bst.AddValue(75);
            bst.AddValue(125);
            bst.AddValue(175);
            bst.AddValue(225);
            bst.AddValue(275);
            bst.AddValue(325);
            bst.AddValue(375);

            BTNode n = bst.FindNode(25);
            Console.WriteLine(n.value + " " + n.left + " " + n.right);

            Console.WriteLine("PreOrder ->");
            bst.PreOrderTraversal();
            Console.WriteLine();

            Console.WriteLine("InOrder ->");
            bst.InOrderTraversal();
            Console.WriteLine();

            Console.WriteLine("PostOrder ->");
            bst.PostOrderTraversal();
            Console.WriteLine();

            Console.WriteLine("IsBST ->" + bst.IsBST());           
        }

        static void RefTest()
        {
            A a = new A(10);
            Console.WriteLine("before" + a.value);
            B b = new B();
            b.ChangeA(a);
            Console.WriteLine("after" + a.value);

            b.ChangeAByRef(ref a);
            Console.WriteLine("after ref" + a.value);

            A aa = null;
            b.ChangeAByRef(ref aa);
            Console.WriteLine("after ref with null" + aa.value);
        }

        static void Main(string[] args)
        {

            BSTTest();           

            int s;
            s = Console.Read();
        }
    }
}
