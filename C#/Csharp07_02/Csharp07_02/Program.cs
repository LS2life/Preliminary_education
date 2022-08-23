using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Csharp07_02
{
	internal static class Program
	{
		static void Main(string[] args)
		{
			Dog ddd = new Dog();
			ddd.name = "컹컹";
			ddd.bark();


			Student s = Student();

			Car c = new Car();
			Car c2 = new Car();

			c.carNumber = 9484;
			c2.carNumber = 2123;

			Dog d = new Dog();
			d.age = 17;
			d.name = "나나";
			d.beonho = "2020";
			d.code = "teletovi";

			Dog d2 = new Dog();
			d2.age = 1;
			d2.name = "뽀나";
			d2.beonho = "2120";
			d2.code = "teletobi";

			Dog.species = "반려견";


			List<int> numbers = new List<int>();
			numbers.Add(10);
			numbers.Add(7);
			numbers.Add(4);

			List<Dog> dogs = new List<Dog>();
			dogs.Add(d);
			dogs.Add(d2);
			dogs.Add(new Dog());
			dogs[2].age = 20;
			dogs[2].name = "부스";
			dogs[2].beonho = "1919";
			dogs[2].code = "mixx";

			List<int> myn = new List<int>();
			myn.Add(10);
			myn.Add(2);
			myn.Add(8);
			Console.WriteLine("숫자 하나 입력.");
			int num = int.Parse(Console.ReadLine());
			myn.Add(num);
			foreach (var item in myn)
			{
				Console.WriteLine(item);
			}

			List<Dog> mydogs = new List<Dog>();
			Dog md = new Dog();
			md.age = 5;
			md.name = "멍멍이";
			md.beonho = "01";
			md.code = "m01";
			mydogs.Add(md);

			mydogs.Add(new Dog() { age = 10, name = "뽀빠이", beonho = "02", code = "b02" }); ;

			Console.WriteLine("개명?");
			string name = Console.ReadLine();
			Console.WriteLine("개나이?");
			int dog_age = int.Parse(Console.ReadLine());
			Console.WriteLine("개번호?");
			string dognum = Console.ReadLine();
			Console.WriteLine("개 코드 ?");
			string dog_code = Console.ReadLine();

			Dog temp = new Dog();
			temp.name = name;
			temp.age = age;
			temp.beonho = dognum;
			temp.code = dog_code;
			mydogs.Add(temp);

			Console.WriteLine("삭제희망 숫자 입력");
			int n = int.Parse(Console.ReadLine());
			myn.Remove(n);

			Console.WriteLine("삭제희망개 나이");
			n = int.Parse(Console.ReadLine());

			for(int i = mydogs.Count-1; i>=0; i++)
			{
				if (mydogs[i].age==n)
				{
					Dog t = mydogs[i];
					mydogs.Remove(t);

					Dog tt = new Dog();
					tt.age = mydogs[i].age;

				}
			}
			



		}
	}
}
