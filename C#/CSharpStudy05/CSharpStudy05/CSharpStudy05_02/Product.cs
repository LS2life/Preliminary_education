using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpStudy05_02
{
    public class Product
    {
        public string Name { get; set; }
        public int Price { get; set; }
        public override string ToString()
        {
            return Name + " : " + Price + "원";
            //return base.ToString();
        }
    }
}
