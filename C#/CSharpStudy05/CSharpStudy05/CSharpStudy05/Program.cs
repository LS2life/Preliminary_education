using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpStudy05
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //배열, List
            //Stack이나 Queue도 있다.

            //배열 : 미리 크기를 지정해야 함
            int[] numbers1 = new int[5];

            //리스트 : 크기를 미리 지정하지 않음
            List<int> numbers2 = new List<int>();
            numbers2.Add(10);
            numbers2.Add(100);
            numbers2.Insert(1, 200);
            numbers2.Remove(10);
            foreach (var item in numbers2)
            {
                Console.WriteLine(item);
            }
            Stack<int> numbers3 = new Stack<int>();
            numbers3.Push(1000);
            int temp = numbers3.Pop();
            Queue<int> numbers4 = new Queue<int>();
            numbers4.Enqueue(10);
            temp = numbers4.Dequeue();

            List<int> ex = new List<int>();
            ex.Add(10);
            ex.Add(15);
            ex.Add(20);
            ex.Add(25);
            ex.Add(30);
            ex.Add(35);

            List<int> myeven = new List<int>();
            foreach (var item in ex)
            {
                if (item % 2 == 0)
                    myeven.Add(item);
            }
            foreach(var item in myeven)
                Console.WriteLine(item);


            //LINQ
            //SQL문을 사용하여 List에서 내가 원하는 걸 뽑아 낼 수 있다.
            var myoutput = from ㅁㅁ in ex where ㅁㅁ % 2 != 0 select ㅁㅁ;
            foreach (var item in myoutput)
            {
                Console.WriteLine(item);
            }

            List<int> myodd = (from item in ex where item % 2 != 0 select item).ToList<int>();
            foreach(var item in myodd)
                Console.WriteLine(item);
            Console.WriteLine("익명 객체 테스트");
            var output = from item in ex
                         where item % 2 == 0
                         select new
                         {
                             level=item * 2,
                             power = item/2,
                             money = item*item
                         };

            foreach(var item in output)
            {
                Console.WriteLine(item.level);
                Console.WriteLine(item.power);
                Console.WriteLine(item.money);
            }
        }
    }
}
