using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace msc_csharp
{
    class Program
    {
        static void Main(string[] args)
        {

            if (args.Length != 1)
            {
                throw new ArgumentException("Needs the prefix as an input");
            }
                string[] fileEntries = Directory.GetFiles(Directory.GetCurrentDirectory());
            foreach (string fileName in fileEntries)
            {
                System.IO.File.Move(fileName, args[0] +"_"+ fileName);
            }
                
        }
    }
}
