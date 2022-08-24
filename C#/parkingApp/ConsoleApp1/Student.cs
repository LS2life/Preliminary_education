using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
	public class Student : Human
	{
		public int score;
		public void Study(int hour)
		{
			Console.WriteLine(score + "점을 받음.");
			Console.WriteLine(hour + "만큼 공부함.");
		}

	}
}
