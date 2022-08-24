using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
	public class Human
	{
		public int age { get; set; } 
		public string name { get; set; } 
		public string property { get; set; } 

		public void Sleep()
		{
			Console.WriteLine("잠잠");
			Console.WriteLine(name+"잠잠");
			Console.WriteLine("살살"+age);
		}



	}
}
