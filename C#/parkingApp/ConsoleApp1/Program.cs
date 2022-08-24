using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
	internal class Program
	{
		static void Main(string[] args)
		{
			Human h = new Human();
			h.name = "alal";
			h.age = 23;
			h.property = "female";
			h.Sleep();

			Student s = new Student();
			s.name = "ㅁㅅㅁㅅ";
			s.age = 33;
			s.Sleep();

			s.score = 100;
			s.Study(12);

		}
	}
}
