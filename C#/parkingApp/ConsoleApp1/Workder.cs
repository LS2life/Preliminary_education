using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
	public class Workder : Human
	{
		public int pay { get; set; }
		public int Work() 
		{
			if (pay==0)
				Console.WriteLine("열정 페이 ");
			else
				Console.WriteLine(pay +"만큼 일하자.");
			return pay*30; 

		}
	}
}
