using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace leet
{
    class Roman
    {
        static Dictionary<char, int> values = new Dictionary<char, int>()
        {
            {'I', 1 },
            {'V', 5 },
            {'X', 10 },
            {'L', 50 },
            {'C', 100 },
            {'D', 500 },
            {'M', 1000 }
        };

        public int RomanToInt(string str)
        {
            if (str == null || str.Length == 0)
            {
                throw new ArgumentException("Empty roman string.");
            }

            int r = 0;

            int v1 = 0;
            int v2 = 0;
            for (int i = 0; i < str.Length; ++i)
            {
                v2 = 0;
                v1 = values[str[i]];
                if (i < str.Length - 1)
                {
                    v2 = values[str[i + 1]];
                }

                if (v1 >= v2)
                {
                    r += v1;
                }
                else
                {
                    r += v2 - v1;
                    ++i;
                }
            }

            return r;
        }
    }
    
    class MyClass
    {
        public int value;
        public string name;

        public MyClass(int v, string n)
        {
            this.value = v;
            this.name = n;
        }
    }

    class Msc
    {
        public void TestObject(MyClass obj)
        {
            obj.value = 10;
            obj.name = "hello";
        }        
    }

    class CountPaths
    {
        public int LengthLongestPath(string input)
        {
            string[] tokens = input.Split('\n');
            int result = 0;
            int curLen = 0;
            Stack<int> stack = new Stack<int>();

            foreach (string s in tokens)
            {
                int level = CountLevel(s);

                // if current directory/file depth is lower that the top directory/file on the stack, pop from stack 
                while (stack.Count() > level)
                {
                    curLen -= stack.Pop();
                }

                // +1 here because a "/" needs to be counted following each diretory
                int len = s.Replace("\t", "").Length + 1;
                curLen += len;

                // if s contains ".", we have found a file!
                if (s.Contains("."))
                {
                    result = curLen - 1 > result ? curLen - 1 : result;
                }
                stack.Push(len);
            }
            return result;
        }

        private int CountLevel(string s)
        {
            String cur = s.Replace("\t", "");
            return s.Length - cur.Length;
        }

    }

    class Solution
    {
        static void TestRoman()
        {
            Roman roman = new Roman();
            Console.WriteLine("IV =" + roman.RomanToInt("VI"));
            Console.WriteLine("XIV =" + roman.RomanToInt("XVI"));
            Console.WriteLine("XIX =" + roman.RomanToInt("XIX"));
            Console.WriteLine("DCCCXXXVIII =" + roman.RomanToInt("DCCCXXXVIII"));
        }
        
        static void TestObjects()
        {
            MyClass mc = new MyClass(20, "jaliya");
            Console.WriteLine(mc.value + "  " + mc.name);
            Msc m = new Msc();
            m.TestObject(mc);
            Console.WriteLine(mc.value + "  " + mc.name);
        }

       


        static void StringSplitTest()
        {
            string s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
            
            string[] split = s.Split('\n', '\t');
            foreach (string ss in split)
            {
                Console.WriteLine(ss);
            }
        }

        static void LongestPathTest()
        {
            string s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
            CountPaths cp = new CountPaths();
            Console.WriteLine(cp.LengthLongestPath(s));
        }

        static void Main(string[] args)
        {
            //TestRoman();
            //TestObjects();
            //StringSplitTest();
            LongestPathTest();
            int x = 0;
            x = Console.Read();            
        }
    }
}
