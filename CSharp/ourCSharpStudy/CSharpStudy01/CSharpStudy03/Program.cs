using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpStudy03
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("1번");
            int inch = int.Parse(Console.ReadLine());
            Console.WriteLine(inch*2.54);

            Console.WriteLine("2번");
            int kg = int.Parse(Console.ReadLine());
            Console.WriteLine(kg*2.20462262);

            //원의 둘레와 넓이 구하는 것
            //수학공식을 내가 모르더라도 보통은 문제에서 준다.
            //실무에서도 내가 수학공식 몰라도
            //회사에서 주거나 아니면 내가 구글링해서 찾을 수 있다.
            Console.WriteLine("3번");
            int r = int.Parse(Console.ReadLine()); //반지름
            Console.WriteLine(2*3.14*r); //둘레
            Console.WriteLine(3.14*r*r); //넓이

            Console.WriteLine("4번");
            int num1 = int.Parse(Console.ReadLine());
            string num2 = Console.ReadLine();
            int mynum2 = int.Parse(num2);

            Console.WriteLine(num1 * (num2[2]-'0'));
            Console.WriteLine(num1 * (num2[1]-'0'));
            Console.WriteLine(num1 * (num2[0]-'0'));
            Console.WriteLine(num1 * mynum2);

            Console.WriteLine("두번째 풀이방식");
            Console.WriteLine(num1*(mynum2%10));
            Console.WriteLine(num1*((mynum2/10)%10));
            Console.WriteLine(num1*(mynum2/100));
            Console.WriteLine(num1*mynum2);



        }
    }
}
